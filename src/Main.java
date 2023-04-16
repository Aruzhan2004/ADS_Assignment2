
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing ArrayList");
        MyList<Integer> myList = new MyArrayList<>();
        // Test add() method
        myList.add(1);
        myList.add(2,1);
        myList.add(3);
        myList.add(3);

        // Test get(int index) method
        System.out.println("Element at index 1: " + myList.get(1)); // Output: Element at index 1: 2

        //Test size() method
        System.out.println("Size of list: " + myList.size()); // Output: Size of list: 4

        // Test remove() method
        myList.remove(1);
        System.out.println("List after removing element at index 1: " + myList); // Output: List after removing element at index 1: [1, 3, 3]

        //Test indexOf() method
        System.out.println("The index of element 3: " + myList.indexOf(3)); // Output: The index of element 3: 1

        //Test lastIndexOf() method
        System.out.println("The last index of element 3: " + myList.lastIndexOf(3)); //Output: The last index of element 3: 2

        //Test contains() method
        System.out.println("Does list contain 3? " + myList.contains(3)); // Output: Does list contain 3? true
        System.out.println("Does list contain 2? " + myList.contains(2)); // Output: Does list contain 2? false


        // Test clear() method
        myList.clear();
        System.out.println("List after clear: " + myList); // Output: List after clear: []

        System.out.println("Testing LinkedList");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Test add() method
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);

        // Test size() method
        System.out.println("Size of list: " + list.size()); // Output: Size of list: 5

        // Test get(int index) method
        System.out.println("Element at index 2: " + list.get(2)); // Output: Element at index 2: 3

        // Test remove(int index) method
        list.remove(1);
        System.out.println("List after removing element at index 1: " + list); // Output: List after removing element at index 1: [1, 3, 4, 3]

        // Test contains(Object o) method
        System.out.println("Does list contain 3? " + list.contains(3)); // Output: Does list contain 3? true
        System.out.println("Does list contain 2? " + list.contains(2)); // Output: Does list contain 2? false

        //Test indexOf() method
        System.out.println("The index of element 3: " + list.indexOf(3)); // Output: The index of element 3: 1

        //Test lastIndexOf() method
        System.out.println("The last index of element 3: " + list.lastIndexOf(3)); //Output: The last index of element 3: 3

        // Test clear() method
        list.clear();
        System.out.println("List after clear: " + list); // Output: List after clear: []

    }
}