package IkinciTekrar;


public class SinglyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;
     int size = 0;

    public void print() {
        Node<T> n = head;
        if (n == null) {
            System.out.println("Liste boş");
        } else {
            while (n != null) {
                System.out.println(n.data);
                n = n.next;
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

    public T findWithIndex(int index) {
        if (head == null) {
            System.out.println("Liste boş");
            return null;
        } else {
            Node<T> iter = head;
            for (int i = 0; i < index; i++) {
                iter = iter.next;
            }
            return iter.data;
        }
    }

    public int findWithData(T data) {
        if (head == null) {
            System.out.println("Liste boş");
            return -1;
        } else {
            int counter = 0;
            Node<T> iter = head;
            while (iter != null) {
                if (iter.data == data) {
                    return counter;
                }
                counter++;
                iter = iter.next;
            }
            return -1;
        }
    }

    public T removeLast() {
        if (head == null) {
            System.out.println("Liste boş");
            return null;
        } else {
            Node<T> iter = head;
            Node<T> iter2 = head;
            if (size == 1) {
                T data = iter.data;
                head = null;
                size--;
                return data;
            } else {
                while (iter.next != null) {
                    iter2 = iter;
                    iter = iter.next;
                }
                T data = iter.data;
                iter2.next = null;
                size--;
                return data;

            }


        }
    }
    public void remove(T data){
        if (head == null ){
            System.out.println("Liste boş");
        }else {
            if (findWithData(data) == -1){
                System.out.println("Bu veri listede yok");
            }else {
                Node<T> iter = head;
                Node<T> iter2 = head;
                int index = findWithData(data);
                if (index == 0){
                    removeFirst();
                }
                for (int i = 0; i < index; i++) {
                    iter2 = iter;
                    iter = iter.next;
                }
                iter2.next = iter.next;

                size--;

            }
        }
    }

    public T removeFirst() {
        if (head == null) {
            System.out.println("Liste boş");
            return null;
        } else {
            T data = head.data;
            head = head.next;
            size--;
            System.out.println(data);
            return data;
        }
    }

    public void add(T data, int index) {
        if (index > size) {
            System.out.println("Buraya eklenemez");
        } else {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                size++;
            } else if (index == 0) {
                addFirst(data);
            } else if (index == size) {
                addLast(data);
            } else {
                Node<T> iter = head;
                for (int i = 0; i < index - 1; i++) {
                    iter = iter.next;
                }
                newNode.next = iter.next;
                iter.next = newNode;
                size++;
            }
        }
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            Node<T> iter = head;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = newNode;
            size++;
        }
    }


}
