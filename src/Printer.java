import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Printer {
    private final int period;
    private final int delay;
    private final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public int getPeriod() {
        return period;
    }

    public int getDelay() {
        return delay;
    }

    public Printer(int period, int delay) {
        this.period = period;
        this.delay = delay;
    }

    public void printMessage() {
        service.scheduleAtFixedRate(
                () -> System.out.println("Printer: Прошло 5 секунд"),
                getDelay(),
                getPeriod(),
                TimeUnit.SECONDS
        );
    }
}
