package BirinciTekrar.LinearStructures;

public class QueueWithLinkedList {
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public QueueWithLinkedList() {
        this.head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void print(){
        if (isEmpty()){
            System.out.println("Kuyruk boş");
        }else {
            Node iter = head;
            while (iter != null){
                System.out.println(iter.data);
                iter = iter.next;
            }
        }
    }
    public void enqueue(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            head = newNode;
        }else {
            Node iteR = head;
            while (iteR.next != null){
                iteR = iteR.next;
            }
            iteR.next = newNode;
        }
    }
    public int dequeue(){
        if (isEmpty()){
            System.out.println("Kuyruk boş");
            return -1;
        }else {
            int data = head.data;
            head = head.next;
            return data;
        }
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("Kuyruk boş");
            return -1;
        }else {
            return head.data;
        }
    }
}
