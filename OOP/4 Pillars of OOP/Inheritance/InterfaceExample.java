// Defining an interface
interface Animal {
    void makeSound(); // Abstract method
}

// Another interface
interface Pet {
    void showLove();
}

// Implementing both interfaces in a single class
class Dog implements Animal, Pet {
    public void makeSound() {
        System.out.println("Dog barks: Woof Woof!");
    }

    public void showLove() {
        System.out.println("Dog wags its tail!");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
        myDog.showLove();
    }
}
