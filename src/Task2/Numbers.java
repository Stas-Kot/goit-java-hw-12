package Task2;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final StringBuilder result = new StringBuilder();
    private final int number;

    public Numbers(int number){
        this.number = number;
    }

    public StringBuilder getResult() {
        return result;
    }

    public int getNumber() {
        return number;
    }

    public void print() {
        ProcessThread fizzBuzz = new ProcessThread(n -> {
            if (n % 15 == 0) {
                getResult().append("fizzbuzz").append(", ");
            }
        });

        ProcessThread fizz = new ProcessThread(n -> {
            if (n % 3 == 0 && n % 5 != 0) {
                getResult().append("fizz").append(", ");
            }
        });

        ProcessThread buzz = new ProcessThread(n -> {
            if (n % 5 == 0 && n % 3 != 0) {
                getResult().append("buzz").append(", ");
            }
        });

        ProcessThread number = new ProcessThread(n -> {
            if (n % 3 != 0 && n % 5 != 0) {
                getResult().append(n).append(", ");
            }
        });

        List<ProcessThread> threads = new ArrayList<>();
        threads.add(fizzBuzz);
        threads.add(fizz);
        threads.add(buzz);
        threads.add(number);

        for (ProcessThread thread : threads) {
            thread.start();
        }

        for (int i = 1; i <= getNumber(); i++) {
            for (ProcessThread thread : threads) {
                thread.process(i);
            }

            while (true) {
                int processedCount = 0;
                for (ProcessThread thread : threads) {
                    if (thread.isProcessed()) {
                        processedCount++;
                    }
                }
                if (processedCount == threads.size()) {
                    break;
                }
            }
        }
        System.out.println(getResult().replace(getResult().length() - 2, getResult().length(), ""));
        for (ProcessThread thread : threads) {
            thread.interrupt();
        }
    }

}
