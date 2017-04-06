import java.util.*;

/*
* Java Program for HeapSort algorithm using the heap data structure
* srv_twry
* */

public class HeapSort{

    //to store the size of the array
    private static int size;

    public static void sort(int arr[]){

        //builds the max heap from an initial given array
        BuildMaxHeap(arr);

        for (int i=size;i>0;i--) {
            swap(arr, 0, i);
            size--;
            MaxHeapify(arr, 0);
        }
    }

    //method to build the maxHeap from a given array
    public static void BuildMaxHeap(int arr[]){
        size=arr.length-1;

        //i=size/2 using bit operation
        for (int i=(size>>1);i>=0;i--){
            MaxHeapify(arr,i);
        }
    }

    /*method to build a maxHeap from a heap containing one voilation
      It assumes that the left child and the right child are already maxHeaps
    */
    public static void MaxHeapify(int arr[], int root){

        //2*root and 2*root respectively
        int left=(root<<1);
        int right=(root<<1)+1;

        int largest=root;
        if (left<=size && arr[left]>arr[largest]){
            largest=left;
        }
        else{
            largest=root;
        }
        if (right<=size && arr[right]>arr[largest]){
            largest=right;
        }

        if (largest != root){
            swap(arr,root,largest);
            MaxHeapify(arr,largest);
        }

    }

    //to swap the two values in the array
    public static void swap(int arr[], int i1, int i2){
        int temp=arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=temp;
    }

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        //the size of the array to be sorted
        int n;
        System.out.printf("Enter the number of elements in the array:");
        n = scanner.nextInt();

        int arr[]= new int[n];
        System.out.println("Enter the elements");
        //getting the input array to be sorted
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        sort(arr);

        //printing after sorting the array
        System.out.println("The Sorted Array using the HeapSort");

        for (int i=0;i<n;i++){
            System.out.printf(" %d",arr[i]);
        }
    }

}