class RoomsController {
    private val printer = Printer()
    private val roomList = mutableListOf<Room>()

    fun registerRoom(){
        printer.printMsg("Ingrese el precio por noche: ")

        val priceNight = readln().toDouble()
        printer.printMsg("Ingrese la capacidad: ")
        val capacity : Int = readln().toInt()
        printer.printMsg("Ingrese el número de habitación: ")
        val roomNumber : Int = readln().toInt()
        val isAvaliable = true

        val addedRoom = Room(priceNight, capacity, roomNumber, isAvaliable)
        roomList.add(addedRoom)
    }

    fun modifyRoom(){}
    fun getRoomByIndex(index : Int): Room{
        return roomList[index]
    }
    fun showRooms(){
        if (roomList.isEmpty()){
            printer.printMsg("No se encuentran habitaciones registradas")
        }
        else{
            var counter = 1
            for (room in roomList){
                printer.printMsg("$counter"+ room.getRoomData())
                counter++
            }
        }
    }
    fun areNotRoomsRegistered() : Boolean = roomList.isEmpty()
}