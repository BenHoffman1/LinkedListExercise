public class Node {

    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public String toString() {
        return Integer.toString(data);
    }
}
