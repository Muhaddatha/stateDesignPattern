public class NoInk implements PrinterState{

    MyPrinter printer; //the context (MyPrinter) is passed by reference and stored in this variable

    //constructor
    public NoInk(MyPrinter newPrinter){
        this.printer = newPrinter;

    }

    //print a certain number of pages
    @Override
    public void print(int numPages) {
        System.out.println("Sorry, the printer does not have any ink. Please add more ink first.");
    }


    @Override
    public void addInk(int inkAmount) {
        //maxing out printer ink capacity
        if(printer.getInkAmount() + inkAmount > printer.getMAX_INK()){
            System.out.println("Cannot add this much ink, try adding "
                    + (printer.getMAX_INK() - printer.getInkAmount())+ " grams or less.");
        }
        else{
            //printer ink capacity won't be maxed out
            printer.updateInk(inkAmount);
            System.out.println("Added ink to printer. Current ink level: " + printer.getInkAmount());
            printer.setPrinterState(printer.getHasInkState());
        }
    }

    @Override
    public void addPaper(int numPaper) {
        if(printer.getNumPaper() + numPaper > printer.getMAX_PAPER()){
            System.out.println("Cannot add this much Paper, try adding "
                    + (printer.getMAX_PAPER() - printer.getNumPaper())+ "  or less.");
        }
        else{
            printer.updatePaper(numPaper);
            System.out.println("Added paper to printer. Current paper level: " + printer.getNumPaper());
            printer.setPrinterState(printer.getHasPaperState());
        }
    }
}
