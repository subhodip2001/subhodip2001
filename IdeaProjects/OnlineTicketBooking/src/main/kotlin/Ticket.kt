import java.sql.DriverManager

data class Ticket(val Ticket_ID: Int, val Ticket_Number: String, val Passenger_ID: Int, val Train_ID: Int,val Ticket_Price:Int)
fun main(args: Array<String>) {
    val c=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineTicketBooking","root","2001")
    println(c.isValid(0))


    //Insertion query
    val res=c.createStatement().executeUpdate("insert into Ticket values(3,'00596',003,2,900)")
    if(res>0) {
        println("Successfully Inserted")
    }else{
        println("Insertion failed!!")
    }

    //Select query - Read
    val result=c.prepareStatement("select * from Ticket").executeQuery()
    val tickets=mutableListOf<Ticket>()

    while(result.next()){
        val id=result.getInt("ID")
        val number=result.getString("Ticket_Number")
        val pid=result.getInt("Passenger_ID")
        val tid=result.getInt("Train_ID")
        val tp=result.getInt("Ticket_Price")

        tickets.add(Ticket(id,number,pid,tid,tp))
    }
    println(tickets)



}