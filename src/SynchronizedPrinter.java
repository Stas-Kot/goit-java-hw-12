public class SynchronizedPrinter implements Runnable{
    private final int period;
    private final Thread thread = new Thread(this);

    public int getPeriod() {
        return period;
    }

    SynchronizedPrinter(int period){
        this.period = period;
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true)
                synchronized (Message.class) {
                    Message.class.wait();
                    if (Message.count % getPeriod() == 0)
                        Message.sendMessage("SynchronizedPrinter: Прошло " + getPeriod() + " секунд");
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
