# Proxy Design Pattern
* Provide a surrogate or placeholder for another object to control access to it.

This ability to control the access to an object can be required for a variety of reasons: controlling when a costly object needs to be instantiated and initialized, giving different access rights to an object, as well as providing a sophisticated means of accessing and referencing objects running in other processes, on other machines.

#Applicability & Examples

#Virtual Proxies:
delaying the creation and initialization of expensive objects until needed, where the objects are created on demand 

# Remote Proxies: 
providing a local representation for an object that is in a different address space. A common example is Java RMI stub objects. The stub object acts as a proxy where invoking methods on the stub would cause the stub to communicate and invoke methods on a remote object (called skeleton) found on a different machine.

# Protection Proxies: 
where a proxy controls access to Real Subject methods, by giving access to some objects while denying access to others.

#Smart References:  
providing a sophisticated access to certain objects such as tracking the number of references to an object and denying access if a certain number is reached, as well as loading an object from database into memory on demand.