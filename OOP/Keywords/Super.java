class Parent {
    public void show() {  // 
        System.out.println("Parent class function");
    }
}

class Child extends Parent {
    public void show() {
        super.show();  // 🔥 Calls parent class function
        System.out.println("Child class function");
    }
}

public class Super {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}
