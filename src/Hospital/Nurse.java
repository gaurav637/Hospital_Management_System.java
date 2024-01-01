package Hospital;

import java.sql.Connection;
import java.util.Scanner;
public class Nurse {
    private Connection connection;
    private Scanner scanner;

    public Nurse(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
}
