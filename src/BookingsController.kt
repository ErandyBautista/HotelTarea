class BookingsController {
    private val printer = Printer()
    private val bookingList = mutableListOf<Booking>()

    fun createBooking(customer: Customer, room: Room){
        printer.printMsg("Ingrese la fecha de inicio: ")
        val startDate = readln()
        printer.printMsg("Ingrese la fecha de salida: ")
        val endDate = readln()
        printer.printMsg("Ingrese el número de noches: ")
        val totalNights = readln().toInt()
        val addedBooking = Booking(room, customer, startDate, endDate, totalNights, false)

        addedBooking.calculatePrice()
        customer.addBooking(addedBooking)
        bookingList.add(addedBooking)
    }

    fun showBookings(){
        if (bookingList.isEmpty()){
            printer.printMsg("No hay habitaciones registradas")
        }
        else{
            var counter = 1
            for (booking in bookingList){
                printer.printMsg("$counter"+ booking.getBookingData())
                counter++
            }
        }
    }
}