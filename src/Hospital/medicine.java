package Hospital;

import java.sql.Connection;
import java.util.Scanner;
public class medicine{
    private Connection connection;
    private Scanner scanner;

    public medicine(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
}
