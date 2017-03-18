/*
    Implementation of the Quick-Find Algorithm
    srv_twry
*/
public class QuickFind{

    private int[] id;

    public QuickFind(int N){
        id= new int[N];
        //set id of each element as its index
        for (int i=0;i<N;i++){
            id[i]=i;
        }
    }

    private boolean connected(int p, int q){
        return (id[p]==id[q]);      //if id is same then they are connected
    }

    public void union(int p, int q){
        int pid=id[p];
        int qid=id[q];
        for (int i=0;i<id.length;i++){
            if (id[i]==pid) id[i] = qid;    //changing the id of all the elements connected to p and q to the id of q
        }
    }

}