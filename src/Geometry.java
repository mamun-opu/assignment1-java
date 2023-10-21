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
    public double calculate_area(Point a, Point b, Point c){
        return Math.abs((a.x*(b.y-c.y) + b.x*(c.y-a.y)+c.x*(a.y-b.y))/2.0);
    }
    public boolean is_inside(Point x){
        double A = calculate_area(vertices[0], vertices[1], vertices[2]);
        double A1 = calculate_area(x, vertices[1], vertices[2]);
        double A2 = calculate_area(vertices[0], x, vertices[2]);
        double A3 = calculate_area(vertices[0], vertices[1], x);
        return (A == A1 + A2 + A3);
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
        }
        Triangle triangle = new Triangle(vertices);

        triangle.calculate_perimeter();
        System.out.print("Perimeter: ");
        System.out.print(triangle.calculate_perimeter());
        if(triangle.is_isosceles()) {
            System.out.print(" The triangle is isosceles");
        }else {
            System.out.println(" The triangle is not isosceles");
        }
        System.out.println('\n');
        System.out.println("enter 1 to check if a point is inside this triangle or press any number to dismiss");
        int m = scanner.nextInt();
        if (m == 1){
            System.out.print("Please enter x: ");
            double x = scanner.nextDouble();
            System.out.print("Please enter y: ");
            double y = scanner.nextDouble();
            Point p = new Point(x, y);
            triangle.is_inside(p);
            if (triangle.is_inside(p)){
                System.out.println("The point is in the Triangle");
            }else {
                System.out.println("The point is not in the Triangle");
            }
        }

    }
}
