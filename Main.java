class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwnerName(String newName) {
        this.ownerName = newName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds!");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + ", Owner: " + ownerName + ", Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("12345", "Prashanthi", 1000);
        BankAccount acc2 = new BankAccount("54321", "Ravi", 500);

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        acc1.deposit(200);

        acc2.withdraw(100);

        acc2.withdraw(1000);
        
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
    }
}
