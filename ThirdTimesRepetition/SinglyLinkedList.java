package UcuncuTekrar;

import java.util.ArrayList;

public class SinglyLinkedList<T> {
    private static class Node<T>{
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    int size;
    private Node<T> head;
    public SinglyLinkedList() {
        this.size = 0;
        head = null;
    }
    public void print(){
        if (head == null) System.out.println("Liste boş");
        else {
            Node<T> iter = head;
            while (iter != null){
                System.out.println(iter.data);
                iter = iter.next;
            }
        }
    }
    public T findWithIndex(int index){
        if (index > size ||index<0){
            System.out.println("Invalid Argument");
        }
        if (head == null){
            System.out.println("Liste boş");
            return null;
        }
        else {
            Node<T> iter = head;
            T data = null;
            int counter = 0;
            while (iter.next  != null){
                if (counter == index){
                    data = iter.data;
                    return data;
                }
                iter = iter.next;
                counter++;
            }
            return data;
        }
    }
    public int findWithData(T data){
        if (head == null){
            System.out.println("Liste boş");
            return -1;
        }
        else {
            Node<T> iter = head;
            int index = -1;
            while (iter  != null){
                index++;
                if (data == iter.data){
                    return index;
                }
                iter = iter.next;
            }
            return -1;
        }
    }
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            size++;
        }else {
            newNode.next = head;
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
            size++;
        }
    }
    public void addIndex(T data,int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            size++;
        }
        else if(index == 0){
            addFirst(data);
        }
        else if (index == size){
            addLast(data);
        }
        else {
            Node<T> iteR = head;
            int counter = 0;
            while (iteR != null){
                if (counter == index-1){
                    newNode.next = iteR.next;
                    iteR.next = newNode;
                }
                iteR = iteR.next;
                counter++;
            }
            size++;
        }
    }
    public T removeFirst(){
        if (head == null){
            System.out.println("Liste boş");
            return null;
        }else {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }
    public T removeLast(){
        if (head == null){
            System.out.println("Liste boş");
            return null;
        }else {
            if (size ==1 ){
                removeFirst();
            }
            Node<T> iter = head;
            Node<T> iter2 = head;
            while (iter.next != null){
                iter2 = iter;
                iter = iter.next;
            }
            T data = iter.data;
            iter2.next = null;
            size--;
            return data;
        }
    }
    public void removeIndex(int index){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            if (index == 0){
                removeFirst();
            }else if (index == size-1){
                removeLast();
            }else if (index < 0 ||index>=size){
                System.out.println("Illegal Arg.");
            }else {
                Node<T> iteR =head;
                for (int i = 0; i < index-1; i++) {
                    iteR = iteR.next;
                }
                iteR.next = iteR.next.next;
                size--;
            }
        }
    }
    public void removeData(T data){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            int index = findWithData(data);
            if (index == -1){
                System.out.println("Bu data yok");
            }else if(index == 0){
                removeFirst();
            }else if (index == size-1){
                removeLast();
            }else {
                removeIndex(index);
            }
        }
    }
    public void sirala(){
        if (head == null){
            System.out.println("Sıralanacak değer yok");
        }else {
            Node<T> n = head;
            while (n.next != null){
                Node<T> n2 = head;
                Node<T> n3 = head;
                while (n2.next != null){
                    if ((int)n2.data > (int)n2.next.data){
                        if (n2 == head){
                            if (size == 2){
                                Node<T> newNode = new Node<>(n2.data);
                                head = head.next;
                                head.next = newNode;
                                return;
                            }else {
                                Node<T> newNode = new Node<>(n2.data);
                                newNode.next = head.next.next;
                                head = head.next;
                                head.next = newNode;
                            }
                        }else {
                            Node<T> newNode = new Node<>(n2.data);
                            newNode.next = n2.next.next;
                            n3.next = n2.next;
                            n3.next.next = newNode;
                        }
                    }
                    n3 = n2;
                    n2 = n2.next;
                }
                n = n.next;
            }
        }
    }
    public void reverse(){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            Node<T> i1 = head;
            Node<T> prev = head;
            Node<T> head2;
            while (i1.next != null){
                prev = i1;
                i1 = i1.next;
            }
            head2 = new Node<>(i1.data);
            prev.next = null;
            i1 = head;
            size--;
                for (int j = 0; j < size; j++) {
                    while (i1.next != null){
                        prev = i1;
                        i1 = i1.next;
                    }
                    Node<T> newNode = new Node<>(i1.data);
                    Node<T> i2 = head2;
                    while (i2.next != null){
                        i2 = i2.next;
                    }
                    i2.next = newNode;
                    prev.next = null;
                    i1 = head;
                }
                size++;
                head = head2;
        }
    }
    public void evenOdd(){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            Node<T> iter = head;
            ArrayList<T> odd = new ArrayList<>();
            ArrayList<T> even = new ArrayList<>();
            while (iter != null){
                if ((int)iter.data%2 == 0){
                    even.add(iter.data);
                }else{
                    odd.add(iter.data);
                }
                iter = iter.next;
            }
            T i1 = odd.get(0);
            Node<T> head2 = new Node<>(i1);
            Node<T> iter2 = head2;
            int totalSize = odd.size()+even.size()-1;
            int evens = 0;
            int odds = 1;
            for (int i = 0; i < totalSize; i++) {
                if (i % 2 == 0){
                    Node<T> newNode = new Node<>(even.get(evens));
                    evens++;
                    iter2.next = newNode;
                    iter2 = iter2.next;


                }else {
                    Node<T> newNode = new Node<>(odd.get(odds));
                    odds++;
                    iter2.next = newNode;
                    iter2 = iter2.next;

                }
            }
            head = head2;
        }
    }

}
