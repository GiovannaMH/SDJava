// Method Overloading in a Calculator Class
public class Calculator {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method to add an array of integers
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int sum1 = calc.add(5, 10);                   // Calls add(int, int)
        int sum2 = calc.add(1, 2, 3);                 // Calls add(int, int, int)
        double sum3 = calc.add(2.5, 3.5);             // Calls add(double, double)
        int sum4 = calc.add(new int[]{1, 2, 3, 4});   // Calls add(int[])

        System.out.println("Sum1: " + sum1);    // Output: Sum1: 15
        System.out.println("Sum2: " + sum2);    // Output: Sum2: 6
        System.out.println("Sum3: " + sum3);    // Output: Sum3: 6.0
        System.out.println("Sum4: " + sum4);    // Output: Sum4: 10
    }
}
