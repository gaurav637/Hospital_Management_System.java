package Hospital;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class About_hospital_Class {
      private Connection connection;
      private Scanner scanner;

      public About_hospital_Class(Connection connection,Scanner scanner){
          this.connection = connection;
          this.scanner = scanner;
      }

      public void print_about_hospital(){
          String sql = "SELECT * FROM about_hospital";
          try{
              Statement str = connection.createStatement();
              ResultSet set = str.executeQuery(sql);
              while(set.next()){
                  String brand = set.getString("Brand_Legacy");
                  String president_hospital = set.getString("President");
                  String cValue = set.getString("Core_Values");
                  String loc = set.getString("location");
                  int mobile = set.getInt("phone");
                  String mail = set.getString("email");
                  System.out.println();
                  System.out.println("Brancd Legacy------------> "+brand);
                  System.out.println();
                  System.out.println("President of Hospital----> "+president_hospital);
                  System.out.println();
                  System.out.println("Core Values--------------> "+cValue);
                  System.out.println();
                  System.out.println("Location of Hospital-----> "+loc);
                  System.out.println();
                  System.out.println("Phone Number-------------> "+mobile);
                  System.out.println();
                  System.out.println("Email of Hospital--------> "+mail);
              }
          }catch(SQLException e){
              System.out.println(e.getMessage());
          }

      }

}
