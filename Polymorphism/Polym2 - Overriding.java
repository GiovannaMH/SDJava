//Method Overriding with Animal Classes

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
/*
Explanation:

The Animal class defines a method makeSound().
Subclasses Dog, Cat, and Cow override makeSound() with specific implementations.
Even though the reference type is Animal, the overridden methods in the subclasses are called at runtime.
This demonstrates runtime polymorphism, where the method to be invoked is determined at runtime based on the object's actual type.
*/
