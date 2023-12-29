package Hospital;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class ServicesOfHospital {
    private Connection connection;
    private Scanner scanner;

    public ServicesOfHospital(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
    public void Services(){
        String sq = "SELECT * FROM services";
        System.out.println("Our Hospital Scope of Services. ->");
        try{
            Statement st = connection.createStatement();
            ResultSet ans = st.executeQuery(sq);
            System.out.println();
            System.out.println("+-----------+----------------------------------------+");
            System.out.println("| Serial_No.|              Services_Name             |");
            System.out.println("+-----------+----------------------------------------+");
            while(ans.next()){
                int sNo = ans.getInt("serial_no");
                String nameS = ans.getString("name");
                System.out.printf("| %-8d  |  %-37s | \n",sNo,nameS);
            }
            System.out.println("+-----------+----------------------------------------+");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║ press 1. Add New Services -> ║");
        System.out.println("║ press 2. exit                ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.println();
        System.out.println("Select any one option-> ");
        int option  = scanner.nextInt();
        switch(option){
            case 1:{
                System.out.println("Enter Services Name- >");
                scanner.nextLine();
                String str = scanner.nextLine();
                try{
                    String sql = "INSERT INTO services(name)VALUES(?)";
                    PreparedStatement prt = connection.prepareStatement(sql);
                    prt.setString(1,str);
                    int affected = prt.executeUpdate();
                    if(affected>0){
                        System.out.println("services is add in hospital system.");
                        //return 1;
                    }
                    else{
                        System.out.println("services is not add in hospital system.");
                    }
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                break;

            }
            case 2:{
                return;
            }
        }
    }
}
