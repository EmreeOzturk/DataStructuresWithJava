package BirinciTekrar.LinearStructures;

public class StackWithLinkedList {
    Node head;
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackWithLinkedList() {
        this.head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }
    public void print(){
        if (isEmpty()){
            System.out.println("Stack boş");
        }else {
            Node iter = head;
            while (iter != null) {
                System.out.println(iter.data);
                iter = iter.next;
            }
        }
    }
    public void push(int data){
        //burda eklerken 2 seçenek var stacki ya sona doğru eklicez (klasik yapı) ya da
        //sürekli başa ekleyip eski head'i head.next yapcaz(tabanca şarjörü gibi).
        // 2 kodu da yazcam.
        Node newNode = new Node(data);
        if (isEmpty()){
            head = newNode;
        }else {
            Node iter = head;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = newNode;
        }/*else{
            Node temp = head;
            head = newNode;
            head.next = temp;
        }*/
    }
    public int pop(){
        if (isEmpty()){
            System.out.println("Stack zaten boş");
            return -1;
        }else {
            Node iter = head;
            Node iter2 = head;
            while (iter.next != null){
                iter2 = iter;
                iter = iter.next;
            }
            int data = iter.data;
            if (iter == head){
                head = null;
                return data;
            }
            iter2.next = null;
            return data;
        }/*else{
            int data = head.data;
            head = head.next;
            return data;
        }*/
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("Stack boş");
            return -1;
        }else {
            Node iter = head;
            while (iter.next != null){
                iter = iter.next;
            }
            return iter.data;
        }/*else {
            return head.data;
        }*/
    }

}
