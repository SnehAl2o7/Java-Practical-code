class DebitCard {
    long cardNumber;
    int pin;
    double amount;

    DebitCard(long l, int n, double d) {
        this.cardNumber = l;
        this.pin = n;
        this.amount = d;
    }
}

class CreditCard {
    long cardNumber;
    int CVV;
    double amount;

    CreditCard(long l, int n, double d) {
        this.cardNumber = l;
        this.CVV = n;
        this.amount = d;
    }
}

class NetBanking {
    String BankName;
    long accountNumber;
    String password;
    double amount;

    NetBanking(String name, long num, String pass, double d) {
        this.BankName = name;
        this.accountNumber = num;
        this.password = pass;
        this.amount = d;
    }
}

class UPI {
    String UPIID;
    double amount;

    UPI(String id, double d) {
        this.UPIID = id;
        this.amount = d;
    }
}

public class MethodOverloading {

    public static void printData(DebitCard db) {
        System.out.println("Debit Card Details:");
        System.out.println("Card Number: " + db.cardNumber);
        System.out.println("Pin Code: " + db.pin);
        System.out.println("Amount :" + db.amount);
    }

    public static void printData(CreditCard cc) {
        System.out.println("Credit Card Details:");
        System.out.println("Card Number: " + cc.cardNumber);
        System.out.println("CVV: " + cc.CVV);
        System.out.println("Amount :" + cc.amount);
    }

    public static void printData(NetBanking nb) {
        System.out.println("NetBanking Details:");
        System.out.println("Bank Name: " + nb.BankName);
        System.out.println("Account Number: " + nb.accountNumber);
        System.out.println("Password: " + nb.password);
        System.out.println("Amount :" + nb.amount);
    }

    public static void printData(UPI u) {
        System.out.println("UPI Details:");
        System.out.println("UPI ID: " + u.UPIID);
        System.out.println("Amount :" + u.amount);
    }

    public static void main(String[] args) {
        DebitCard db = new DebitCard(371706539, 5258, 2400.45);
        printData(db);
        CreditCard cc = new CreditCard(1577100101, 2345, 2500.850);
        printData(cc);
        NetBanking nb = new NetBanking("PunjabNaitionalBank", 345456780, "Sneh345", 3000.456);
        printData(nb);
        UPI u = new UPI("SBI3425526@hdfc", 23456.345);
        printData(u);
    }

}