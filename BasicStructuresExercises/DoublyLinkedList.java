package IkinciTekrar;

public class DoublyLinkedList<T>{
    private static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }
    private Node<T> head;
    private int size = 0;

    public void print(){
        if (head == null){
            System.out.println("Liste boş");
        }else{
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
        }else{
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
    public void add(T data,int index){
        if (index > size){
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
            Node<T> n = iter.next;
            n.prev = newNode;
            iter.next = newNode;
            size++;

        }
    }
    public T removeFirst(){
        if (head == null){
            System.out.println("Liste boş");
            return null;
        }else {
            if (size == 1){
                T data = head.data;
                head = null;
                size--;
                return data;
            }
            else {
                T data = head.data;
                head = head.next;
                head.prev = null;
                size--;
                return data;
            }

        }
    }
    public T removeLast(){
        if (head == null){
            System.out.println("Liste boş");
            return null;
        }else {
            if (size == 1){
                return removeFirst();
            }else{
                Node<T> iteR =head;
                while (iteR.next != null){
                    iteR = iteR.next;
                }
                T data = iteR.data;
                Node<T> iter2 = iteR.prev;
                iter2.next = null;
                size--;
                return data;
            }
        }
    }
    public void removeGivenData(T data){
        if (head == null){
            System.out.println("Liste boş");
        }else{
            int index = findIndex(data);
            if (index == 0){
                removeFirst();
            }else if (index == -1){
                return;
            } else if (index == size-1){
                removeLast();
            } else {
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
        }else if(data == head.data){
            return 0;
        }else {
            Node<T> iter = head;
            int counter = 0;
            while (iter != null){
                if (iter.data == data ){
                    return counter;
                }
                counter++;
                iter = iter.next;
            }
            System.out.println("Değer bulunamadı");
            return -1;
        }
    }


}
