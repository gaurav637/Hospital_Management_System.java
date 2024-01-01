package Hospital;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;
public class Hospital_Main_Class {
    private static final String url = "jdbc:mysql://localhost:3306/Hospital_System";
    private static final String user = "root";
    private static final String password = "91491026";
    public static void main(String args[])throws ClassNotFoundException , SQLException{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            Scanner scanner = new Scanner(System.in);
            About_hospital_Class ahc = new About_hospital_Class(connection,scanner);
            ServicesOfHospital sfh = new ServicesOfHospital(connection,scanner);
            Admin_Class ac = new Admin_Class(connection,scanner);
            Patient pt = new Patient(connection,scanner);
            Nurse nr = new Nurse(connection,scanner);
            Room rm = new Room(connection,scanner);
            Appointment ap = new Appointment(connection,scanner);
            Profit pr = new Profit(connection,scanner);
            operation op = new operation(connection,scanner);
            Birth_Death bd = new Birth_Death(connection,scanner);
            medicine md = new medicine(connection,scanner);
            Doctors ds = new Doctors(connection,scanner);
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t***********************");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t* HOSPITAL MANAGEMENT *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t*       SYSTEM        *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t***********************");
            System.out.println();
            System.out.print(" press 1. About hospital -> ");
            Scanner sc = new Scanner(System.in);
            while(true){
                int option = sc.nextInt();
                if(option==1){
                    ahc.print_about_hospital();
                    break;
                }
                else{
                    System.out.println("Invalid choice.! please try again..");
                }
            }
            boolean checksum = true;
            while(true){
                System.out.println();
                System.out.println();
                System.out.println("+--------------------+\t\t\t\t\t\t\t\t\t +-------------------+\t\t\t\t\t\t\t\t\t+----------------+");
                System.out.println("| press 1. -> SignIn |\t\t\t\t\t\t\t\t\t |   press 2. SignUp |\t\t\t\t\t\t\t\t\t| press 3. exit  |");
                System.out.println("+--------------------+\t\t\t\t\t\t\t\t\t +-------------------+\t\t\t\t\t\t\t\t\t+----------------+");
                System.out.println();
                System.out.print("Enter any choise -> ");
                System.out.println();
                int choose = sc.nextInt();
                int ans1 = -1;
                int ans2 = -1;
                switch(choose){
                    case 1:{
                        ans1 = ac.UserSignIn();
                        break;
                    }
                    case 2:{
                        ans2 = ac.UserSignUp();
                        break;
                    }
                    case 3:{
                        System.out.print("thank you for visiting our hospital system");
                        int i=0;
                        try{
                            while(i<=6){
                                System.out.print("..");
                                Thread.sleep(200);
                                i++;
                            }

                        }catch(InterruptedException e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println();
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("Invalid choice please try again..");
                }
                if(ans1==1 || ans2==1){
                    break;
                }
            }

            while(true){
                System.out.println();
                System.out.println("1.Scope of Services");
                System.out.println("2.Appointment");
                System.out.println("3.doctor");
                System.out.println("4.patient");
                System.out.println("6.nurse");
                System.out.println("7.medicine");
                System.out.println("8.Room");
                System.out.println("9.operation");
                System.out.println("10.profit");
                System.out.println("11.Birth_Death");
                System.out.println();
                System.out.println("Enter any option ->");
                System.out.println();
                int option = sc.nextInt();
                switch(option){
                    case 1:{
                       sfh.Services();
                        break;
                    }
                    case 2:{
                        System.out.println();
                        ds.doctors_class();
                        break;
                    }
                }
            }

        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }

    }
}
