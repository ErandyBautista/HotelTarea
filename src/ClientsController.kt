class ClientsController {
    private val printer = Printer()
    private val clientsList = mutableListOf<Customer>(
        Customer(
            "Brisa",
            "Waves",
            "Chuc",
            "FJFJHSKASLKM9",
            "SM 109 MZ 9 LT1"
        )
    )
    fun registerCustomer(){
        printer.printMsg("Ingrese los nombres: ")
        val names = readln()
        printer.printMsg("Ingrese el primer apellido: ")
        val firstLastName = readln()
        printer.printMsg("Ingrese el segundo apellido: ")
        val secondLastName = readln()
        printer.printMsg("Ingrse el RFC: ")
        val rfc = readln()
        printer.printMsg("Ingrese la dirrección: ")
        val address = readln()

        val addedCustomer = Customer( names, firstLastName, secondLastName, rfc, address)
        clientsList.add(addedCustomer)
    }

    fun showCustomer(){
        if (clientsList.isEmpty()){
            printer.printMsg("No se encuentran clientes registrados")
        }
        else{
            var counter = 1
            for (customer in clientsList){
                printer.printMsg("$counter" + customer.getCustomerData())
                counter++
            }
        }
    }
    fun getCustomerByIndex(index : Int) : Customer = clientsList[index]
    fun areNotClientsRegistered() : Boolean = clientsList.isEmpty()
}
