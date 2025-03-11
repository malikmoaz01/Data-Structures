#include <iostream>
using namespace std;

	class Base {
	protected:
	    int a;
	
	public:
	    Base() {
	        a = 0;
	        cout << "Base Default Constructor Called" << endl;
	    }
	
	    Base(int x) {
	        a = x;
	        cout << "Base Parameterized Constructor Called with a = " << a << endl;
	    }
	
	    Base(const Base &obj) {
	        a = obj.a;
	        cout << "Base Copy Constructor Called" << endl;
	    }
	};
	
	class Derived : public Base {
	private:
	    int b;
	
	public:
	    Derived() : Base() {
	        b = 0;
	        cout << "Derived Default Constructor Called" << endl;
	    }
	
	    Derived(int x, int y) : Base(x) {
	        b = y;
	        cout << "Derived Parameterized Constructor Called with b = " << b << endl;
	    }
	
	    Derived(const Derived &obj) : Base(obj) {
	        b = obj.b;
	        cout << "Derived Copy Constructor Called" << endl;
	    }
	
	    void display() {
	        cout << "a = " << a << ", b = " << b << endl;
	    }
	};

int main() {
    cout << "\nCreating obj1 (Default Constructor):" << endl;
    Derived obj1;
    obj1.display();

    cout << "\nCreating obj2 (Parameterized Constructor):" << endl;
    Derived obj2(10, 20);
    obj2.display();

    cout << "\nCreating obj3 (Copy Constructor):" << endl;
    Derived obj3 = obj2;
    obj3.display();

    return 0;
}
