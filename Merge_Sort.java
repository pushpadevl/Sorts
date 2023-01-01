import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int n=5;
        int [] arr = {5,4,3,6,3};
        
        mergeSort(arr,0, n-1);

        for(int i:arr)System.out.print(i+" ");
//        System.out.println(Arrays.asList(arr));
    }
    static void mergeSort(int[] arr,int beg, int end){
        if(beg<end){
            int mid = (beg+end)/2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid+1, end);
        
            int lar[] = new int[mid-beg+1];
            int rar[] = new int[end-mid];

            for(int i=0;i<lar.length;i++) lar[i] = arr[i+beg];
            for(int i=0;i<rar.length;i++) rar[i] = arr[i+mid+1];
            
            int l=0,r=0,k=beg;
            while(l<lar.length && r<rar.length)
                arr[k++] = lar[l]<=rar[r] ? lar[l++] : rar[r++];
            
            while(l<lar.length) arr[k++] = lar[l++];
            while(r<rar.length) arr[k++] = rar[r++];
        }
        
    }
}
