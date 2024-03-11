class Booking (
    private val room: Room,
    val customer : Customer,
    private val startDate : String,
    private val endDate : String,
    private var totalNights : Int,
    private var isCancelled : Boolean,
)
{
    private var totalPrice=0.0

    fun calculatePrice(){
        totalPrice = room.priceNight * totalNights
    }

    fun cancelBooking(){
        isCancelled = true
    }

    fun updateNights(totalNights: Int){
        this.totalNights = totalNights
    }

    fun getTotal() : Double = totalPrice

    fun getBookingData() : String { return "Nombre del cliente ${customer.getCustomerData()} "
                "Total de noches: $totalNights "
                "Fecha de inicio : $startDate "
                "Fecha final: $endDate "
                "Total : $totalPrice"
    }
}