package IkinciTekrar;

public class BubbleSort {
    public static void sirala(int[] dizi){
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0 ; j <(dizi.length-1)-i; j++) {
                if (dizi[j] > dizi[j+1]){
                    int temp = dizi[j];
                    dizi[j] = dizi[j+1];
                    dizi[j+1] = temp;
                }

            }
        }
    }
}
