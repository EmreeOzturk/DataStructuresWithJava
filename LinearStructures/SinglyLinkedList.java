package BirinciTekrar.LinearStructures;

public class SinglyLinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }
    }
    Node head;
    Node tail;
    int size;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    public void print(){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            Node temp = head;
            while (temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null){
            head =newNode;
            tail = newNode;
            size++;
        }else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null){
            addFirst(data);
        }else{
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
    public void addIndex(int data,int index){
        if(index < 0 || index > size){
            System.out.println("Hatalı index");
        }else {
            if (head == null){
                addFirst(data);
            }else if (index == 0){
                addFirst(data);
            }else if (index == size){
                addLast(data);
            }else {
                Node newNode = new Node(data);
                Node iter = head;
                for (int i = 0; i < index-1; i++) {
                    iter = iter.next;
                }
                newNode.next = iter.next;
                iter.next = newNode;
                size++;
            }
        }
    }
    public void deleteFirst(){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            if (size == 1){
                tail = tail.next;
            }
            head = head.next;
            size--;
        }
    }
    public void deleteLast(){
        if (head == null){
            System.out.println("Liste boş");
        }
        if (size == 1)
            deleteFirst();
        else {
            Node iter = head;
            Node iter2 = head;
            while (iter.next != null){
                iter2 = iter;
                iter = iter.next;
            }
            tail = iter2;
            iter2.next = null;
            size--;
        }
    }
    public void deleteIndex(int index){
        if (head == null){
            System.out.println("Liste boş");
        }else {
            if ( index == 0){
                deleteFirst();
            }else if (index == size-1){
                deleteLast();
            }else if (index < 0 ||index >= size){
                System.out.println("Yanlış index");
            }else {
                Node iter = head;
                for (int i = 0; i < index-1; i++) {
                    iter = iter.next;
                }
                iter.next = iter.next.next;
                size--;
            }
        }
    }
    public void deleteData(int data){
        if (head == null){
            System.out.println("Liste boş");
        }else {
           int index = findIndex(data);
           if (index == -1){
               System.out.println("Böyle bir data yok");
               return;
           }
           deleteIndex(index);
        }
    }
    public int findIndex(int data){
        int index = -1;
        if (head == null){
            System.out.println("Liste boş");
            return index;
        }else {
            Node iter = head;
            while (iter != null){
                index++;
                if (iter.data == data){
                    return index;
                }
                iter = iter.next;
            }
            return (index == 4) ? -1:-1;
        }
    }
    public void sirala(){
        if (head == null){
            System.out.println("Sıralanacak değer yok");
        }else {
            Node n = head;
            while (n.next != null){
                Node n2 = head;
                Node n3 = head;
                while (n2.next != null){
                    if ((int)n2.data > (int)n2.next.data){
                        if (n2 == head){
                            if (size == 2){
                                Node newNode = new Node(n2.data);
                                head = head.next;
                                head.next = newNode;
                                return;
                            }else {
                                Node newNode = new Node(n2.data);
                                newNode.next = head.next.next;
                                head = head.next;
                                head.next = newNode;
                            }
                        }else {
                            Node newNode = new Node(n2.data);
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

}}
