import java.sql.DriverManager

data class Trains(val Train_ID:Int,val Train_No:Int,val Train_Name:String,val Source:String,val Destination:String,val Start_Date_Time:String,val Arrival_Time: String)
fun main(args: Array<String>) {

    val connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineTicketBooking","root","2001")
    println(connection.isValid(0))

    //insert_query
    val res=connection.createStatement().executeUpdate("insert into Train values(2,80229,'SLDH-GEDE Local','Sealdah','Gede','19-08-22 6.00PM','19-08-22 9.00PM')")
    if(res>0){
        println("Successfully inserted")
    }else{
        println("Insertion is not Successful")
    }


    //Select_query Read
    val result=connection.prepareStatement("select * from Train").executeQuery()
    val trains=mutableListOf<Trains>()

    while(result.next())
    {
        val id=result.getInt("Train_ID")
        val no=result.getInt("Train_No")
        val name=result.getString("Train_Name")
        val source=result.getString("Source")
        val destination=result.getString("Destination")
        val date1=result.getString("Start_Date_Time")
        val date2=result.getString("Arrival_Time")

        trains.add(Trains(id,no,name,source,destination,date1,date2))
    }
    println(trains);

}