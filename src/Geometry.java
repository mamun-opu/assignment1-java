import java.util.Arrays;
import java.util.Scanner;

class Point {
    double x;
    double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Triangle{
    Point[] vertices;
    public Triangle(Point[] vertices){
        this.vertices = vertices;
    }
    public double distance(Point v1,Point v2){
        return Math.sqrt(((v1.x - v2.x)*(v1.x - v2.x)) + ((v1.y - v2.y)*(v1.y - v2.y)));
    }
    public void display(){
        System.out.println("distance is: ");
        System.out.println(distance(vertices[0], vertices[1]));
    }
    public boolean is_isosceles(){
        double side1 = distance(vertices[0], vertices[1]);
        double side2 = distance(vertices[1], vertices[2]);
        double side3 = distance(vertices[0], vertices[2]);

        return (side1 == side2) || (side2 == side3) || (side3 == side1);
    }
    public double calculate_perimeter(){
        double side1 = distance(vertices[0], vertices[1]);
        double side2 = distance(vertices[1], vertices[2]);
        double side3 = distance(vertices[0], vertices[2]);
        return side1 + side2 + side3;
    }
}

public class Geometry {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Point[] vertices = new Point[3];

        for (int j = 0; j < 3; j++) {
            System.out.print("Construction of a new point ");
            System.out.print("Please enter x: ");
            double x = scanner.nextDouble();
            System.out.print("Please enter y: ");
            double y = scanner.nextDouble();
            vertices[j] = new Point(x, y);
            System.out.println(vertices[j].x);
            System.out.println(vertices[j].y);
        }
        Triangle triangle = new Triangle(vertices);
        triangle.display();
    }
}
