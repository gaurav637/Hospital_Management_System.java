package Hospital;

import java.sql.*;
import java.util.Scanner;

public class Appointment {
    private Connection connection;
    private Scanner scanner;

    public Appointment(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void allAppointment(){
        String sql = "SELECT * FROM Appointment";
        try{
            Statement st = connection.createStatement();
            ResultSet ans = st.executeQuery(sql);
            String name1 = ans.getString("patient_name");
            String email1 = ans.getString("email");
            String address1 = ans.getString("address");
            String disease1 = ans.getString("disease");
            int did = ans.getInt("doctor_id");
            Timestamp tm = ans.getTimestamp("date_time");
            System.out.println("patient name -> "+name1);
            System.out.println("patient email -> "+email1);
            System.out.println("patient address -> "+address1);
            System.out.println("date and tiem -> "+did);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}