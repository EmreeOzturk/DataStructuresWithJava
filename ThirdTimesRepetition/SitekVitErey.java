package UcuncuTekrar;

import java.util.Arrays;

public class SitekVitErey {
    private int[] dizi;
    private int top;
    private int length;

    public SitekVitErey(int length) {
        this.dizi = new int[length];
        this.top = -1;
        this.length = length;
    }
    public void push(int data){
        if (isFull()){
            System.out.println("Sitek Dolu");
        }else{
            dizi[++top] = data;
        }
    }
    public int pop(){
        if (isEmpty()){
            System.out.println("Sitek Boş");
            return -1;
        }else{
            return dizi[top--];
        }
    }
    public void yazdir(){
        System.out.println(Arrays.toString(dizi));
    }
    public boolean isFull(){
        return top == length -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int size(){
        return top+1;
    }
}
