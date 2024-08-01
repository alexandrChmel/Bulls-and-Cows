import java.util.Scanner;

// Define the base class Shape
class Shape{
    protected String name;

    Shape(String name) {
        this.name = name;
    }
}
class Rectangle extends Shape{
    public int length;
    public int width;
    Rectangle (String name, int length, int width){
        super(name);
        this.length = length;
        this.width = width;
    }

    public void area(){
        System.out.println(name);
        System.out.println((float) width * length);
    }


}

// Define the derived class Rectangle

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the rectangle's name, length, and width from the user
        String name = scanner.next();
        int length = scanner.nextInt();
        int width = scanner.nextInt();

        // Create an instance of the Rectangle class
        Rectangle rec = new Rectangle(name, length, width);

        // Print the rectangle's name and area
        rec.area();
    }
}