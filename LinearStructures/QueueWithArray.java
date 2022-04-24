package BirinciTekrar.LinearStructures;

import java.util.Arrays;

public class QueueWithArray {
    int[] arr;
    int top;
    int length;

    public QueueWithArray(int length) {
        this.length = length;
        arr = new int[length];
        top = -1;
    }
    public void print(){
        System.out.println(Arrays.toString(arr));
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top == length-1;
    }
    public void enqueue(int data){
        if (!isFull()){
            arr[++top] = data;
        }else {
            System.out.println("Kuyruk dolu");
        }
    }
    public int dequeue(){
        if (isEmpty()){
            System.out.println("Kuyruk boş");
            return -1;
        }else {
            int data = arr[0];
            for (int i = 0; i < top; i++) {
                arr[i] = arr[i+1];
            }
            arr[top--] = 0;
            return data;
        }
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("Kuyruk boş");
            return -1;
        }else {
            return arr[0];
        }
    }
    }

