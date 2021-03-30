import java.util.ArrayList;

import java.util.ArrayList;

public class SimpleCollection {
    public static void main(String[] args) {
        // This ArrayList doesnt declare the type that it holds, which means that it holds type Object. 
        // which is pretty much all class types in Java 
        ArrayList list = new ArrayList();

        // The ArrayList gets as big/smaller as it needs to Dynamically 
        list.add("Foo");
        list.add("Bar");

        // Keeps track of how many elements are inside of it, and we can call it with the size method 
        System.out.println("\nElements: " + list.size());

        // It's iterable, So we can for loop through it
        for (Object o : list)
            System.out.println(o.toString()); 
            // the call to println would call the toString() method automatically, it's just written there to show it explicitly

        // since our ArrayList holds type Object, we can add other classes into it, like the nestedClass here
        // NORMALLY WE DON'T WANT TO HAVE A COLLECTION THAT ACCEPTS TYPE OBJECT, WE NORMALLY WANT TO RESTRICT
        // THE TYPE WE PUT INSIDE A COLLECTION
        list.add(new NestedClass());
        System.out.println(list.get(2));

    }

    private static class NestedClass {
        @Override
        public String toString() {
            return "==== printing from nested class ====";
        }
    }
}
