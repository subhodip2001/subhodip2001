import java.sql.Connection
import java.sql.DriverManager

data class User(val Passenger_ID:Int,val Passenger_Name:String,val Passenger_Age:Int,val Gender:String,val Phone:String)
fun main(args: Array<String>) {
    val jdbcUrl="jdbc:mysql://localhost:3306/OnlineTicketBooking"
    val connection=DriverManager.getConnection(jdbcUrl,"root","2001")
    println(connection.isValid(0))

    //insert query -Create

    val res = connection.createStatement()
        .executeUpdate("insert into Passengers(Passenger_ID,Passenger_Name,Passenger_Age,Gender,Phone) values (003,'Soumen',21,'M','9876543210')")
    if (res > 0) {
        println("successfully inserted record into passengers db !!!")
    } else {
        println("Insertion Not Successful")
    }


    //delete query
    val delete_res=connection.createStatement().executeUpdate("delete from Passengers where Passenger_ID=8")
    if(delete_res>0)
    {
        println("successfully deleted record from users db !!!")
    }else{
        println("Deletion is Not Successful")
    }

    //select query -Read
    val query=connection.prepareStatement("select * from Passengers")
    val result=query.executeQuery()
    val users=mutableListOf<User>()


    //update_query
    val update_res=connection.createStatement().executeUpdate("update Passengers set phone= 3399887501 where Passenger_ID=4")
    if(update_res>0)
    {
        println("successfully updated record in users db !!")
    }else{
        println("Update Not Successful")
    }
    while(result.next())
    {
        val id=result.getInt("Passenger_ID")
        val name=result.getString("Passenger_Name")
        val age=result.getInt("Passenger_Age")
        val gender=result.getString("Gender")
        val phone=result.getString("Phone")

        //println("id:$id  name:$name")
        users.add(User(id,name,age,gender,phone))


    }
    println(users)


}