class Order implements Runnable {

    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() +
                " -> Order " + orderId + " Validation Started");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +
                " -> Processing Payment for " + orderId);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +
                " -> Order " + orderId + " Completed");
    }
}

public class OrderProcessingSystem {

    public static void main(String[] args) {

        System.out.println("Main Thread Started");

        for (int i = 1; i <= 5; i++) {

            Order order = new Order("ORD-" + i);

            Thread thread = new Thread(order);

            thread.setName("Worker-" + i);

            System.out.println(thread.getName() +
                    " State before start(): " + thread.getState());

            thread.start();

            System.out.println(thread.getName() +
                    " State after start(): " + thread.getState());
        }

        System.out.println("Main Thread Finished");
    }
}