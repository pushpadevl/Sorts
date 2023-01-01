import java.util.Random;
class SortAlg{
	
	/*k=no. of buckets
	 *n=size of the bucket
	 *  
	 */ 
	static void bucketSort(int arr[],int n){
		int k=arr.length/n+1;
		int[][] bukarr=new int [k][n];	
	
		int bukin;
		for(int i=0;i<k;i++){
			bukin=0;
			for(int j:arr){
				if((j>=i*n)&&(j<n*(i+1))){
					bukarr[i][bukin]=j;
					/*The asiignment ataches extra zeros to the end of the array
					 * Remove these zeros 
					 * Alter the size of the last sub array
					 * 
					 * */
					if(bukin<(n-1)){
						bukin++;
					}
				}
				
			}	
			System.out.println();
			for(int j:bukarr[i]){
				System.out.print("\tp"+j);	
			}
			insertionSort(bukarr[i]);
			
			System.out.println();
			for(int j:bukarr[i]){
				System.out.print("\ts"+j);	
			}
			}
		System.out.println();
		int p=0;
		for(int[] i:bukarr){
			for(int j:i){
				arr[p]=j;
				if(p<k-1){p++;}
			}	
		}
	}
	
	/*Use Counting Sort only when the range is known. Here
	 * COunt sort is used an an auxillary to the radix sort.
	 * countSort can only take 0-9 valued arrays.
	 * For negative numbers, just extend the count array from -9 to 9
	 * with 19 elements.
	 */
	static void radixSort(int[] arr){
		int rad=1,mx=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>mx){
				mx=arr[i];
			}
		}	
		System.out.println("\nmx="+mx);
		for(;rad<mx;rad*=10){
			countSort(arr,rad);
			for(int a:arr){
				System.out.print("\t"+a);
			}
			System.out.println("\trad="+rad+"\n");
		}
		//uses counting sort
		}
	static void countSort(int []arr,int rad){
		int count[]=new int[10];
		int d=0;
		for(int i:arr){
			d=(i/rad)%10;
			
			count[d]++;
		}
		int k=0,place[]=new int[arr.length];
		
		for(int i=0;i<10;i++){
			k=count[i];
			if(k==0){continue;}
			else if(i==0){
				while(k>0){
					place[k-1]=0;
					k--;
				}
			}	
			else {
				while(k>count[i-1]){
					place[k-1]=i;
					k--;
				}
			}	
		}
		
		int last_index=0;
		for(int i=0;i<arr.length;i++){
			if(i==0){}
			else if(place[i]==(place[i-1]/rad)%10){
				last_index++;}
			else{
				last_index=0;}
				
			for(int j=last_index;j<arr.length;j++){
				if(place[i]==(arr[j]/rad)%10){
					place[i]=arr[j];
					last_index=j;
					break;
				}	
			}
			
			
		}
		for(int a=0;a<arr.length;a++){
			arr[a]=place[a];
	
		}
	
	}
	

	/* Arrays can increase their size when compared to other array of bigger size.
	 * Instead we can use arraylist, but that uses extra space .
	 * Since arrays are mutable and primitive data types are not, we can use this
	 * property of arrays to swap elements.
	 */ 
	static void swap(int a, int b,int[] arr){
		int t=arr[a];
		arr[a]=arr[b];
		arr[b]=t;
		}
		
	/*Merge Sort operates on the same array, just on specific portions of the array
	 * for example (arr,2,4) operates on the portion from index2 to 4.
	 * try using the same thing for Quick Sort.
	 */ 	
	static void qSort(int[] arr,int beg, int end){
			int len=end-beg+1;
		if(len>1){
		
			int i=beg,k=beg-1;
			int pivot=(new Random()).nextInt(len)+beg;
			System.out.println();
			System.out.println("\t"+"k"+"\t"+"i"+"\t"+"pivot"+"\t"+"arr[pivot]");
			for(;i<=end;i++){
				if(arr[pivot]>arr[i]){
					k++;
					swap(k,i,arr);
					if(k==pivot){ //Pivot location is changed, so correcting the pivot location
						pivot=i;
						}	
					}	
				System.out.println("\t"+k+"\t"+i+"\t"+pivot+"\t"+arr[pivot]);		
				}
				//Moving the pivot to its correct location.	
				swap(++k,pivot,arr);
			System.out.println("\t"+"beg="+beg+"end="+end);
			for(int e:arr){System.out.print("\t"+e);}
	
			qSort(arr,beg,k-1);
			qSort(arr,k+1,end);	
			}
		}		
								
	/*Why use min_index instead oof min value of the array*/
	static void selSort(int[] arr){
		int n= arr.length;
		int min_index;
		for(int j=0;j<n;j++){
			min_index=j;//min_index needs to be changed after every iteration
			int i=j+1;
			for(;i<n;i++){
				
				if(arr[i]<arr[min_index]){
					min_index=i;
					}
				}
				
				swap(j,min_index,arr);
				
			}
		}
		
	static void bubbleSort(int[] arr){
		int len=arr.length;
		int temp;
		for(int j =0;j<len;j++){
			for(int i=1;i<len-j;i++){
				if(arr[i-1]>arr[i]){
					temp=arr[i-1];
					arr[i-1]=arr[i];
					arr[i]=temp;
				}		
			}
		}	
	}
	
	static void insertionSort(int[] arr){
		int n= arr.length;
		int i=1,key,j;
		for(;i<n;i++){
			key =arr[i];
			j=i-1;
			while(j>=0&&key<arr[j]){ // we could use binary search on the left part which is already sorted
				arr[j+1]=arr[j];
				j--;
				}
			arr[j+1]=key;	
			}
		}
	
	/*Merge doesn't work properly on unsorted sub-arrays, 
	 * only works on sorted subarrays.
	 * The beg mid end values need to change every time the sort recursively runs.
	 * 2154354321 comes when the mid values is used instead of mean of
	 * beg and end values.*/
	static void merge(int[] arr,int beg,int mid,int end){
			
		int l=mid-beg+1;
		int r = end-mid;
		
		int lar[]=new int[l];
		int rar[]=new int[r];
		
		for(int i=0;i<l;i++){
			lar[i]=arr[i+beg];
			}
		
		for(int i=0;i<r;i++){
			rar[i]=arr[i+mid+1];
			}	
		
		int k=beg,i=0,j=0;
		/*k=0 is the problem. the arr is rewritten fro starting every ine the 
		loop runs. so k should start from beg value*/ 
		while(i<l&&j<r){
			if(lar[i]<=rar[j]){
				arr[k]=lar[i];
				i++;
			}
			else{
				arr[k]=rar[j];
				j++;
			}
			k++;
			}
		while(i<l){
			arr[k]=lar[i];
			i++;
			k++;
			}
		while(j<r){
			arr[k]=rar[j];
			j++;
			k++;
			}	
		}
	static void sort(int[] arr,int beg,int end){
		if(beg<end){
		int mid=(beg+end)/2;
		
		sort(arr,beg,mid);
		sort(arr,mid+1,end);
		merge(arr,beg,mid,end);
		}	
	}
	
	static void shellSort(int [] arr,int inH){
		if(inH>0){
		int temp=0;
		for(int i=0; i+inH<arr.length;i++){
			if(arr[i]>arr[i+inH]){
				temp = arr[i];
				arr[i]=arr[i+inH];
				arr[i+inH]=temp;
			}
		}
		
		System.out.println("h=\t" + inH);
		for(int j:arr){
			System.out.print(j+"\t");
		}
		System.out.println("\n");
		inH=(inH-1)/3;
		shellSort(arr,inH);
		}
	}
	
	public static void main (String[] args) {
		int arr[]= {5,4,2,0,4,1,5,66,0};
		/*Do not run all the sorting algorithms together 
		 * because they are all static methods.
		 * sort(arr,0,arr.length-1);
		 * bubbleSort(arr);
		 * insertionSort(arr);
		 * selSort(arr);
		 */ qSort(arr,0,15);
		 /* shellSort(arr,h);
		 */

		//countSort(arr,10);
		//radixSort(arr);	
		//bucketSort(arr,5);
		/*int h=1;
		while(h<arr.length){
			h=h*3+1;
		}
		if(h>arr.length){
			h=(h-1)/3;
		}*/
		for(int i:arr){
			System.out.print(i+"\t");
			}
		
	}
}

