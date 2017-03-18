/*Implementation of the QuickUnion algorithm to find Dynamic Connectivity
*/  srv_twry
 */

public class QuickUnion{

    private int id[];
    private int size[];

    public QuickUnion(int N){
            id= new int[N];
            size= new int[N];
            //initialising the arrays
            for(int i=0;i<N;i++){
                id[i]=i;
                size[i]=1;
            }
    }

    //if roots of the two numbers are same then they are connected
    private boolean connected(int p, int q){
            return (root(p)==root(q));
        }

    private int root(int i){
        while(i!=id[i]){
            id[i]=id[id[i]];  //while calculating the root of the number we can make the other nodes along the path to  join the root independantly
            i=id[i];
        }
        return i;
    }

    //making sure that we have smaller tree joining the larger tree not the other way round
    public void union(int p, int q){
        int i=root(p);
        int j=root(q);

        if(i==j)return;
        if(size[i]<size[j]){
               id[i]=j;
               size[j]+=size[i];
        }
        else{
            id[j]=i;
            size[i]+=size[j];
        }
    }
}