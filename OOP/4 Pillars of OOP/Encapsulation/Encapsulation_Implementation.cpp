#include <iostream>
using namespace std;

class BankAccount {
private:
    double balance; // Data Hiding

public:
    // Constructor
    BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            balance = 0;
        } else {
            balance = initialBalance;
        }
    }

    // Getter (to access private balance)
    double getBalance() {
        return balance;
    }

    // Setter (to update balance securely)
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            cout << "Deposit successful! New Balance: " << balance << endl;
        } else {
            cout << "Invalid deposit amount!" << endl;
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            cout << "Withdrawal successful! New Balance: " << balance << endl;
        } else {
            cout << "Invalid or insufficient funds!" << endl;
        }
    }
};

int main() {
    BankAccount myAccount(1000); // Creating an object

    cout << "Initial Balance: " << myAccount.getBalance() << endl;

    myAccount.deposit(500);  // Depositing money
    myAccount.withdraw(300); // Withdrawing money

    return 0;
}
