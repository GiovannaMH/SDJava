Polymorphism in Java is a fundamental concept in object-oriented programming that allows objects of different classes to be treated as objects of a common superclass. 
It enables a single interface to represent different underlying forms (data types). Polymorphism is broadly classified into two types:

- Compile-time Polymorphism (Method Overloading)
- Runtime Polymorphism (Method Overriding)
  
### 1. Compile-time Polymorphism (Method Overloading)
Method overloading occurs when multiple methods in the same class have the same name but different parameter lists (different type, number, or both). The compiler determines which method to call based on the method signature.

### 2. Runtime Polymorphism (Method Overriding)
Method overriding occurs when a subclass provides a specific implementation of a method already defined in its superclass. The method in the subclass must have the same name, return type, and parameters.
The method to execute is determined at runtime based on the object's actual type.

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
