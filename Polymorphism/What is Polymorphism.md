Polymorphism in Java is a fundamental concept in object-oriented programming that allows objects of different classes to be treated as objects of a common superclass. 
It enables a single interface to represent different underlying forms (data types). Polymorphism is broadly classified into two types:

- Compile-time Polymorphism (Method Overloading)
- Runtime Polymorphism (Method Overriding)
  
### 1. Compile-time Polymorphism (Method Overloading)
Method overloading occurs when multiple methods in the same class have the same name but different parameter lists (different type, number, or both). The compiler determines which method to call based on the method signature.
```
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
```

### 2. Runtime Polymorphism (Method Overriding)
Method overriding occurs when a subclass provides a specific implementation of a method already defined in its superclass. The method in the subclass must have the same name, return type, and parameters.
The method to execute is determined at runtime based on the object's actual type.

#### Method Overriding with Animal Classes
```
// Superclass
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass - Dog
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks. Woof!");
    }
}

// Subclass - Cat
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows. Meow!");
    }
}

// Subclass - Cow
class Cow extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Moo!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Superclass reference but subclass objects

        Animal myAnimal; // Reference of type Animal
        myAnimal = new Dog();
        myAnimal.makeSound(); // Outputs: Dog barks

        myAnimal = new Cat();
        myAnimal.makeSound(); // Outputs: Cat meows

        //------------
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        Animal myCow = new Cow();

        myDog.makeSound();    // Output: Woof!
        myCat.makeSound();    // Output: Meow!
        myCow.makeSound();    // Output: Moo!
    }
}
```

#### Explanation:

- The Animal class defines a method makeSound().
- Subclasses Dog, Cat, and Cow override makeSound() with specific implementations.
- Even though the reference type is Animal, the overridden methods in the subclasses are called at runtime.
- This demonstrates runtime polymorphism, where the method to be invoked is determined at runtime based on the object's actual type.
