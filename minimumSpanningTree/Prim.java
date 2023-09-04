package minimumSpanningTree;

public class Prim {
    private int[] dist;//代表不在树上的结点，到距离已有生成树的最近结点的距离
    private int[] parent;//代表被连接到树上的结点，和生成树相连时的”连接处“
    private boolean[] visited;//代表该结点是否被访问过，即是否已经被加入到树上
    private int count;//代表已经连接在树上的结点个数，初始化为0，最后需为n

    public void prim(int [][] graph){
        int n = graph.length;
        dist = new int[n];
        parent = new int[n];
        visited = new boolean[n];
        count = 0;
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }//初始时，树还未建立（为空树），此时所有结点到树的距离均为正无穷
        dist[0] = 0;//选取一个结点，这个结点到树的距离设为0
        parent[0] = -1;//令其为树的“根”
        while(count<n){
            int u = findMinDist();//每次选取距离这棵树最近的结点，第一次选到的是”根“结点，它与树的距离为0
            visited[u] = true;//每次选取一个结点，都将其设为已经被访问
            for(int v=0;v<n;v++){
                if(graph[u][v]!=0&&!visited[v]&&graph[u][v]<dist[v]){
                    // 更新距离操作：如果这次被选取的结点和别的未访问结点有边连接，
                    // 且这条边的权重小于别的结点当前到树的距离，则将这条边的距离更新别的结点到该树的最小距离
                    dist[v] = graph[u][v];
                    //更新parent，如果等会儿别的结点被选中，当前选中的结点，就是别的结点连接到树上的那个“连接处”
                    parent[v] = u;
                }
            }
            count++;
        }
        for(int i=1;i<n;i++){
            System.out.println("("+parent[i]+","+i+")="+graph[parent[i]][i]);
        }
    }
    private int findMinDist(){
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<dist.length;i++){
            if(!visited[i]&&dist[i]<minDist){
                //寻找dist数组还未被访问过的结点中，与生成树距离最近的那个结点
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}