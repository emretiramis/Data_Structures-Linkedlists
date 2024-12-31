package DoublyLinkedList;



class DoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node head;
    public Node tail;

    // Başa eleman ekleme
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Sona eleman ekleme
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Araya eleman ekleme (belirli bir pozisyona)
    public void addAt(int data, int position) {
        if (position <= 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current == tail) {
            addLast(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    // Baştan eleman silme
    public void removeFirst() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Sondan eleman silme
    public void removeLast() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Belirli bir pozisyondan (arayadan) eleman silme
    public void removeAt(int position) {
        if (position <= 0) {
            removeFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < position && current != null; i++) {
            current = current.next;
        }

        if (current == null) return;
        if (current == head) {
            removeFirst();
        } else if (current == tail) {
            removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Listeyi görüntüleme
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}


