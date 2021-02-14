
public interface PrinterState {

    //all ways to interact with the printer
    void print(int numPages);
    void addInk(int inkAmount);
    void addPaper(int numPaper);
}
