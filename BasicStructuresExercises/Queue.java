package IkinciTekrar;

import java.util.Arrays;

public class Queue<T> {
    T[] dizi;
    int size;

    public Queue(int boyut) {
        dizi = (T[]) new Object[boyut];
        size = 0;
    }
    public void print(){
        System.out.println(Arrays.toString(dizi));
    }
    public void pushInOrder(T data){
        if (size == dizi.length){
            System.out.println("Kuyruk dolu");
        }else{
            dizi[size] = data;
            size++;
            sirala();
        }
    }
    public void sirala(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - 1) - i; j++) {
                if ((int) dizi[j] > (int) dizi[j+1]){
                    T temp = dizi[j+1];
                    dizi[j+1] = dizi[j];
                    dizi[j] = temp;
                }
            }
        }
    }
    public void push(T data){
        if (size == dizi.length){
            System.out.println("Kuyruk dolu");
        }else{
            dizi[size] = data;
            size++;
        }

    }
    public T pop(){
        if (size == 0){
            System.out.println("Kuyruk boş");
            return null;
        }else {
            T data = dizi[0];
            if (size == 1){
                dizi[0] = null;
                size--;
                return data;
            }else{
                for (int i = 0; i < size-1; i++) {
                    dizi[i] = dizi[i+1];
                }
                dizi[size-1] = null;
                size--;
                return data;

            }

        }
    }
}
