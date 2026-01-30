class Area {
    
    double area(double length, double breadth) {
        return length * breadth;
    }

    double area(double radius) {
        return 3.14 * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Area a = new Area();

        double rectangleArea = a.area(5, 4);
        double circleArea = a.area(3);

        System.out.println(rectangleArea);
        System.out.println(circleArea);
    }
}