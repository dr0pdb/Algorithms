/*
* Implementation of Radix Sort algorithm used for Integer-Sorting
* I haven't implemented Count-Sort explicitly as it has been done in this algorithm.
* srv_twry
* */

import java.util.*;
import java.io.*;

public class RadixSort{

    //To get the maximum element in the array of size n
    static int getMax(int arr[], int n){
        int max=arr[0];
        for (int i= 1;i<n;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    //To sort the array using count-sort based on the significant digit
    static void countSort(int arr[], int n, int factor){
        int[] output = new int[n];

        //the digit can only be between 0 - 9
        int[] count = new int[10];
        Arrays.fill(count,0);

        //store the count of each digit in the count array
        for (int i=0;i<n;i++){
            count[(arr[i]/factor)%10]++;
        }

        //Now change the count array so that each index now stores the position of the element
        for (int i=1;i<10;i++){
            count[i]+=count[i-1];
        }

        //generating the output array
        for (int i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/factor)%10 ] - 1] = arr[i];
            count[ (arr[i]/factor)%10 ]--;
        }

        //copying the contents into the original array
        for (int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }

    static void radixSort(int arr[],int n){
        int max= getMax(arr,n);
        for (int factor=1;max/factor>0;factor*=10){
            countSort(arr,n,factor);
        }
    }
    // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }


    /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixSort(arr, n);
        print(arr, n);
    }

}