package OnlinePlatforms.Scaler.DSA.Advanced.Part3;

import Resources.Utilities.PrintHelper;

import java.util.HashMap;


/**
 * @author Harish Velmurugan
 * @last-modified 09-04-2025
 * @since 09-04-2025
 */
@SuppressWarnings("StringTemplateMigration")
public class d40_DoublyLinkedList {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d40_DoublyLinkedList d40_doublyLinkedList = new d40_DoublyLinkedList();
        d40_doublyLinkedList.lruCacheImplementation();
        d40_doublyLinkedList.hardCase();

    }

    /* Section : ----------------------------------- [ Implementation ] ------------------------------------ */

    public void lruCacheImplementation() {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 10);
        lruCache.set(2, 20);
        lruCache.set(3, 30);
        System.out.print("\n" + lruCache.get(1));
        lruCache.set(4, 40);
        System.out.print("\n" + lruCache.get(2));
        System.out.print("\n" + lruCache.get(3));
        lruCache.set(5, 50);
        lruCache.set(5, 60);
        lruCache.set(5, 70);
        lruCache.set(5, 900);
        System.out.print("\n" + lruCache.get(1));
        System.out.print("\n" + lruCache.get(4));
        System.out.print("\n" + lruCache.get(5));
        System.out.println("\n--------------------");
        lruCache.printCache();
    }

    public void hardCase(){
        LRUCache lruCache = new LRUCache(7);
        lruCache.set(2, 1);
        lruCache.set(1, 10);
        lruCache.set(8, 13);
        System.out.println("GET 12 => " + lruCache.get(12));
        lruCache.set(2, 8);
        System.out.println("GET 11 => " + lruCache.get(11));
        System.out.println("GET 7 => " + lruCache.get(7));
        lruCache.set(14, 7);
        lruCache.set(12, 9);
        lruCache.set(7, 10);
        System.out.println("GET 11 => " + lruCache.get(11));
        lruCache.set(9, 3);
        lruCache.set(14, 15);
        System.out.println("GET 15 => " + lruCache.get(15));
        System.out.println("GET 9 => " + lruCache.get(9));
        lruCache.set(4, 13);
        System.out.println("GET 3 => " + lruCache.get(3));
        lruCache.set(13, 7);
        System.out.println("GET 2 => " + lruCache.get(2));
        lruCache.set(5, 9);
        System.out.println("GET 6 => " + lruCache.get(6));
        System.out.println("GET 13 => " + lruCache.get(13));
        lruCache.set(4, 5);
        lruCache.set(3, 2);
        lruCache.set(4, 12);
        System.out.println("GET 13 => " + lruCache.get(13));
        System.out.println("GET 7 => " + lruCache.get(7));
        lruCache.set(9, 7);
        System.out.println("GET 3 => " + lruCache.get(3));
        System.out.println("GET 6 => " + lruCache.get(6));
        System.out.println("GET 2 => " + lruCache.get(2));
        lruCache.set(8, 4);
        lruCache.set(8, 9);
        lruCache.set(1, 4);
        lruCache.set(2, 9);
        lruCache.set(8, 8);
        System.out.println("GET 13 => " + lruCache.get(13));
        System.out.println("GET 3 => " + lruCache.get(3));
        System.out.println("GET 13 => " + lruCache.get(13));
        System.out.println("GET 6 => " + lruCache.get(6));
        lruCache.set(3, 8);
        lruCache.printCache();
        System.out.println("GET 14 => " + lruCache.get(14));
        System.out.println("GET 4 => " + lruCache.get(4));
        lruCache.set(5, 6);
        lruCache.set(10, 15);
        System.out.println("GET 12 => " + lruCache.get(12));
        lruCache.set(13, 5);
        lruCache.set(10, 9);
        lruCache.set(3, 12);
        lruCache.set(14, 15);
        System.out.println("GET 4 => " + lruCache.get(4));
        lruCache.set(10, 5);
        System.out.println("GET 5 => " + lruCache.get(5));
        System.out.println("GET 15 => " + lruCache.get(15));
        lruCache.set(7, 6);
        System.out.println("GET 1 => " + lruCache.get(1));
        lruCache.set(5, 12);
        lruCache.set(1, 6);
        lruCache.set(11, 8);
    }


    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */

    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message) {
        printHelper.print(message, "");
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void definitions() {
        /**/
    }

    private void links() {
        /**/
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}

@SuppressWarnings("StringTemplateMigration")
class LRUCache {
    private int capacity;
    private HashMap<Integer, ListNode> map;
    private DoublyLinkedList cache;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoublyLinkedList();
    }

    public void set(int key, int value) {
        ListNode current;
        if (!map.containsKey(key)) {
            if (map.size() >= capacity) {
                int keyRemoved = cache.removeAtStart();
                map.remove(keyRemoved);
            }
        } else {
            cache.removeFromCache(map.get(key));
        }
        current = cache.insertAtLast(key, value);
        map.put(key, current);
        System.out.print("\nSET : " + key + " == ");
        printCache();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int data = cache.removeFromCache(map.get(key));
            ListNode newNode = cache.insertAtLast(key, data);
            map.put(key, newNode);
            System.out.print("\nGET : " + key + " == ");
            printCache();
            return data;
        }
        System.out.print("\nGET : " + key + " == ");
        printCache();
        return -1;
    }

    public void printCache() {
        cache.printCache();
    }
}

@SuppressWarnings({"StringTemplateMigration"})
class DoublyLinkedList {
    ListNode head;
    ListNode tail;

    DoublyLinkedList() {
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public ListNode insertAtLast(int key, int val) {
        ListNode newNode = new ListNode(key, val);
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        return newNode;
    }

    public int removeAtStart() {
        ListNode nodeToBeRemoved = head.next;
        int keyRemoved = nodeToBeRemoved.key;
        nodeToBeRemoved.next.prev = head;
        head.next = nodeToBeRemoved.next;
        return keyRemoved;
    }

    public int removeFromCache(ListNode current) {
        int data = current.val;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return data;
    }

    public void printCache() {
        ListNode temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.key + ":" + temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
}

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int data) {
        this.key = key;
        this.val = data;
        this.prev = null;
        this.next = null;
    }
}
