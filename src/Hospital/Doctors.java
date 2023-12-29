package Hospital;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import static java.lang.Character.isUpperCase;

public class Doctors {
    private Connection connection;
    private Scanner scanner;

    public Doctors(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void doctors_class(){
        System.out.println();
        while(true){
            System.out.println("press 1. Doctors List");
            System.out.println("press 2. Add Doctor");
            System.out.println("press 3. Find doctor");
            System.out.println("press 0. Exit");
            System.out.println();
            System.out.print("Select any option -> ");
            int op = scanner.nextInt();
            switch(op){
                case 1:{
                    System.out.println("DOCTORS LIST -> ");
                    String sql = "SELECT * FROM Doctors_In_Hospital";
                    try{
                        Statement sts = connection.createStatement();
                        ResultSet set = sts.executeQuery(sql);
                        System.out.println("+-----+------------------+--------------------+-------------+---------------------+-----------+");
                        System.out.println("|  ID |      Name        |    Specialist      |   Timing    |  Qualification      |  Room_NO  |");
                        System.out.println("+-----+------------------+--------------------+-------------+---------------------+-----------+");
                        while(set.next()){
                            int D_id = set.getInt("ID");
                            String D_name = set.getString("Doctor_Name");
                            String D_specialist = set.getString("specialist");
                            String D_Timing = set.getString("Timing");
                            String D_Qualification = set.getString("Qualification");
                            int D_room = set.getInt("RoomNo");
                            System.out.printf("| %-3d |  %-14s  |  %-18s|  %-11s|  %-19s|  %-9d|\n",
                                    D_id,D_name,D_specialist,D_Timing,D_Qualification,D_room);
                        }
                        System.out.println("+-----+------------------+--------------------+-------------+---------------------+-----------+");
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case 2:{
                    int room_number = -1;
                    String random = "SELECT DISTINCT(FLOOR(1+RAND()*(100-1))) AS  RANDOM";
                    //Statement sts = connection.createStatement(random);
                    //ResultSet s1 = sts.executeQuery(random);
                    //while(s1.next()){
                        //room_number = s1.getInt("RANDOM");
                    //}
                    String ans = null;
                    System.out.println("ADD DOCTORS -> ");
                    System.out.println();
                    System.out.println("Enter ID -> ");
                    int id = scanner.nextInt();
                    System.out.println("Enter Doctor Name-> ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Specialist -> ");
                    //scanner.nextLine();
                    String speci = scanner.nextLine();
                    System.out.println("Timing -> ");
                    String time = scanner.nextLine();
                    //String random = "SELECT DISTINCT(FLOOR(1+RAND()*(100-1))) AS  RoomNo";

                    System.out.println("your Qualification -> ");
                    String quali = scanner.nextLine();
                    if(quali.equals(quali.toLowerCase())){
                        ans = quali.toUpperCase();
                    }
                    else{
                        ans = quali;
                    }
                    int count=0;
                    String[] degree = new String[]{"MBBS","MD","DO","DDS","DVM","OD","DC","DPT","DNP","BAMS","BHMS","BPT","BUMS","PHARMACY","BSC","DCH","PHD","BSN","GNM","ANM","DMLT","DRD","CNA"};
                    int size = degree.length;
                    for(int i=0;i<size;i++){
//                        if(degree[i]==ans){
//                            count++;
//                        }
                        if(ans.equals(degree[i])){
                            count++;
                        }
                    }
                    if(count==0){
                        System.out.println("you are not qualify any medical degree");
                        return;
                    }

                    try{
                        String sql = "INSERT INTO  Doctors_In_Hospital(ID,Doctor_Name,Specialist,Timing,Qualification,RoomNo)VALUES(?,?,?,?,?,?)";
                        PreparedStatement prt = connection.prepareStatement(sql);
                        prt.setInt(1,id);
                        prt.setString(2,name);
                        prt.setString(3,speci);
                        prt.setString(4,time);
                        prt.setString(5,quali);
                        prt.setString(6,random);
                        int effected = prt.executeUpdate();
                        if(effected>0){
                            System.out.println("Dr. "+ name+" is add in our staff");
                        }
                        else{
                            System.out.println("Dr. "+ name+" is not add in our staff ");
                        }
                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }

                    System.out.println();
                    break;
                }






                case 3:{
                    break;
                }
                case 0:{

                }
            }
        }


    }
}
