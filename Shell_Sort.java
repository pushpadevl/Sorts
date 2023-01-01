import java.util.stream.*;
import java.util.*;
public class Shell_Sort {
    public static void main(String[] args) {
        Integer[] arr = {20 ,  7,  17  , 9 , 15 , 11  ,19 ,  8 ,  6,  18 ,  3  , 2  , 4 , 10 , 12 ,  5 , 16  , 1  ,13 , 14};
        //shellSort(arr);
        sort(arr);
        //Remember it is similar to insertion sort
        System.out.println();
        int n = -3;
        //int nr = !n;
        int nrr = ~n;
        String sn = Integer.toBinaryString(n); // returns full 32 bit rep
        //String snr = Integer.toBinaryString(nr); // returns full 32 bit rep
        String snrr = Integer.toBinaryString(nrr); // returns only non-zero bit rep
        
        System.out.println(sn+" "+/*snr+*/" "+snrr);
    }

    public static void shellSort(int[] arr){
        int n = arr.length;

        for(int gap = n/2;gap>0;gap/=2){
            System.out.println("Gap = "+gap);
            for(int i=gap;i<n;i++){
                System.out.println("\ti = "+i + " arr["+i+"] = "+arr[i]);
                int temp = arr[i];
                int j;
                boolean b = false;
                for(j=i; j>=gap && arr[j-gap]>temp; j-=gap){
                    System.out.printf("\t\tj = %d, A[%d] = %d, A[%d] = %d\n",j,j,arr[j],j-gap,arr[j-gap]);
                    arr[j] = arr[j-gap];
                    b=true;
                }
                    arr[j] = temp;
                    if(b){
                    System.out.print("\t");
                    for(int k:arr) System.out.print(k+" ");
                        System.out.println("\n");
                    }                    
            }
        }
    }

    static void sort(Integer []arr){
        int n = arr.length;
        for(int gap = n/2;gap>0;gap/=2){
            for(int i=gap;i<n;i++){
                for(int j=i;j>=gap && arr[j-gap]>arr[j] ; j-=gap){
                    System.out.printf("Swapping %d and %d\n", arr[j-gap], arr[j]);
                    int temp = arr[j];
                    arr[j] = arr[j-gap];
                    arr[j-gap] = temp;
                }
            }
        }
        Stream.of(arr).forEach(x->System.out.print(x+" "));
        /*
        for(int gap = n/2;gap>0;gap/=2){
            //System.out.println("Inside first loop");
            for(int i=gap; i<n;i++){
                //System.out.println("\tInside second loop");
                int temp = arr[i];
                int j;
                boolean b = false;
                for(j=i;j>=gap && temp<arr[j-gap]; j-=gap){
                    b=true;
                    System.out.printf("\n\tSwapping arr[%d], %d with arr[%d],%d\n",j,arr[j],j-gap,arr[j-gap]);
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
                if(b)
                    Stream.of(arr).forEach(x->System.out.print(x+" "));
            }
        }*/
       
        
    }
}
