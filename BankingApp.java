import java.util.*;

class Balance extends Exception {
    public Balance() {
        super("Error: Account balance is less than $1000!");
    }
}

class Overdraw extends Exception {
    public Overdraw() {
        super("Error: Withdrawl amount exceeds balance!");
    }
}

class Limit extends Exception {
    public Limit() {
        super("Error: Withdrawl amount exceeds daily limit!");
    }
}

class DailyLimit extends Exception {
    public DailyLimit() {
        super("Error: On-day transaction exceeds $1,00,000!");
    }
}

class BankAccount {
    private String Holder;
    private double balance;
    private int transcnt;
    private double dailytrans;

    public BankAccount(String name, double balance) throws Balance {
        this.Holder = name;
        this.balance = balance;
        this.transcnt = 0;
        this.dailytrans = 0;

        if (balance < 1000) {
            throw new Balance();
        }
    }

    public void deposit(double amount) throws Limit, DailyLimit {
        if (transcnt >= 3) {
            throw new Limit();
        }
        if (dailytrans + amount > 100000) {
            throw new DailyLimit();
        }
        balance += amount;
        transcnt++;
        dailytrans += amount;
        System.out.println("Deposit successful" + amount);
    }

    public void withdraw(double amount) throws Balance, Overdraw, Limit, DailyLimit {
        if (transcnt >= 3) {
            throw new Limit();
        }
        if (amount > balance) {
            throw new Overdraw();
        }
        if (dailytrans + amount > 100000) {
            throw new DailyLimit();
        }

        balance -= amount;
        transcnt++;
        dailytrans += amount;

        if (balance < 1000) {
            throw new Balance();
        }
        System.out.println("Withdrawl successful" + balance);
    }

    public void showBalance() {
        System.out.println("Current Balance: $" + balance);
        System.out.println("Name : " + Holder);
    }

    public void resetTrans() {
        transcnt = 0;
        dailytrans = 0;
        System.out.println("Transaction count reset for the new day.");
    }
}

public class BankingApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Initial Balance: ₹");
            double initialBalance = sc.nextDouble();

            BankAccount account = new BankAccount(name, initialBalance);

            while (true) {
                System.out.println("\nBanking Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Show Balance");
                System.out.println("4. Reset Transactions (New Day)");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ₹");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ₹");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.showBalance();
                        break;
                    case 4:
                        account.resetTrans();
                        break;
                    case 5:
                        System.out.println("Exiting. Thank you!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
