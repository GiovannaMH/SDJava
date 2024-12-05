Polymorphism in Java is a fundamental concept in object-oriented programming that allows objects of different classes to be treated as objects of a common superclass. 
It enables a single interface to represent different underlying forms (data types). Polymorphism is broadly classified into two types:

- Compile-time Polymorphism (Method Overloading)
- Runtime Polymorphism (Method Overriding)
---
  
### 1. Compile-time Polymorphism (Method Overloading)
Method overloading occurs when multiple methods in the same class have the same name but different parameter lists (different type, number, or both). The compiler determines which method to call based on the method signature.

#### Method Overloading in a Calculator Class
```
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
#### Explanation:

- The Calculator class has multiple add methods with different parameter lists.
- The compiler determines which add method to invoke based on the arguments provided.
- This allows the Calculator class to handle addition operations with varying numbers and types of operands.
---

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
---

### **3. Polymorphism with Interfaces**

Interfaces define methods that implementing classes must provide. This allows for polymorphic behavior where a single interface type can refer to objects of multiple implementing classes.

#### **Example: Polymorphism Using a Shape Interface**

```java
interface Shape {
    void draw();
    double getArea();
}

// Implementing class - Circle
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Implementing class - Rectangle
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
       this.width = width;
       this.height = height;
    }

    @Override
    public void draw() {
       System.out.println("Drawing a rectangle");
    }

    @Override
    public double getArea() {
       return width * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(4, 6);

        shape1.draw();   // Output: Drawing a circle
        System.out.println("Area: " + shape1.getArea());   // Output: Area: 78.53981633974483

        shape2.draw();   // Output: Drawing a rectangle
        System.out.println("Area: " + shape2.getArea());   // Output: Area: 24.0
    }
}
```

**Explanation:**

- The `Shape` interface declares methods `draw()` and `getArea()`.
- `Circle` and `Rectangle` implement `Shape` and provide specific behaviors.
- The `Main` class uses `Shape` references to interact with different shape objects polymorphically.

---

### **4. Polymorphism in Method Parameters and Return Types**

You can use superclass or interface types in method parameters and return types to achieve polymorphic behavior.

#### **Example: Passing Subclass Objects to Superclass Parameters**

```java
class Printer {
    public void printAnimalSound(Animal animal) {
        animal.makeSound();
    }
}

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Animal dog = new Dog();
        Animal cat = new Cat();

        printer.printAnimalSound(dog);   // Output: Woof!
        printer.printAnimalSound(cat);   // Output: Meow!
    }
}
```

**Explanation:**

- The `Printer` class has a method `printAnimalSound()` that accepts an `Animal` object.
- You can pass any object that is a subclass of `Animal` to this method.
- The method calls `makeSound()`, and due to polymorphism, the subclass's overridden method is executed.

---

### **5. Polymorphism with Collections**

Polymorphism is often used with collections to store objects of different subclasses under a common superclass or interface type.

#### **Example: Using Polymorphism with a List of Animals**

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Dog());
        zoo.add(new Cat());
        zoo.add(new Cow());

        for (Animal animal : zoo) {
            animal.makeSound();
        }
        // Output:
        // Woof!
        // Meow!
        // Moo!
    }
}
```

**Explanation:**

- An `ArrayList` of `Animal` type is created.
- Different `Animal` subclass objects are added to the list.
- When iterating over the list, each object's overridden `makeSound()` method is called.

---

### **6. Practical Use Case: Polymorphism in GUI Components**

In Java's Swing library, polymorphism is used extensively.

#### **Example: Handling Different GUI Components**

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIExample {
    public static void main(String[] args) {
        JButton button = new JButton("Click Me");
        JTextField textField = new JTextField("Type here");
        JLabel label = new JLabel("I'm a label");

        JComponent[] components = { button, textField, label };

        for (JComponent component : components) {
            // Polymorphic method call
            component.setVisible(true);
        }
    }
}
```

**Explanation:**

- `JButton`, `JTextField`, and `JLabel` all extend `JComponent`.
- An array of `JComponent` is used to hold different GUI components.
- The `setVisible()` method can be called on each component, demonstrating polymorphism.

---

### **Key Concepts of Polymorphism in Java**

- **Inheritance**: Polymorphism relies on inheritance hierarchies where subclasses inherit from a common superclass.
- **Method Overriding**: Subclasses override methods to provide specific implementations.
- **Dynamic Method Dispatch**: The method to be executed is determined at runtime based on the actual object's type.
- **Interfaces**: Provide a way to achieve polymorphism without inheritance.

---

### **Benefits of Polymorphism**

- **Code Reusability**: Write code that works with superclass types and can handle any subclass.
- **Extensibility**: Easily introduce new subclasses without changing existing code.
- **Maintainability**: Centralize common behaviors in superclasses or interfaces.

---

### **Conclusion**

Polymorphism allows Java programs to process objects that share the same superclass or interface as if they are instances of the superclass, while at the same time preserving their specific behaviors. This leads to flexible and scalable code that is easier to maintain and extend.

---

**Feel free to ask if you need more examples or further clarification on any of these concepts!**
