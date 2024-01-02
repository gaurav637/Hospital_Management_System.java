package Hospital;

import java.sql.Connection;
import java.util.Scanner;
public class operation {
    private Connection connection;
    private Scanner scanner;

    public operation(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
}
