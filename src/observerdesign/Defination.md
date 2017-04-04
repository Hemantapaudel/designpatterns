
# Observer design Pattern:
# Definition-1
The Observer pattern is a software design pattern in which an object, called the subject (Publisher), maintains a list of its dependents, called observers (Subscribers), and notifies them automatically of any state changes, usually by calling one of their methods.

# Definition 2
Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

The idea behind the pattern is simple - one of more Observers are interested in the state of a Subject and register their interest with the Subject by attaching themselves. When something changes in our Subject that the Observer may be interested in, a notify message is sent, which calls the update method in each Observer. 