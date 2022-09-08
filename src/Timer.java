import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Timer {
    int period;
    int delay;
    public int getPeriod() {
        return period;
    }

    public int getDelay() {
        return delay;
    }

    public Timer(int period) {
        this.delay = Message.count;
        this.period = period;
    }

    public void startTimer()  {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger i = new AtomicInteger(getDelay());
        service.scheduleAtFixedRate(
                () -> System.out.println("time from session start: " + i.get() + (i.getAndIncrement() > 1 ? " seconds" : " second")),
                getDelay(),
                getPeriod(),
                TimeUnit.SECONDS
        );
    }
}
