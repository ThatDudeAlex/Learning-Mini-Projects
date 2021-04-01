import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayList;

public class SimpleCollections {
    public static void main(String[] args) {
        looselyTypedCollection();
        stronglyTypedCollection();
        addingMembersOfAnotherCollection();
    }

    private static void looselyTypedCollection () {
        // This ArrayList doesnt declare the type that it holds, which means that it holds type Object. 
        // which is pretty much all class types in Java 
        ArrayList list = new ArrayList();

        // The ArrayList gets as big/smaller as it needs to Dynamically 
        list.add("Foo1");
        list.add("Bar1");

        // Keeps track of how many elements are inside of it, and we can call it with the size method 
        System.out.println("\nElements: " + list.size());

        // It's iterable so we can for loop through it, but we need to cast it to type object
        for (Object o : list)
            System.out.println(o.toString()); 
            // the call to println would call the toString() method automatically, it's just written there to show it explicitly

        // since our ArrayList holds type Object, we can add other classes into it, like the nestedClass here
        // NORMALLY WE DON'T WANT TO HAVE A COLLECTION THAT ACCEPTS TYPE OBJECT, WE NORMALLY WANT TO RESTRICT
        // THE TYPE WE PUT INSIDE A COLLECTION
        list.add(new NestedClass());
        System.out.println(list.get(2));
    }

    private static void stronglyTypedCollection () {
        // This ArrayList is of type String, so it can only hold String values. 
        ArrayList<String> list = new ArrayList<>();

        // The ArrayList gets as big/smaller as it needs to Dynamically 
        list.add("Foo2");
        list.add("Bar2");

        // Keeps track of how many elements are inside of it, and we can call it with the size method 
        System.out.println("\nElements: " + list.size());

        // It's iterable so we can for loop through it without casting it to Object
        for (String s : list)
            System.out.println(s); 
            // No need to call toString() because we are getting the string value directly 

        // This wouldnt work, because we specified that our collection can only work with type string 
        // list.add(new NestedClass());
        // System.out.println(list.get(2));
    }

    private static void addingMembersOfAnotherCollection () {
    
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Foo3");
        list1.add("Bar3");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Baz");
        list2.add("Boo");

        // list1 & list2 are 2 different types of collections, but they both implement the collection Interface,
        // So we can do things like call addAll() to add all the members from list2 into list1
        list1.addAll(list2); 

        System.out.println("\nElements in list1:");

        for (String s : list1)
            System.out.println(s); 
    }

    private static class NestedClass {
        @Override
        public String toString() {
            return "==== printing from nested class ====";
        }
    }
}
