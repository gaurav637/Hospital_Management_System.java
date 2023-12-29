package Hospital;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.Character.isDigit;
import static java.lang.Character.isUpperCase;

public class Admin_Class {
    private Connection connection;
    private Scanner scanner;

    public Admin_Class(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }


    public int UserSignUp(){
        String User_email = null;
        System.out.print("Enter your Name-> ");
        String User_name = scanner.nextLine();
        System.out.println();
        boolean flag =  true;
        while(flag){
            boolean check = false;
            boolean check2 = false;
            System.out.println();
            System.out.print("Enter your Email-> ");// negigaurav637@gmail.com
            User_email =  scanner.nextLine();
            int n = User_email.length();
            if(n>=14){
                check2 = true;
                int g = n-10;
                System.out.println("");
                String str = "@gmail.com";
                int j =0;
                for(int i=g;i<n;i++){
                    if(User_email.charAt(i)!=str.charAt(j++)){
                        check = true;
                        break;
                    }
                }
            }
            else{
                System.out.print("invalid email please try again.!");
                try{
                    int num = 0;
                    while(num<=5){
                        System.out.print(".");
                        Thread.sleep(300);
                        num++;
                    }
                }catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }

            }
            if(check){
                System.out.print("invalid email please try again.!");
                try{
                    int num = 0;
                    while(num<=5){
                        System.out.print(".");
                        Thread.sleep(300);
                        num++;
                    }
                }catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
            if(check==false && check2 == true){
                flag = false;
            }
        }
        System.out.println();
        boolean flag1 = true;
        int count = 0;
        String pass = null;
        while(flag1){
            int a = 0;
            int b = 0;
            int c = 0;
            System.out.println();
            System.out.print("Enter password-> ");// A combination of uppercase letters, lowercase letters, numbers, and symbols.
            pass = scanner.nextLine();
            int size = pass.length();
            for(int i=0;i<size;i++){
                if(isUpperCase(pass.charAt(i))){
                    a++;
                }
                if(!isUpperCase(pass.charAt(i))){
                    b++;
                }
                if(isDigit(pass.charAt(i))){
                    c++;
                }
            }
            if(a>0&&b>0&&c>0){
                flag1 = false;
            }
            else if(count>2){
                System.out.println("try again.!");
                System.out.print("include password special Upper,lowerCase Character and number.");
                try{
                    int num = 0;
                    while(num<=5){
                        System.out.print(".");
                        Thread.sleep(300);
                        num++;
                    }
                }catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
            else{
                count++;
                System.out.print("please Enter strong password try again.!");
                try{
                    int num = 0;
                    while(num<=5){
                        System.out.print(".");
                        Thread.sleep(300);
                        num++;
                    }
                }catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println();

        String sql = "INSERT INTO Admin_table(name,email,password)VALUES(?,?,?)";
        try{
            PreparedStatement prt = connection.prepareStatement(sql);
            prt.setString(1,User_name);
            prt.setString(2,User_email);
            prt.setString(3,pass);
            int effected = prt.executeUpdate();
            if(effected>0){
                System.out.println("Account creation successfully..");
                return 1;
            }
            else{
                System.out.println("Account creation failed!..");
                return 0;
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int UserSignIn(){
        System.out.print("Enter your Email-> ");
        String userEmail = scanner.nextLine();
        System.out.print("Enter your Password-> ");
        String userPassword = scanner.nextLine();
        String sql = "SELECT * FROM Admin_table WHERE email = ? AND password = ?";
        try{
            PreparedStatement prt = connection.prepareStatement(sql);
            prt.setString(1,userEmail);
            prt.setString(2,userPassword);
            ResultSet set = prt.executeQuery();
            if(set.next()){
                System.out.println("user information valid..");
                return 1;
            }
            else{
                System.out.println("user information invalid..");
                return 0;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
