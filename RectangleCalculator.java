class RectangleCalculator {

    public static void main(String[] args) {
        // Rectangle 1
        double length1 = 123.245;
        double width1 = 78.75;

        // Rectangle 2
        double length2 = 4013.11;
        double width2 = 2451.56;

        double area1 = calculateArea(length1, width1);
        double perimeter1 = calculatePerimeter(length1, width1);

        double area2 = calculateArea(length2, width2);
        double perimeter2 = calculatePerimeter(length2, width2);

        System.out.println("Rectangle 1:");
        System.out.println("Area: " + area1 + " square centimeters");
        System.out.println("Perimeter: " + perimeter1 + " centimeters");
        System.out.println();

        System.out.println("Rectangle 2:");
        System.out.println("Area: " + area2 + " square centimeters");
        System.out.println("Perimeter: " + perimeter2 + " centimeters");
    }

    private static double calculateArea(double length, double width) {
        return length * width;
    }

    private static double calculatePerimeter(double length, double width) {
        return 2 * (length + width);
    }
}
