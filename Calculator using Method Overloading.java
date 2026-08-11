class Calculator {
    
    // Area of a square (1 integer)
    int area(int side) {
        return side * side;
    }

    // Area of a rectangle (2 integers)
    int area(int length, int breadth) {
        return length * breadth;
    }

    // Area of a circle (1 double)
    double area(double radius) {
        return 3.14159 * radius * radius;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Square Area: " + calc.area(5));
        System.out.println("Rectangle Area: " + calc.area(4, 6));
        System.out.println("Circle Area: " + calc.area(2.5));
    }
}
