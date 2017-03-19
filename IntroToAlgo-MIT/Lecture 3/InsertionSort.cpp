/*
    C++ program to implement Insertion Sort
    srv_twry
*/

#include<bits/stdc++.h> 

using namespace std;

int main(){

    //number of elements
    int n;
    scanf("%d",&n);

    int arr[n];
    for (size_t i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }

    //sorting
    for (size_t i = 0; i < n; i++)
    {
        for (int j = i; j >=1; j--){
                if (arr[j-1]>arr[j])
                {
                    swap(arr[j],arr[j-1]);
                }
                else
                {
                    break;
                }
        }
    }
    //printing the sorted array
    for(int i:arr){
        printf("%d ",i);
    }
        return 0;
}
