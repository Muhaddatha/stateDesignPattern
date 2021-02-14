import java.util.Locale;
import java.util.Scanner;

public class TestMyPrinter {
    public static void main(String args[]){
        MyPrinter myPrinter = new MyPrinter();

        displayOptions();

        Scanner scanner = new Scanner(System.in);

        String userInput;

        int userNum;

        boolean userContinue = true;

        while(scanner.hasNextLine() && userContinue){
            userInput = scanner.nextLine();


            if(userInput.toUpperCase().equals("F")){
                System.out.println("Thank you for using the printer...");
                userContinue = false;
            }
            else if(userInput.toUpperCase().equals("A")){
                System.out.println("Current ink level: " + myPrinter.getInkAmount() + " grams");
                System.out.println("Printer ink capacity: " + myPrinter.getMAX_INK() + " grams");
                System.out.println("Current printer state: " + myPrinter.getCurrentState());
            }
            else if(userInput.toUpperCase().equals("B")){
                System.out.println("Current paper level: " + myPrinter.getNumPaper() + " papers");
                System.out.println("Printer paper capacity: " + myPrinter.getMAX_PAPER() + " papers");
                System.out.println("Current printer state: " + myPrinter.getCurrentState());
            }
            else if(userInput.toUpperCase().equals("C")){
                System.out.print("Please enter ink amount to add: ");
                userNum = scanner.nextInt();
                myPrinter.addInk(userNum);
                scanner.nextLine();
                System.out.println("Current printer state: " + myPrinter.getCurrentState());
            }
            else if(userInput.toUpperCase().equals("D")){
                System.out.print("Please enter paper amount to add: ");
                userNum = scanner.nextInt();
                myPrinter.addPaper(userNum);
                scanner.nextLine();
                System.out.println("Current printer state: " + myPrinter.getCurrentState());
            }
            else if(userInput.toUpperCase().equals("E")){
                System.out.print("Please enter the number of pages to print: ");
                userNum = scanner.nextInt();
                myPrinter.print(userNum);
                scanner.nextLine();
                System.out.println("Current printer state: " + myPrinter.getCurrentState());
            }
            else{
                System.out.println("Please enter a valid option");
            }

            System.out.println("");
        }
    }


    //displays options to user
    public static void displayOptions(){
        System.out.println("---------------------------------------");
        System.out.println("     Welcome to the Printer project");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("Please select an option: ");
        System.out.println("a) See printer's ink level and capacity");
        System.out.println("b) See printer's paper level and capacity");
        System.out.println("c) Add ink to printer");
        System.out.println("d) Add paper to the printer");
        System.out.println("e) Print a document");
        System.out.println("f) Quit");
        System.out.println("---------------------------------------");
        System.out.println("");

    }
}

