package IkinciTekrar;

import java.util.Arrays;

public class Stack<T> {
    T[] dizi;
    int size;
    T top;

    public Stack(int boyut) {
        dizi = (T[]) new Object[boyut];
        size = 0;
    }
    public void push(T data){
        if (size<dizi.length){
            dizi[size] = data;
            top = data;
            size++;
        }else {
            System.out.println("Stack dolu");
        }
    }
    public T pop(){
        if (size == 0){
            System.out.println("Stack boş");
            return null;
        }else {
            T data = dizi[size-1];
            dizi[size-1] = null;
            size--;
            top = dizi[size-1];
            return data;
        }
    }
    public void print(){
        if (size == 0){
            System.out.println("Stack boş");
        }else {
            System.out.println(Arrays.toString(dizi));

        }
    }
}
