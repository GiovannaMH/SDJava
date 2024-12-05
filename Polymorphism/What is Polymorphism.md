Polymorphism in Java is a fundamental concept in object-oriented programming that allows objects of different classes to be treated as objects of a common superclass. 
It enables a single interface to represent different underlying forms (data types). Polymorphism is broadly classified into two types:

- Compile-time Polymorphism (Method Overloading)
- Runtime Polymorphism (Method Overriding)
  
### 1. Compile-time Polymorphism (Method Overloading)
Method overloading occurs when multiple methods in the same class have the same name but different parameter lists (different type, number, or both). The compiler determines which method to call based on the method signature.

### 2. Runtime Polymorphism (Method Overriding)
Method overriding occurs when a subclass provides a specific implementation of a method already defined in its superclass. The method in the subclass must have the same name, return type, and parameters.
The method to execute is determined at runtime based on the object's actual type.
