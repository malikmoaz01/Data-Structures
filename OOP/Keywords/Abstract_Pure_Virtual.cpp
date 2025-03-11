#include <iostream>
using namespace std;

	class Shape {
	public:
	    virtual void draw() = 0; // Pure virtual function (Abstract Method)
	};
	
	class Circle : public Shape {
	public:
	    void draw() override { cout << "Drawing Circle\n"; }
	};
	
	class Square : public Shape {
	public:
	    void draw() override { cout << "Drawing Square\n"; }
	};

int main() {
    // Shape obj; ? ERROR: Abstract class ka object nahi ban sakta

    Shape* s1 = new Circle();
    Shape* s2 = new Square();

    s1->draw();  // Calls Circle's draw()
    s2->draw();  // Calls Square's draw()

    delete s1;
    delete s2;
    return 0;
}
