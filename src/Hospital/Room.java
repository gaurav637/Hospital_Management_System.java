package Hospital;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Room{
    private Connection connection;
    private Scanner scanner;

    public Room(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void allRoom(){
        String sql = "SELECT * FROM Room";
        try{
            Statement st = connection.createStatement();
            ResultSet ans = st.executeQuery(sql);
            System.out.println();
            System.out.println("+-----+------------------+--------------------+------------------------+----------------------------+");
            System.out.println("|  ID |     Room No      |    room type       |   room floor           |      Availability          |");
            System.out.println("+-----+------------------+--------------------+------------------------+----------------------------+");
            while(ans.next()){
                int rid = ans.getInt("room_id");
                int rno = ans.getInt("room_no");
                String rt  = ans.getString("room_type");
                int rf = ans.getInt("room_floor");
                String avl = ans.getString("Availability");
                System.out.printf("|  %-3d |  %-16d  |  %-18s|  %-11s|  %-22s|\n",
                        rid,rno,rt,rf,avl);
            }
            System.out.println("+-----+------------------+--------------------+-------------------------+----------------------------+");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
