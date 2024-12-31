package CircularDoublyLinkedList;

class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = this; // Kendisine işaret eder, dairesel yapı
    }
}

class CircularDoublyLinkedList {
    private Node head;

    // Başa ekleme
    public void addToHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Sona ekleme
    public void addToTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
        }
    }

    // Araya ekleme (belirli pozisyona ekleme)
    public void addAtPosition(int data, int position) {
        if (position <= 0) {
            addToHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Baştan silme
    public void deleteFromHead() {
        if (head == null) return;
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    // Sondan silme
    public void deleteFromTail() {
        if (head == null) return;
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            tail.prev.next = head;
            head.prev = tail.prev;
        }
    }

    // Belirli pozisyondan (aradan) silme
    public void deleteAtPosition(int position) {
        if (head == null) return;
        if (position == 0) {
            deleteFromHead();
            return;
        }
        Node temp = head;
        for (int i = 0; i < position && temp.next != head; i++) {
            temp = temp.next;
        }
        if (temp == head) return; // Pozisyon geçersizse
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Listeyi yazdırma
    public void display() {
        if (head == null) {
            System.out.println("Liste boş.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.addToHead(10);
        list.addToTail(20);
        list.addToTail(30);
        list.addAtPosition(15, 1); // Pozisyon 1'e ekler

        System.out.print("Liste: ");
        list.display();

        list.deleteFromHead();
        System.out.print("Baştan silindi: ");
        list.display();

        list.deleteFromTail();
        System.out.print("Sondan silindi: ");
        list.display();

        list.deleteAtPosition(1);
        System.out.print("Pozisyon 1 silindi: ");
        list.display();
    }
}
