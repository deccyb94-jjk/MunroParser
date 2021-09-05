import java.io.*;

public class Main {

    private static UserInterface ui;
    private static DataController dtcontroller = new DataController();

    public static void main(String[] args) throws IOException {
        ui = new UserInterface(dtcontroller);
    }
}
