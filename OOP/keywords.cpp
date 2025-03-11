#include <iostream>
using namespace std;

    // ---------------- Static Keyword ----------------
    class StaticExample
    {
    public:
        static int count;                                                      // Static variable
        static void showCount() { cout << "Static Count: " << count << endl; } // Static function
    };
    int StaticExample::count = 10; // Static variable initialization

    // ---------------- Virtual Keyword ----------------
    class Base
    {
    public:
        virtual void show() { cout << "Base class function\n"; } // Virtual function
    };
    class Derived : public Base
    {
    public:
        void show() override { cout << "Derived class function\n"; }
    };

    // ---------------- Abstract Class (Pure Virtual Function) ----------------
    class AbstractExample
    {
    public:
        virtual void display() = 0; // Pure virtual function
    };
    class DerivedAbstract : public AbstractExample
    {
    public:
        void display() override { cout << "Implementation of Abstract Class\n"; }
    };

    // ---------------- Final Keyword ----------------
    class FinalExample final
    { // Cannot be inherited
    public:
        void show() { cout << "Final class function\n"; }
    };

    // ---------------- Explicit Keyword ----------------
    class ExplicitExample
    {
    public:
        explicit ExplicitExample(int x) { cout << "Explicit constructor called with " << x << endl; }
    };

    // ---------------- this Keyword ----------------
    class ThisExample
    {
    public:
        void show() { cout << "Address of current object: " << this << endl; }
    };

    // ---------------- new & delete Keywords ----------------
    class MemoryExample
    {
    public:
        int *ptr;
        MemoryExample(int x) { ptr = new int(x); } // Dynamic memory allocation
        ~MemoryExample()
        {
            delete ptr;
            cout << "Memory freed!\n";
        } // Destructor
    };

    // ---------------- const Keyword ----------------
    class ConstExample
    {
    public:
        const int x;
        ConstExample(int val) : x(val) {} // Constant variable initialization
        void show() const { cout << "Const variable: " << x << endl; }
    };

    // ---------------- Main Function ----------------
    int main()
    {
        // Static Keyword
        StaticExample::showCount();

        // Virtual Keyword (Polymorphism)
        Base *b = new Derived();
        b->show();
        delete b;

        // Abstract Class
        DerivedAbstract obj;
        obj.display();

        // Explicit Keyword
        ExplicitExample ex(10);

        // this Keyword
        ThisExample obj2;
        obj2.show();

        // new & delete Keywords
        MemoryExample *mem = new MemoryExample(50);
        delete mem;

        // const Keyword
        ConstExample cobj(99);
        cobj.show();

        return 0;
    }
