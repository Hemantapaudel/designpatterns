
#Creational Design Patterns

Creational design patterns provide solution to instantiate a object in the best possible way for specific situations.

# Singleton design pattern:
Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine. The singleton class must provide a global access point to get the instance of the class. Singleton pattern is used for logging, drivers objects, caching and thread pool.

To implement Singleton pattern, we have different approaches but all of them have following common concepts.

Private constructor to restrict instantiation of the class from other classes.
Private static variable of the same class that is the only instance of the class.
Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.