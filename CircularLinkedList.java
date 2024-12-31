package CircularLinkedList;

// Node sınıfı
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// CircularLinkedList sınıfı
class CircularLinkedList {
    Node head;

    // Başa ekleme metodu
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            head = newNode;
            last.next = head;
        }
    }

    // Sona ekleme metodu
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
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
        for (int i = 0; i < position - 1 && current.next != head; i++) {
            current = current.next;
        }

        if (current.next == head) {
            addLast(data);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Baştan silme metodu
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Liste boş.");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
        }
    }

    // Sondan silme metodu
    public void deleteLast() {
        if (head == null) {
            System.out.println("Liste boş.");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != head) {
                current = current.next;
            }
            current.next = head;
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
        for (int i = 0; i < position - 1 && current.next != head; i++) {
            current = current.next;
        }

        if (current.next == head) {
            System.out.println("Pozisyon liste sınırları dışında.");
        } else {
            current.next = current.next.next;
        }
    }

    // Listeyi yazdırma metodu
    public void printList() {
        if (head == null) {
            System.out.println("Liste boş.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addAtPosition(15, 1); // 1. pozisyona ekle
        list.printList(); // Çıktı: 10 -> 15 -> 20 -> (head)

        list.deleteFirst();
        list.printList(); // Çıktı: 15 -> 20 -> (head)

        list.deleteLast();
        list.printList(); // Çıktı: 15 -> (head)

        list.addLast(30);
        list.addLast(40);
        list.deleteAtPosition(1);
        list.printList(); // Çıktı: 15 -> 40 -> (head)
    }
}

