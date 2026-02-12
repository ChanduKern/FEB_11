import java.util.Random;

class Payment extends Thread {

    public Payment(String name) {
        super(name);
    }

    @Override
    public void run() {

        Random random = new Random();
        int delay = 1000 + random.nextInt(2000);

        System.out.println(getName() + " Payment Started. Verifying...");

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " Payment Completed after " + delay + " ms");
    }
}

public class PaymentGatewaySystem {

    public static void main(String[] args) {

        System.out.println("Main Thread Started");

        Payment p1 = new Payment("Payment-1");
        Payment p2 = new Payment("Payment-2");
        Payment p3 = new Payment("Payment-3");

        p1.start();
        p2.start();
        p3.start();

        System.out.println("Main Thread Finished");
    }
}