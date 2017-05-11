#include<bits/stdc++.h> 
#define ABS(a) ((a < 0) ? ((-1)*(a)) : (a))
using namespace std;

int vertex,edges,source,queries;
bool adjMat[1001][1001];

void BFS(int source, int level[]){
    queue<int> q;
    q.push(source);
    int lev;
    bool visited[vertex+1]={false};
    visited[source]=true;
    level[source]=0;
    while(!q.empty()) {
        int i= q.front();
        q.pop();
        lev=level[i];
        for(unsigned j = 1; j <=vertex ; ++j) {
            
            if(adjMat[i][j] && !visited[j]) {
                q.push(j);
                visited[j]=true;
                level[j]=lev+1;
            }
        }
       
    }
}


int main(){
    
    
    scanf("%d",&queries);
    
    int temp1,temp2;

    for(unsigned i = 1; i <= queries; ++i) {
        scanf("%d %d",&vertex,&edges);
        
        for(unsigned j = 1; j <= vertex; ++j) {
            
            for(unsigned k = 1; k <= vertex; ++k) {
                adjMat[j][k]=false;
            }
            
        }
        int level[vertex+1]={0};
        
        for(unsigned j = 1; j <= edges; ++j) {
            scanf("%d %d",&temp1,&temp2);
            adjMat[temp1][temp2]=true;
            adjMat[temp2][temp1]=true;
        }
        scanf("%d",&source);
        
        BFS(source,level);
        level[source]=-2;

        
        for(unsigned k = 1; k <= vertex; ++k) {
            
            if(level[k]==-2) {
                continue;
            }else if(level[k]==0){
                printf("-1 ");
            }else{
                printf("%d ",6*level[k]);
            }
            
            
        }
        printf("\n");
    }
       return 0;  
}

