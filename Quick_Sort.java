    import java.util.*;

public class Quick_Sort {
    public static void main(String[] args) {
        int n=5;
        int [] arr = {5,4,2,0,4,1,5,66,0};
        
        quickSort(arr,0, n-1);

        for(int i:arr)System.out.print(i+" ");
//        System.out.println(Arrays.asList(arr));
    }
    static void swap(int []arr, int i, int j){
        
        //System.out.println("Swapped ["+i+", "+arr[i]+"] & ["+j+", "+arr[j]+"]");
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void quickSort(int[] arr,int beg, int end){
        if(beg<end){
            int n = end-beg+1, i=beg, k=beg;
            Random random = new Random();
            int pivotIndex = beg + random.nextInt(n);
            
            for(;i<=end;i++){
                if(arr[pivotIndex] > arr[i]){
                    //System.out.print("1. Pivot at ["+pivotIndex+", "+arr[pivotIndex]+"]. ");
                    if(k==pivotIndex) pivotIndex = i;
                    swap(arr, i,k++);
                }
            }
            //System.out.print("2. Pivot at ["+pivotIndex+", "+arr[pivotIndex]+"]. ");
            swap(arr, k, pivotIndex);

			for(int e:arr){System.out.print("\t"+e);}
            System.out.println();
            quickSort(arr, beg, k-1); //No mid is used, instead k
            quickSort(arr, k+1, end); // k is set
        }
        
    }
}
                                  