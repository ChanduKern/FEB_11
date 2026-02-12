class BankAccount {

    private String name;

    public BankAccount(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class DeadlockBankTransfer {

    public static void main(String[] args) {

        BankAccount accountA = new BankAccount("Account-A");
        BankAccount accountB = new BankAccount("Account-B");

        Thread t1 = new Thread(() -> {

            synchronized (accountA) {

                System.out.println("Thread-1 locked " + accountA.getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                System.out.println("Thread-1 trying to lock " + accountB.getName());

                synchronized (accountB) {
                    System.out.println("Thread-1 transferred money");
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (accountB) {

                System.out.println("Thread-2 locked " + accountB.getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                System.out.println("Thread-2 trying to lock " + accountA.getName());

                synchronized (accountA) {
                    System.out.println("Thread-2 transferred money");
                }
            }
        });

        t1.start();
        t2.start();
    }
}