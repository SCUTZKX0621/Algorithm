package minimumSpanningTree;

import java.util.PriorityQueue;

public class Kruskal {
    private int []parent;
    private int count;
    public void kruskal(int [][] graph){
        int n = graph.length;
        parent = new int[n];
        count = n;
        for(int i=0;i<n;i++){
            parent[i]= i;
        }
        // 根据Kruskal算法的原理，优选选择权重较小的边加入生成树中
        // 建立优先级队列，a[2]-b[2]若小于0，则选择a作为优先级更高的项
        PriorityQueue<int[]>queue = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(graph[i][j]!=0){
                    queue.offer(new int[]{i,j,graph[i][j]});
                    //将各条边依次加入优先队列中，每条边由起点编号、终点编号以及边的权重长度刻画
                }
            }
        }
        while(!queue.isEmpty()&&count>1){
            int []edge = queue.poll();
            //按值传递，find函数查找时，可以理解为复制了一个parent数组进行操作，不会改变全局parent数组的值
            int x = find(edge[0]);
            int y = find(edge[1]);
            // 若这条边的起点和终点所属为同一棵子树，则不将其加入生成树中，否则会形成环

            if(x!=y){
                // 若二者不相同，则选取这条边加入树中，并将终点的parent项赋值给起点，代表这两个点已经连接在一棵树上
                parent[x]=y;
                // count代表生成树还需要加入的边的条数，每加入一条边，count自减
                count--;
                // 打印输出这条边
                System.out.println("("+edge[0]+","+edge[1]+")="+edge[2]);
            }
        }
    }
    //find函数的作用：溯源，查找该点所属的子树的”根“
    private int find(int x){
        if(x!=parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}