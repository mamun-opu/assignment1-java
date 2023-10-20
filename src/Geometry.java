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
    }
}
