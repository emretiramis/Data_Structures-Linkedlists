package SinglyLinkedList;

// Node sınıfı
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// SinglyLinkedList sınıfı
class SinglyLinkedList {
    Node head;

    // Başa ekleme metodu
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Sona ekleme metodu
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Belirli bir pozisyona ekleme metodu
    public void addAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Pozisyon geçersiz.");
            return;
        }

        Node newNode = new Node(data);

        if (position == 0) {
            addFirst(data);
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Pozisyon liste sınırları dışında.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Baştan silme metodu
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Liste boş.");
        } else {
            head = head.next;
        }
    }

    // Sondan silme metodu
    public void deleteLast() {
        if (head == null) {
            System.out.println("Liste boş.");
        } else if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    // Belirli bir pozisyondan silme metodu
    public void deleteAtPosition(int position) {
        if (position < 0) {
            System.out.println("Pozisyon geçersiz.");
            return;
        }

        if (head == null) {
            System.out.println("Liste boş.");
            return;
        }

        if (position == 0) {
            deleteFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Pozisyon liste sınırları dışında.");
        } else {
            current.next = current.next.next;
        }
    }
    public int findMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // Listeyi yazdırma metodu
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addAtPosition(15, 1); // 1. pozisyona ekle
        list.printList(); // Çıktı: 10 -> 15 -> 20 -> null

        list.deleteFirst();
        list.printList(); // Çıktı: 15 -> 20 -> null

        list.deleteLast();
        list.printList(); // Çıktı: 15 -> null

        list.addLast(30);
        list.addLast(40);
        list.deleteAtPosition(1);

        list.printList(); // Çıktı: 15 -> 40 -> null
        System.out.println(list.findMiddle());
    }
}
