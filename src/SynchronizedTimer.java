public class SynchronizedTimer implements Runnable {
    private final int period;
    private Thread thread = new Thread(this);

    SynchronizedTimer(int period) {
        this.period = period;
        thread.start();
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(getPeriod() * 1000);
                synchronized (Message.class) {
                    Message.sendMessage("time from session start: " + ++Message.count + (Message.count > 1 ? " seconds" : " second"));
                    Message.class.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
