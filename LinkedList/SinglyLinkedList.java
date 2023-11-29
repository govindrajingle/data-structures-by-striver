
public class SinglyLinkedList {
    public static void main(String[] args) {
        int arr[] = { 11, 22, 33 };
        Node head = convertToLinkedList(arr);
        System.out.println("Linked List before deletion:");
        showLinkedList(head);
        // head = deleteHead(head);
        // System.out.println("\nLinked List after deletion:");
        // showLinkedList(head);

        // head = deleteTail(head);
        // System.out.println("Linked List after deleting tail:");
        // showLinkedList(head);

        // head = deleteKth(head, 3);
        // System.out.println("Linked List after deleting Kth node:");
        // showLinkedList(head);

        // head = deleteByValue(head, 33);
        // System.out.println("Linked List after deleting value:");
        // showLinkedList(head);

        // head = insertHead(head, 88);
        // System.out.println("Linked List after adding inserting element at head:");
        // showLinkedList(head);

        // head = insertTail(head, 99);
        // System.out.println("Linked List after adding inserting element at tail:");
        // showLinkedList(head);

        // head = insertKth(head, 2, 77);
        // System.out.println("Linked List after adding inserting element at Kth:");
        // showLinkedList(head);

        head = insertBeforeVal(head, 100, 22);
        System.out.println("Linked List after adding inserting element before value:");
        showLinkedList(head);
    }

    public static Node insertBeforeVal(Node head, int ele, int val) {
        if (head == null) {
            return new Node(ele);
        }
        if (head.data == val) {
            Node newNode = new Node(ele);
            newNode.next = head;
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == val) {
                Node newNode = new Node(ele);
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
        return head;
    }

    // public static Node insertBeforeVal(Node head, int ele, int val) {
    // if (head == null) {
    // return null;
    // }
    // if (head.data == val) {
    // return new Node(ele, head);
    // }
    // Node current = head;
    // while (current.next != null) {
    // if (current.next.data == val) {
    // Node pos = new Node(ele, current.next);
    // current.next = pos;
    // break;
    // }
    // current = current.next;
    // }
    // return head;
    // }

    public static Node insertKth(Node head, int k, int val) {
        if (k <= 0) {
            return head;
        }
        if (k == 1) {
            Node newNode = new Node(val);
            newNode.next = head;
            return newNode;
        }
        Node current = head;
        int cnt = 1;
        while (current != null && cnt < k - 1) {
            current = current.next;
            cnt++;
        }
        if (current == null) {
            return head;
        }
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    // public static Node insertKth(Node head, int k, int val) {
    // if (head == null) {
    // if (k == 1) {
    // return new Node(val);
    // } else {
    // return head;
    // }
    // }
    // if (k == 1) {
    // return new Node(val, head);
    // }
    // int cnt = 0;
    // Node current = head;
    // while (current != null) {
    // cnt++;
    // if (cnt == (k - 1)) {
    // Node pos = new Node(val, current.next);
    // current.next = pos;
    // break;
    // }
    // current = current.next;
    // }
    // return head;
    // }

    public static Node insertTail(Node head, int x) {
        if (head == null)
            return new Node(x);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node tailNode = new Node(x);
        current.next = tailNode;
        return head;
    }

    public static Node insertHead(Node head, int x) {
        Node newHead = new Node(x);
        newHead.next = head;
        return newHead;
    }

    public static Node deleteByValue(Node head, int val) {
        if (head == null)
            return head;
        if (head.data == val) {
            head = head.next;
            return head;
        }
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.data == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    public static Node deleteKth(Node head, int k) {
        if (head == null)
            return head;
        if (k == 1)
            return head.next;
        int cnt = 0;
        Node current = head;
        Node prev = null;
        while (current != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    public static Node convertToLinkedList(int arr[]) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void showLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node deleteHead(Node head) {
        if (head == null) {
            return null;
        } else {
            return head.next;
        }
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = null;
    }
}
