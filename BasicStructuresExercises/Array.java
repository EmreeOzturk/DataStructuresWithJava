package IkinciTekrar;
import java.util.Arrays;
public class Array<T> {
    T[] dizi ;
    int size ;
    public Array(int boyut) {
        dizi = (T[]) new Object[boyut];
        size = 0;
    }
    public void add(T data){
        if (size<dizi.length){
            if (size == 0){
                dizi[0] = data;
                size++;
            }else {
                dizi[size] = data;
                size++;
            }
        }else {
            System.out.println("Dizi dolu");
        }
    }
    public void addInOrder(T data){
        if (size<dizi.length){
            if (size == 0){
                dizi[0] = data;
                size++;
            }else {
                dizi[size] = data;
                int i = size;
                while ((int)dizi[i] < (int)dizi[i-1]){
                    dizi[i] = dizi[i-1];
                    dizi[i-1] = data;
                    i--;
                    if (i == 0){
                        dizi[0] = data;
                        size++;
                        return;
                    }
                }
                size++;
            }
        }else {
            System.out.println("Dizi dolu");
        }
    }
    public int findIndex(T data){
        for (int i = 0; i < size; i++) {
            if (dizi[i] == data){
                return i;
            }
        }
        return -1;
    }
    public void remove(T data){
        int i = findIndex(data);
        if (i == -1) return;
        for (int j = i; j < size; j++) {
            dizi[j] = dizi[j+1];
            if ((j+1) == size-1){
                break;
            }
        }
        dizi[size-1] = null;
        size--;
    }
    public void update(T old,T yeni){
        int i = findIndex(old);
        if (i == -1) return;
        dizi[i] = yeni;
        sirala();
    }
    public void print(){
        System.out.println(Arrays.toString(dizi));
    }
    public void sirala(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - 1) - i; j++) {
                if ((int)dizi[j] > (int)dizi[j+1]){
                    T temp = dizi[j+1];
                    dizi[j+1] = dizi[j];
                    dizi[j] = temp;
                }
            }
        }
    }
}
