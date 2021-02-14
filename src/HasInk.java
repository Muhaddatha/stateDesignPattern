public class HasInk implements PrinterState{

    MyPrinter printer;

    public HasInk(MyPrinter newPrinter){
        this.printer = newPrinter;
    }
    @Override
    public void print(int numPages) {
        //assumption is that numPages is positive

        if(printer.getNumPaper() < numPages){
            System.out.println("There is not enough paper in the printer. \n" +
                    "Please add more paper first.");
            return;
        }
        else if(printer.getInkAmount() < printer.getInkCostPerPage() * numPages){
            System.out.println("There is not enough ink in the printer. Each paper needs "+ printer.getInkCostPerPage() +
                    " grams of ink.\nPlease add more ink first.");
            return;
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
            printer.updateInk(inkAmount);
            System.out.println("Added ink to printer. Current ink level: " + printer.getInkAmount());
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
