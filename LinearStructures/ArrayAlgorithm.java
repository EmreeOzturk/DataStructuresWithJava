package BirinciTekrar.LinearStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAlgorithm {
    public void rotate(int[] arr, int d,int n){
        int[] yeni = new int[d];
        for (int i = 0; i < d; i++) {
            yeni[i]=arr[i];
        }
        for (int i = 0; i < n-d; i++) {
            arr[i] = arr[i+d];
        }
        for (int i = n-d, j = 0 ; i < n ; i++,j++) {
            arr[i] = yeni[j];
        }
    }
    public void reverse(int[] arr){
        for (int i = 0 , j = arr.length-1; i < arr.length/2; i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public int searchInRotatedArray(int[] arr,int element){
        int pivot = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                break;
            }
            if (arr[i] > arr[i+1]){
                pivot = i;
                break;
            }

        }
        if (element == arr[pivot]){
            return pivot;
        }else if (element >= arr[0]){
            int[] yeni = Arrays.copyOfRange(arr,0,pivot);
            return searchInRotatedArray(yeni,element);
        }else {
            int[] yeni = Arrays.copyOfRange(arr,pivot+1,arr.length);
            return searchInRotatedArray(yeni,element);
        }
    }
    public void printQuerySums(int[] arr, ArrayList<Query> queries){

        for (int i = 0; i < queries.size(); i++) {
            int start = queries.get(i).start;
            int end = queries.get(i).end;
            int sum = 0;
            for (int j = start; j <= end; j++) {
                sum+= arr[j];
            }
            System.out.println("Sum of [" + start +
                    ", " + end + "] is "  + sum);
        }
    }
    public static class Query{
        int start;
        int end;

        public Query(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
