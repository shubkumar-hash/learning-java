import java.util.*;

public class Collection {

    public static void main(String[] args) {

        // ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList: " + arrayList);

        // LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println("LinkedList: " + linkedList);

        // Vector
        Vector<String> vector = new Vector<>();
        vector.add("X");
        vector.add("Y");
        System.out.println("Vector: " + vector);

        // Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
        System.out.println("Stack pop: " + stack.pop());

       //SET

        // HashSet (no order)
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2); // duplicate ignored
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet (insertion order)
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet (sorted)
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);
        System.out.println("TreeSet: " + treeSet);

        //MAP

        // HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "C");
        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // TreeMap (sorted by key)
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(30, "Thirty");
        treeMap.put(10, "Ten");
        treeMap.put(20, "Twenty");
        System.out.println("TreeMap: " + treeMap);

        //QUEUE

        // PriorityQueue
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(20);
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("PriorityQueue poll: " + priorityQueue.poll());

        // ArrayDeque
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("First");
        deque.addLast("Last");
        System.out.println("Deque: " + deque);

        // ITERATOR

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> iterator = names.iterator();
        System.out.print("Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // COMPARATOR

        List<Integer> numbers = Arrays.asList(5, 2, 9, 1);

        // Ascending
        Collections.sort(numbers);
        System.out.println("Sorted Ascending: " + numbers);

        // Descending using Comparator
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println("Sorted Descending: " + numbers);

        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Rahul"));
        students.add(new Student(1, "Amit"));
        students.add(new Student(2, "Neha"));

        // Sort by id
        students.sort(Comparator.comparingInt(Student::getId));
        System.out.println("Students sorted by ID: " + students);

        // Sort by name
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Students sorted by Name: " + students);
    }
}

class Student {
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    public String toString() {
        return id + "-" + name;
    }
}
