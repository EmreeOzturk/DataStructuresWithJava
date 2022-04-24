package UcuncuTekrar;

public class DoublyLinkedList<T> {
    private static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }
    private int size = 0;
    private Node<T> head;

    public DoublyLinkedList() {
        this.head = null;
    }
    public void print(){
        if ( head == null){
            System.out.println("Liste boş");
        }else {
            Node<T> iter = head;
            while (iter != null){
                System.out.println(iter.data);
                iter = iter.next;
            }
        }
    }
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            size++;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }
    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            size++;
        }else {
            Node<T> iter = head;
            while (iter.next != null){
                iter = iter.next;
            }
            iter.next = newNode;
            newNode.prev = iter;
            size++;
        }
    }
    public void add(T data, int index){
        if (index > size || index<0){
            System.out.println("Buraya eklenemez");
        }else if (index == size){
            addLast(data);
        }else if (index == 0){
            addFirst(data);
        }else {
            Node<T> newNode = new Node<>(data);
            Node<T> iter = head;
            for (int i = 0; i < index-1; i++) {
                iter = iter.next;
            }
            newNode.next = iter.next;
            newNode.prev = iter;
            iter.next.prev = newNode;
            iter.next = newNode;
            size++;
        }
    }
    public void removeFirst(){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            if (size == 1){
                head = null;
                size--;
            }else {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
    }
    public void removeLast(){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            if (size == 1){
                head = null;
                size--;
            }else {
                Node<T> iter = head;
                Node<T> iter2 = head;
                while (iter.next != null){
                    iter2 = iter;
                    iter = iter.next;
                }
                iter2.next = null;
                size--;

            }
        }
    }
    public void removeWithIndex(int index){
        if (head == null){
            System.out.println("Liste boş");
        }else{
            if (index < 0 || index >= size){
                System.out.println("Illegal Arg.");
            }else if (index == size-1){
                removeLast();
            }else if (index == 0){
                removeFirst();
            }else {
                Node<T> iter = head;
                Node<T> iter2 = head;
                for (int i = 0; i < index; i++) {
                    iter2 = iter;
                    iter = iter.next;
                }
                iter2.next = iter.next;
                iter.next.prev = iter2;
                size--;
            }
        }
    }
    public void removeWithData(T data){
        if (head == null){
            System.out.println("Liste boş");
        }else{
            int index = findIndex(data);
            if (index == -1){
                System.out.println("Illegal Arg.");
            }else if (index == 0){
                removeFirst();
            }else if (index == size-1){
                removeLast();
            }else {
                Node<T> iter = head;
                for (int i = 0; i < index-1; i++) {
                    iter = iter.next;
                }
                iter.next = iter.next.next;
                iter.next.prev = iter;
                size--;

            }
        }
    }
    public int findIndex(T data){
        if (head == null){
            System.out.println("Liste boş");
            return -1;
        }else {
            Node<T> iteR =head;
            int counter = -1;
            while (iteR != null){
                counter++;
                if (iteR.data == data){
                    return counter;
                }
                iteR = iteR.next;
            }
            return -1;
        }
    }
}
