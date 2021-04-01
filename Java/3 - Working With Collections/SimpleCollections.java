import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayList;

public class SimpleCollections {
    public static void main(String[] args) {
        looselyTypedCollection();
        stronglyTypedCollection();
        addingMembersOfAnotherCollection();
        equalsMethodWhenRemovingMembers();
    }

    // ===== Example of how loosely typed collections work =====
    private static void looselyTypedCollection () {
        
        printMethodHeader("looselyTypedCollection");

        // This ArrayList doesnt declare the type that it holds, which means that it holds type Object. 
        // which is pretty much all class types in Java 
        ArrayList list = new ArrayList();

        // The ArrayList gets as big/smaller as it needs to Dynamically 
        list.add("Foo1");
        list.add("Bar1");

        // Keeps track of how many elements are inside of it, and we can call it with the size method 
        System.out.println("Elements: " + list.size());

        // It's iterable so we can for loop through it, but we need to cast it to type object
        for (Object o : list)
            System.out.println(o.toString()); 
            // the call to println would call the toString() method automatically, it's just written there to show it explicitly

        // since our ArrayList holds type Object, we can add other classes into it, like the nestedClass here
        // NORMALLY WE DON'T WANT TO HAVE A COLLECTION THAT ACCEPTS TYPE OBJECT, WE NORMALLY WANT TO RESTRICT
        // THE TYPE WE PUT INSIDE A COLLECTION
        list.add(new TestingToString());
        System.out.println(list.get(2));
    }

    // ===== example of how strongly typed collections work =====
    private static void stronglyTypedCollection () {

        printMethodHeader("stronglyTypedCollection");

        // This ArrayList is of type String, so it can only hold String values. 
        ArrayList<String> list = new ArrayList<>();

        // The ArrayList gets as big/smaller as it needs to Dynamically 
        list.add("Foo2");
        list.add("Bar2");

        // Keeps track of how many elements are inside of it, and we can call it with the size method 
        System.out.println("Elements: " + list.size());

        // It's iterable so we can for loop through it without casting it to Object
        for (String s : list)
            System.out.println(s); 
            // No need to call toString() because we are getting the string value directly 

        // This wouldnt work, because we specified that our collection can only work with type string 
        // list.add(new NestedClass());
        // System.out.println(list.get(2));
    }

    // ===== Example of different collections can use common methods =====
    private static void addingMembersOfAnotherCollection () {
    
        printMethodHeader("addingMembersOfAnotherCollection");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Foo3");
        list1.add("Bar3");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Baz");
        list2.add("Boo");

        // list1 & list2 are 2 different types of collections, but they both implement the collection Interface,
        // So we can do things like call addAll() to add all the members from list2 into list1
        list1.addAll(list2); 

        System.out.println("Elements in list1 after addAll():");

        for (String s : list1)
            System.out.println(s); 
    }

    // ===== Example  equality is tested for common equality-based methods =====
    private static void equalsMethodWhenRemovingMembers () {
    
        printMethodHeader("equalsMethodWhenRemovingMembers");

        ArrayList<TestingEqualsMethod> list = new ArrayList<>();
        
        TestingEqualsMethod v1 = new TestingEqualsMethod("v1", "abc");
        TestingEqualsMethod v2 = new TestingEqualsMethod("v2", "abc");
        TestingEqualsMethod v3 = new TestingEqualsMethod("v3", "abc");

        list.add(v1);
        list.add(v2);
        list.add(v3);

        // We might think this will remove the v3 we added, but this is not doing a referrence equals 
        // is using the value of the class equals() method. So the first member it finds & matches that 
        // returns true, will be removed.
        list.remove(v3);

        // We get back v2 & v3, because all 3 members had the exact same value variable (abc), 
        // and our equals test was only on the value variable. 
        for (TestingEqualsMethod obj : list)
            System.out.println(obj.label); 
    }

    private static void printMethodHeader (String methodHeader) {
        System.out.println(String.format("\n===== %s =====\n", methodHeader));
    }

    private static class TestingToString {
        @Override
        public String toString() {
            return "**** printing from nested class ****";
        }
    }

    private static class TestingEqualsMethod {
        String label, value; // getters/setters elided for clarity

        public TestingEqualsMethod (String label, String value) {
            this.label = label;
            this.value = value;
        }

        @Override
        public boolean equals (Object obj) {
            TestingEqualsMethod other = (TestingEqualsMethod) obj;
            return value.equalsIgnoreCase(other.value);
        }
    }
}
