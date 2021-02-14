public class HasInk implements PrinterState{

    MyPrinter printer; //the context (MyPrinter) is passed by reference and stored in this variable

    //constructor
    public HasInk(MyPrinter newPrinter){
        this.printer = newPrinter;
    }

    @Override
    public void print(int numPages) { //print a certain number of pages
        //assumption is that numPages is positive

        if(printer.getNumPaper() < numPages){ //more pages to be printed than paper in he printer
            System.out.println("There is not enough paper in the printer. \n" +
                    "Please add more paper first.");
        }
        else if(printer.getInkAmount() < printer.getInkCostPerPage() * numPages){ //not enough ink
            System.out.println("There is not enough ink in the printer. Each paper needs "+ printer.getInkCostPerPage() +
                    " grams of ink.\nPlease add more ink first.");
        }
        else{ //printer has enough ink and paper
            System.out.println("Printing the document with " + numPages + " pages...");

            //subtracting the amount of ink used for printing from printer inkAmount
            printer.updateInk(numPages * printer.getInkCostPerPage() * -1);

            //updating the number of paper left in the printer
            printer.updatePaper(numPages * -1);


            //if printer is out of ink, change its state to no ink state
            if(printer.getInkAmount() == 0){
                printer.setPrinterState(printer.getNoInkState());
                return;
            }

            //if printer is out of paper, change its state to no paper state
            if(printer.getNumPaper() == 0){
                printer.setPrinterState(printer.getNoPaperState());
            }


        }
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
        }
    }

    @Override
    public void addPaper(int numPaper) {
        //too much paper for the printer's capacity
        if(printer.getNumPaper() + numPaper > printer.getMAX_PAPER()){
            System.out.println("Cannot add this much Paper, try adding "
                    + (printer.getMAX_PAPER() - printer.getNumPaper())+ "  or less.");
        }
        else{
            //paper capacity won't be maxed out.
            printer.updatePaper(numPaper);
            System.out.println("Added paper to printer. Current paper level: " + printer.getNumPaper());
            printer.setPrinterState(printer.getHasPaperState());
        }
    }
}
