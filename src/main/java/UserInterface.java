import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface {

    private Controller controller;
    private Scanner scanner;

    public UserInterface(Controller controller) throws IOException {
        this.controller = controller;
        this.scanner = new Scanner(System.in);

        while(true){
            this.displayMenu();
            this.processUserOption();
        }
    }

    private void displayMenu() {
        this.display(header());
        this.display(menu());
    }

    public void processUserOption() throws IOException {
        String command = this.scanner.nextLine().trim();
        byte var3 = -1;
        switch(command.hashCode()) {
            case 49:
                if (command.equals("1")) {
                    var3 = 0;
                }
                break;
            case 50:
                if (command.equals("2")) {
                    var3 = 1;
                }
                break;
            case 51:
                if (command.equals("3")) {
                    var3 = 2;
                }
                break;
            case 52:
                if (command.equals("4")) {
                    var3 = 3;
                }
                break;
            case 53:
                if (command.equals("5")) {
                    var3 = 4;
                }
                break;
            case 54:
                if (command.equals("6")) {
                    var3 = 5;
                }
        }

        switch(var3) {
            case 0:
                this.display("Which category would you like to see?");
                this.display("1) Munro");
                this.display("2) Munro Top");
                this.display("Please enter 1 or 2");
                String option1Line = this.scanner.nextLine().trim();
                this.display("Limit your results to top 10? Enter Y or N");
                String limit1 = this.scanner.nextLine().trim();
                this.display(controller.splitByCategory(option1Line, limit1));
                break;
            case 1:
                this.display("1) Ascending");
                this.display("2) Descending");
                this.display("Please enter 1 or 2");
                String option2Line = this.scanner.nextLine().trim();
                this.display("Limit your results to top 10? Enter Y or N");
                String limit2 = this.scanner.nextLine().trim();
                this.display("Sorted Data:");
                this.display(this.controller.sortByAlphabeticalNameAscOrDesc(option2Line, limit2));
                break;
            case 2:
                this.display("1) Ascending");
                this.display("2) Descending");
                this.display("Please enter 1 or 2");
                String option3Line = this.scanner.nextLine().trim();
                this.display("Limit your results to top 10? Enter Y or N");
                String limit3 = this.scanner.nextLine().trim();
                this.display("Sorted Data:");
                this.display(this.controller.sortByHeightAscOrDesc(option3Line, limit3));
                break;
            case 3:
                this.display("Please specify minimum height:");
                BufferedReader userReader3 = new BufferedReader(new InputStreamReader(System.in));
                double option4Line = Integer.valueOf(userReader3.readLine());
                this.display("Limit your results to top 10? Enter Y or N");
                String limit4 = this.scanner.nextLine().trim();
                this.display(this.controller.specifyMinHeight(option4Line, limit4));
                break;
            case 4:
                this.display("Please specify maximum height:");
                BufferedReader userReader4 = new BufferedReader(new InputStreamReader(System.in));
                double option5Line = Integer.valueOf(userReader4.readLine());
                this.display("Limit your results to top 10? Enter Y or N");
                String limit5 = this.scanner.nextLine().trim();
                this.display(this.controller.specifyMaxHeight(option5Line, limit5));
                break;
            case 5:
                this.display("Goodbye!");
                System.exit(0);
                break;
            default:
                this.display(unrecogniseCommandErrorMsg(command));
        }

    }

    private static String header() {
        return "\nMunro Information\n";
    }

    private static String menu() {
        return "Enter the number associated with your chosen menu option.\n" +
                "1: Sort by category (Munro/Munro Top)\n" +
                "2: Sort file data alphabetically\n" +
                "3: Sort file data by height in M\n" +
                "4: Specify Minimum Height in M\n" +
                "5: Specify Maximum Height in M\n" +
                "6: Exit this application\n";
    }

    private void display(String info) {
        System.out.println(info);
    }

    private static String unrecogniseCommandErrorMsg(String error) {
        return String.format("Cannot recognise the given command: %s.%n", error);
    }

}
