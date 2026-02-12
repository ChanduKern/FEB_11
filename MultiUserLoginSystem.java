class LoginUser extends Thread {

    private String userName;

    public LoginUser(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {

        System.out.println(userName + " Login Started at: " + System.currentTimeMillis());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(userName + " Interrupted");
        }

        System.out.println(userName + " Login Successful");
    }
}

public class MultiUserLoginSystem {

    public static void main(String[] args) {

        System.out.println("Main Thread Started");

        LoginUser[] users = new LoginUser[10];

        for (int i = 0; i < 10; i++) {
            users[i] = new LoginUser("User-" + (i + 1));

            System.out.println("Before start(): " + users[i].getState());

            users[i].start();

            System.out.println("After start(): " + users[i].getState());
        }

        System.out.println("Main Thread Finished");
    }
}