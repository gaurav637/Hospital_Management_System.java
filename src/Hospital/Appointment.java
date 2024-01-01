package Hospital;

import java.sql.Connection;
import java.util.Scanner;
public class Appointment {
    private Connection connection;
    private Scanner scanner;

    public Appointment(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
}