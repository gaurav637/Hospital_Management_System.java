package Hospital;

import java.sql.Connection;
import java.util.Date;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Patient {
    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void allPatient(){
        String sql = "SELECT * FROM Patient";
        try{
            Statement st = connection.createStatement();
            ResultSet ans = st.executeQuery(sql);
            System.out.println();
            System.out.println("+-----+------------------+--------------------+------------------------+----------+-----------------+-----------+-------+-------+--------+");
            System.out.println("|  ID |      Name        |    Email           |   Address              |  Room id |  Disease        |  Gender   |  Age  | Bill  | Date   |");
            System.out.println("+-----+------------------+--------------------+------------------------+----------+-----------------+-----------+-------+-------+--------+");
            while(ans.next()){
                int idp = ans.getInt("Id");
                String namep = ans.getString("Name");
                String emailp =  ans.getString("Email");
                String addressp = ans.getString("Address");
                int room_idp = ans.getInt("Room_id");
                String diseasep = ans.getString("Disease");
                String genderp = ans.getString("Gender");
                int agep = ans.getInt("Age");
                int billp = ans.getInt("Bill");
                Date datep = ans.getDate("DATE");
                System.out.printf("|  %-3d |  %-16s  |  %-18s|  %-11s|  %-22d|  %-8s|  %-15s|  %-8d|  %-5d|  %-6s\n",
                        idp,namep,emailp,addressp,room_idp,diseasep,genderp,agep,billp,datep);
            }
            System.out.println("+-----+------------------+-------------------+-----------------------+----------+-------------------+----------+-------+---------+-------+");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
