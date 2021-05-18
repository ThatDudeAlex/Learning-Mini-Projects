The Role of Collections 
-----------------------------

Collections hold and organize values
- Iterable
- Can provide type safety
- Tend to dynamically size

A wide variety of Collections are available
- May be a simple list of values
- can provide optimization or sophistication
    . Ordering
    . Prevent duplicates
    . Manage data as name/value pairs 

-----------------------------
Collections & Type safety
-----------------------------

By default Collections hold Object types
- Must convert return values to desired type
- Doesn't restrict types of values added 

Collections can be type specific 
- Uses the java concept of generics 
- Type specified during collection creation 

Collection type restriction is pervasive 
- Return values appropiately typed 
- Adding values limited to appropiate type 

-----------------------------
Collection Interface
-----------------------------

Each collection has its own features
- But there are many that are in common

Collection Interface 
- Provides common collection methods 
- Implemented by most collection types
    . Map collections are notable exceptions 
- Extends Iterable Interface

Common collection methods
- Size:     Returns number of elements 
- clear:    Removes ll elements
- isEmpty:  Returns true if no elements
- add:      Add a single element
- addAll:   Add all members of another collection 

Common Equality-based methods
- contains:     Returns true if contains element
- containsAll:  Returns true if it contains all elements of another collection
- remove:       Remove element 
- removeAll:    Remove all elements contained in another collection
- addAll:       Remove all elements not contained in another collection 

    * Each of the common equality methods is based on the classes equal method.
