 public class Main {
    public static void main(String[] args) {
//        Timer timer = new Timer(1);
//        timer.startTimer( );
//
//        Printer printer = new Printer(5, 5);
//        printer.printMessage();

        new SynchronizedTimer(1);
        new SynchronizedPrinter(5);
    }
}