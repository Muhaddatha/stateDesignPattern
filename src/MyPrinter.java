public class MyPrinter {

    //printer attributes
    private int inkAmount;
    private int numPaper = 0;
    private int inkCostPerPage = 3;

    //printer capacity attributes
    private final int MAX_PAPER = 40;
    private final int MAX_INK = 20;

    //possible printer states
    private PrinterState hasInk;
    private PrinterState noInk;
    private PrinterState hasPaper;
    private PrinterState noPaper;

    //current printer state stored in this variable
    PrinterState printerState;

    //constructor for MyPrinter object
    public MyPrinter(){
        hasInk = new HasInk(this);
        noInk = new NoInk(this);
        hasPaper = new HasPaper(this);
        noPaper = new NoPaper(this);

        //initial state of the printer
        printerState = noPaper;
    }

    //changing the printer's state
    protected void setPrinterState(PrinterState newPrinterState){
        printerState = newPrinterState;
    }

    //returns the current ink amount in the printer
    public int getInkAmount(){
        return this.inkAmount;
    }

    //returns the current number of papers in the paper
    public int getNumPaper(){
        return this.numPaper;
    }

    //returns the amount of ink grams needed to print 1 page
    public int getInkCostPerPage(){
        return this.inkCostPerPage;
    }

    //returns the max paper capacity of the printer
    public int getMAX_PAPER(){
        return MAX_PAPER;
    }

    //returns the max ink capacity of the printer
    public int getMAX_INK(){
        return MAX_INK;
    }


    //num paper can be negative or positive
    //updates the number of papers in the printer
    protected void updatePaper(int numPaper){
        this.numPaper += numPaper;
    }

    //updates the ink level in the printer
    protected void updateInk(int inkAmount){
        this.inkAmount += inkAmount;
    }

    //adds paper to the paper
    public void addPaper(int numPaper){
        printerState.addPaper(numPaper);
    }

    //adds ink to the printer
    public void addInk(int inkAmount){
        printerState.addInk(inkAmount);
    }

    //prints a certain number of pages
    public void print(int numPages){
        printerState.print(numPages);
    }

    //returns the NoPaper state of the printer
    protected PrinterState getNoPaperState(){
        return noPaper;
    }

    //returns the NoInk state of the printer
    protected PrinterState getNoInkState(){
        return noInk;
    }

    //returns the HasInk state of the printer
    protected PrinterState getHasInkState(){
        return hasInk;
    }

    //returns the HasPaper state of the printer
    protected PrinterState getHasPaperState(){
        return hasPaper;
    }

}
