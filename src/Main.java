import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LinkedList l = new LinkedList(new Node(1));
        l.append(2);
        l.append(3);
        l.append(4);
        l.append(7);
        l.append(8);
        l.sorted_insert(5);

        System.out.println("Original List: " + l);
        LinkedList reversed = new LinkedList(l.reverse());
        System.out.println("Reversed list: " + reversed);

        LinkedList l2 = new LinkedList(l);
        l.sorted_insert(10);
        System.out.println("l after inserting 10: " + l);
        l.appendList(new LinkedList(l2.reverse()));
        System.out.println("Combined Lists: " + l);
        System.out.println(LinkedList.compares(l, l2));
    }
}

