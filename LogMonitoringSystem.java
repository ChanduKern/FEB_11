class LogScanner extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {

            System.out.println("Scanning logs... Cycle " + i);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Log scanning completed.");
    }
}

public class LogMonitoringSystem {

    public static void main(String[] args) throws InterruptedException {

        LogScanner scanner = new LogScanner();

        System.out.println("Before start(): " + scanner.getState());

        scanner.start();

        for (int i = 0; i < 10; i++) {

            System.out.println("Current State: " + scanner.getState());

            Thread.sleep(1000);
        }

        System.out.println("Final State: " + scanner.getState());
    }
}