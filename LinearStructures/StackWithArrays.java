package BirinciTekrar.LinearStructures;

import java.util.Arrays;

public class StackWithArrays {
    int[] arr;
    int top;
    int length;

    public StackWithArrays(int length) {
        this.length = length;
        arr = new int[length];
        top = -1;
    }
    public void push(int data){
        if(!isFull()){
            arr[++top] = data;
        }else {
            System.out.println("Stack dolu");
        }

    }
    public int pop(){
        if (!isEmpty()){
            int data = arr[top];
            arr[top--]=0;
            return data;
        }else {
            System.out.println("Stack boş");
            return -1; //(-1 mantıklı mı) ??????
        }
    }
    public int peek(){
        if (!isEmpty()){
            return arr[top];
        }else {
            System.out.println("Stack boş");
            return -1;
        }
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == length-1;
    }
    public void print(){
        System.out.println(Arrays.toString(arr));
    }
}
