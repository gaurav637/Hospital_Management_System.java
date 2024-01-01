package Hospital;

import java.sql.Connection;
import java.util.Scanner;
public class Birth_Death{
    private Connection connection;
    private Scanner scanner;

    public Birth_Death(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
}

