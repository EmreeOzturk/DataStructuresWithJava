package UcuncuTekrar;

public class QueueWithArray {
    private int[] dizi;
    private int front;
    private int rear;
    private int capacity;

    public QueueWithArray(int capacity) {
        this.dizi = new int[capacity];
        front = -1;
        rear = -1;
        this.capacity = capacity;
    }
    public boolean isFull(){
        return rear == capacity-1;
    }
    public boolean isEmpty(){
        return front == -1;
    }
    public void enQueue(int data){
        if (isFull()){
            System.out.println("Queue is full.");
        }else {
            if (front == -1){
                front = 0;
            }
            rear++;
            dizi[rear] = data;
        }
    }
    public int deQueue(){
        if (isEmpty()){
            return -1;
        }else {
            int temp = dizi[front];
            if (front >= rear){
                front = -1;
                rear = -1;
            }else {
                front++;
            }
            return temp;
        }
    }

}
