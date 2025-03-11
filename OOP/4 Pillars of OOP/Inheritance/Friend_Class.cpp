#include <iostream>
using namespace std;

class Person {
private:
    string healthData = "Blood Pressure: Normal";

    friend class Doctor; // Friend Class
};

class Doctor {
public:
    void checkHealth(Person p) {
        cout << "Checking Patient's Health: " << p.healthData << endl;
    }
};

int main() {
    Person patient;
    Doctor doc;
    doc.checkHealth(patient);
    return 0;
}
