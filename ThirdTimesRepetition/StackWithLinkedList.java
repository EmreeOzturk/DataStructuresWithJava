package UcuncuTekrar;

public class StackWithLinkedList {
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
    int size ;
    Node head;

    public StackWithLinkedList() {
        head = null;
        this.size = 0;
    }
    public void push(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            size++;
        }else {
            Node iter = head;
            while (iter.next != null){
                iter = iter.next;
            }
            iter.next = newNode;
            size++;
        }
    }
    public int pop(){
        if (head == null){
            System.out.println("Stack boş");
            return -1;
        }if (size == 1){
            int deger = head.data;
            head = null;
            size--;
            return deger;
        }
        else {
            Node iter = head;
            Node iter2 = head;
            while (iter.next != null){
                iter2 = iter;
                iter = iter.next;
            }
            int deger = iter.data;
            iter2.next = null;
            size--;
            return deger;
        }
    }
    public int peek(){
        if (head == null){
            System.out.println("Stack boş");
            return -1;
        }else {
            Node iter = head;
            while (iter.next != null){
                iter = iter.next;
            }
            return iter.data;
        }
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void print(){
        if (head == null){
            System.out.println("Stack boş");
        }else {
            Node iter = head;
            while (iter != null){
                System.out.println(iter.data);
                iter = iter.next;
            }
        }
    }
}
