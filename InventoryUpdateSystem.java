class Inventory {

    private int stock = 100;

    public void updateStock(String workerName, int quantity) {

        System.out.println(workerName + " is preparing to update stock...");

        synchronized (this) {

            System.out.println(workerName + " updating stock...");

            if (stock >= quantity) {

                try {
                    Thread.sleep(2000); // simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stock -= quantity;
                System.out.println(workerName + " updated stock. Remaining: " + stock);

            } else {
                System.out.println(workerName + " Insufficient stock! Available: " + stock);
            }
        }

        System.out.println(workerName + " logged inventory update.");
    }
}

class Worker extends Thread {

    private Inventory inventory;
    private int quantity;

    public Worker(Inventory inventory, String name, int quantity) {
        super(name);
        this.inventory = inventory;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        inventory.updateStock(getName(), quantity);
    }
}

public class InventoryUpdateSystem {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Worker w1 = new Worker(inventory, "Worker-1", 40);
        Worker w2 = new Worker(inventory, "Worker-2", 50);
        Worker w3 = new Worker(inventory, "Worker-3", 30);

        w1.start();
        w2.start();
        w3.start();
    }
}