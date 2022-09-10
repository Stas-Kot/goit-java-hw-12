package Task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread {
    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private NumberProcessor processor;

    public ProcessThread(NumberProcessor processor) {
        this.processor = processor;
    }

    public void process(int number) {
        this.number = number;
        processed.set(false);
    }

    public boolean isProcessed(){
        return processed.get();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if(processed.get()){
                continue;
            }

            processor.process(number);

            processed.set(true);
        }
    }
}
