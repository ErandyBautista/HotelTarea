import kotlin.text.toInt as toInt

class MenuController {
    private val printer = Printer()
    private val bookingsController = BookingsController()
    private val customerController = ClientsController()
    private val roomsController = RoomsController()

    fun showMenu(){
        printer.apply {
            printMsg("Ingrese una opción")
            printMsg("1. Registrar habitación")
            printMsg("2. Registrar cliente")
            printMsg("3. Crear reserva")
            printMsg("4. Mostrar habitaciones")
            printMsg("5. Mostrar clientes")
            printMsg("6. Mostrar reservas")

            val selectedOption = readln().toInt()
            validateOptions(selectedOption)
        }
    }

    private fun validateOptions(selectedOption : Int){
        when(selectedOption){
            1-> {
                roomsController.registerRoom()
                showMenu()
            }
            2-> {
                customerController.registerCustomer()
                showMenu()
            }
            3-> {
                selectCustomerAndClient()
                showMenu()
            }
            4-> {
                roomsController.showRooms()
                showMenu()
            }
            5-> {
                customerController.showCustomer()
                showMenu()
            }
            6-> {
                bookingsController.showBookings()
                showMenu()
            }
        }
    }
    private fun selectCustomerAndClient(){
        if (customerController.areNotClientsRegistered()){
            printer.printMsg("No se encuentran clientes registrados")
            showMenu()
            return
        }
        if (roomsController.areNotRoomsRegistered()){
            printer.printMsg("No se encuentran habitaciones registradas")
            showMenu()
            return
            }
        printer.printMsg("Selecciona un cliente: ")
        customerController.showCustomer()
        val selectedCustomerIndex = readln().toInt()
        val customer = customerController.getCustomerByIndex(selectedCustomerIndex - 1)

        printer.printMsg("Seleccione una habitación: ")
        roomsController.showRooms()
        val selectedRoomIndex = readln().toInt()
        val room = roomsController.getRoomByIndex(selectedRoomIndex - 1)

        bookingsController.createBooking(customer, room)
    }
}
