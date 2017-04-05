
# Observer design Pattern:
# Definition-1
The Observer pattern is a software design pattern in which an object, called the subject (Publisher), maintains a list of its dependents, called observers (Subscribers), and notifies them automatically of any state changes, usually by calling one of their methods.

# Definition 2
Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

The idea behind the pattern is simple - one of more Observers are interested in the state of a Subject and register their interest with the Subject by attaching themselves. When something changes in our Subject that the Observer may be interested in, a notify message is sent, which calls the update method in each Observer. 


# Observer Pattern Pros & Cons
#Pros:

Supports the principle to strive for loosley coupled designs between objects that interact.
Allows you to send data to many other objects in a very efficient manner.
No modification is need to be done to the subject to add new observers.
You can add & remove observers at any time.

#Cons
Java’s built in class Observable forces the use of inheritance vs programming to an interface
Observable protects crucial methods which means you can’t even create an instance of the Observable class and compose it with your own objects, you have to subclass.
If not used carefully the observer pattern can add unnecessary complexity
The order of Observer notifications is undependable  