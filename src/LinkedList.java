public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node n) {
        // Apparently we were supposed to create a deep copy here
        // If that's the case, why not just pass in data????
        // Passing in a Node object just to use one of its int parameters makes zero sense
        this.head = n;
    }

    public void append(int x) {
        // If list is empty
        if (head == null) {
            head = new Node(x);
            return;
        }
        // otherwise, travel to last element and link it
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(x);
    }

    public void appendList(LinkedList L) {
        Node currentNode = L.head;
        while (currentNode != null) {
            append(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void sorted_insert(int x) {
        Node newNode = new Node(x);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }
        // If we should insert before head
        if (x < head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        // At this point, x should be inserted after head
        Node currentNode = head;

        while (true) {
            // If we've reached the end of the list, append it
            if (currentNode.next == (null)) {
                currentNode.next = newNode;
                return;
            }
            // If the next number is greater, insert it before that number
            if (currentNode.next.data > x) {
                newNode.setNext(currentNode.next);
                currentNode.next = newNode;
                return;
            }
            // Iterate
            currentNode = currentNode.next;
        }

    }

    public LinkedList(LinkedList l) {
        // Make head.data a copy of l.head.data
        if (l.head != null) {
            this.head = new Node(0);
            this.head.data = l.head.data;
        }

        // Set currentNode to l.head
        Node currentNode = l.head;
        // Loop: while currentNode.next != null
        while (currentNode != null) {
            // append currentNode.data
            // set currentNode = currentNode.next
            append(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public Node reverse() {
        Node currentNode = this.head;
        boolean isFirstPass = true;

        // For every non-null node currentNode in original list:
        while (currentNode != null) {

            Node newNode = new Node(currentNode.data);

            // Let newNode point to head every time after first (because we don't want to link to original LinkedList)
            if (!isFirstPass) {
                newNode.setNext(this.head);
            }
            this.head = newNode;

            currentNode = currentNode.next;

            isFirstPass = false;
        }
        return this.head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = this.head;
        while (currentNode != null) {
            sb.append(currentNode.data);
            sb.append(" -> ");
            currentNode = currentNode.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    private int length() {
        Node currentNode = head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    /**
     * returns True if L1 is longer and false otherwise
     */
    public static boolean compares(LinkedList L1, LinkedList L2) {
        return (L1.length() > L2.length());

    }

}
