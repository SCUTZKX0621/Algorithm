package minimumSpanningTree;

public class main
{
    public static void main(String[] args) {
        //这个图的定义方式是邻接矩阵，两个点之间若有连接，则将该边的权重赋值到矩阵中该边的起点、终点为下标的位置中
        int [][]graph = new int[6][6];
        graph[0][1]=20;
        graph[0][2]=12;
        graph[0][4]=9;
        graph[2][4]=10;
        graph[2][3]=18;
        graph[1][3]=6;
        graph[1][5]=5;
        graph[3][5]=7;
        graph[3][4]=14;
        graph[1][4]=11;
        Kruskal k1 = new Kruskal();
        k1.kruskal(graph);
    }
}
