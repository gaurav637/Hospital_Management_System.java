package Hospital;

import java.sql.Connection;
import java.util.Scanner;
public class Room{
    private Connection connection;
    private Scanner scanner;

    public Room(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
}
