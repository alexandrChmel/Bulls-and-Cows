import java.util.Scanner;

// Define the base class Shape
class Shape {
    protected String name;
    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

// Define the derived class Rectangle
class Rectangle extends Shape {
    private int width;
    private int height;
    public Rectangle(String name, int width, int height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Read the shape's name, width, and height from the user input
        String name = scanner.next();
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        // TODO: Create a Rectangle object using the user input
        Rectangle rec = new Rectangle(name, width, height);
        // TODO: Print out the rectangle's name, width, and height
        System.out.println("Name: " + rec.getName());
        System.out.println("Width: " + rec.getWidth());
        System.out.println("Height: " + rec.getHeight());

    }
}