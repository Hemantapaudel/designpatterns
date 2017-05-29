# Adapter Design Pattern

Allow two incompatible interface to work together.
Use when client expects a (target) interface

The classes/objects participating in adapter pattern:
* Target - defines the domain-specific interface that Client uses.
* Adapter - adapts the interface Adaptee to the Target interface.
* Adaptee - defines an existing interface that needs adapting.
* Client - collaborates with objects conforming to the Target interface.