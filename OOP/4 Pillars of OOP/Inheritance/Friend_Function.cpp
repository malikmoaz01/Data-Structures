#include <iostream>
using namespace std;

class Bank {
private:
    int balance;

public:
    Bank(int b) { balance = b; }

    friend void showBalance(Bank b); // Friend Function
};

void showBalance(Bank b) {
    cout << "Balance: " << b.balance << endl;
}

int main() {
    Bank myAccount(5000);
    showBalance(myAccount); // Accessing private data via friend function
    return 0;
}
