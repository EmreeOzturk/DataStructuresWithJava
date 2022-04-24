package IkinciTekrar;

public class RecursiveBinarySearch {

    public static int binarySearch(int max, int min,int data,int[] array){
        if (min > max){
            return -1;
        }else {
            int mid = (min+max)/2;
            if (data == array[mid]){
                return mid;
            }else if (data<array[mid]){
                return binarySearch(mid-1,min,data,array);
            }else {
                return binarySearch(max,mid+1,data,array);
            }
        }

    }
}
