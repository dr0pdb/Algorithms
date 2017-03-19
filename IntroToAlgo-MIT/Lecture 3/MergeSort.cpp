/*
    C++ program to implement Merge Sort
    srv_twry
*/

#include<bits/stdc++.h> 

using namespace std;
int n;

void merge(int arr[],int lbegin,int lend,int rbegin, int rend){
    int i=lbegin,j=rbegin;
    int temp[n];
    
    //this will be the index of the temo variable where the value will be inserted
    int point=lbegin;

    while (i<=lend && j<=rend)
    {
        if (arr[i]>arr[j])
        {
            temp[point++]=arr[j++];
        }else
        {
            temp[point++]=arr[i++];
        }
    }

    if (i>lend)
    {
        while (j<=rend)
        {
            temp[point++]=arr[j++];
        }
    }
    else
    {
        while(i<=lend){
            temp[point++]=arr[i++];
        }
    }

    //copying the contents into the main array
    for (size_t i = lbegin; i <= rend; i++)
    {
        arr[i]=temp[i];
    }
}

void mergesort(int arr[],int begin,int end){

    if (begin<end)
    {
        int mid=(begin+end)/2;
        mergesort(arr,begin,mid);
        mergesort(arr,mid+1,end);
        merge(arr,begin,mid,mid+1,end);   
    }
    
}

int main(){

    //number of elements
    scanf("%d",&n);

    int arr[n];
    for (size_t i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }

    //calling mergesort
    mergesort(arr,0,n-1);

    //Printing the sorted array
    for(int i:arr){
        printf("%d ",i);
    }   
        return 0;
}
