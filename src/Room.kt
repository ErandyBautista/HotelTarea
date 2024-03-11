class Room (
    val priceNight : Double,
    val capacity : Int,
    val roomNumber : Int,
    val isAvaliable : Boolean = true
)
{
    fun getRoomData() : String{
        return "Número de habitación: $roomNumber Precio por noche:  $priceNight Capacidad: $capacity Disponible: ${if (isAvaliable)"Si" else "No"}"
    }
}

