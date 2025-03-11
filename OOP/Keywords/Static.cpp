#include <iostream>
using namespace std;

    // ---------------- Static Keyword ----------------
    
	class Counter {
	public:
	    static int count; // Static variable
	    Counter() { count++; } // Har object pe count increase hoga
	    void showCount() { cout << "Total Objects: " << count << endl; }
	};
	
	int Counter::count = 0; // Static variable ko initialize karna zaroori hai
	
	int main() {
	    Counter obj1, obj2, obj3;
	    obj3.showCount(); // Static variable ki value print karega
	
	    return 0;
	}