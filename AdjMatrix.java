import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AdjMatrix {

    public static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;

        Edge(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }

        public int compareTo(Edge o){
            if(o==null){
                return 1;
            }
            return this.w-o.w;
        }
    }
    int vertices;
    int matrix[][];
    Edge edges[];   //Arrrey list maa rakhyo bhanee dynamic hunxa

    AdjMatrix(int vertices){
        this.vertices = vertices;
        matrix =new int [vertices][vertices];
        edges=new Edge[vertices*(vertices-1)/2];
    }
//    void addEdge(int source, int destination) {
//        matrix[source][destination] = 1;
//        matrix[destination][source] = 1;
//    }
    int count =0;
    void addEdge(int source, int destination, int weight){
        matrix[source][destination] = weight;
        matrix[destination][source] = weight;
        edges[count++]=new Edge(source,destination, weight);
    }

    void krushkal(){
        int size[]=new int[vertices];                       //Union by raking
        int parent[]=new int[vertices];                     // disjoint set lai define garna lai chiyeko

        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        Arrays.sort(edges);
        int mst[][]= new int[vertices][vertices];

        int edgeTaken = 0;
        int edgecounter=0;
        while(edgeTaken<=vertices-1){
//            edgeTaken++;                    //sort bhaisakyo
            Edge e=edges[edgecounter++];        //minimum weight 0 maa store bhairako xa
            int u_absroot= find(e.u,parent);
            int v_absroot= find(e.v, parent);
            if(u_absroot == v_absroot){
                continue;               //feri while loop feri ewcute hoss bhanxa

            }
            mst[e.u][e.v]=e.w;
            edgeTaken++;
            union(u_absroot,v_absroot,size, parent);
        }
    }
    void union(int uabsroot, int vabsroot, int size[], int parent[]){
        if (size[vabsroot] > size[uabsroot]) {
            parent[uabsroot]=vabsroot;
        }
        else if (size[uabsroot] > size[vabsroot]) {
            parent[vabsroot] = uabsroot;
        }
        else{
            parent [vabsroot]=uabsroot;
            size[uabsroot]++;
        }
    }

    int find(int rootnode, int[] parent) {     //rootnode= u
        if (parent[rootnode] == -1) {
            return rootnode;
        }
        return parent[rootnode] = find(parent[rootnode], parent);
    }


    public void BFS(int rootnode){
        System.out.println("BFS Traversing");
        Queues q =new Queues(vertices);
        boolean visited[]=new boolean[vertices];
        q.enqueue(rootnode);
        visited[rootnode]=true;
        while (!q.isEmpty()){
            int x = q.dequeue();
            System.out.println(x);
            Iterator<Integer>iterator=getAdjNodes(x).iterator();
            List<Integer> list1=getAdjNodes(x);
            while (iterator.hasNext()){
                int val= iterator.next();
                if (!visited [val]){
                    q.enqueue(val);
                    visited[val]=true;
                }

            }
        }
    }
    public void depthfirstsearch(int rootnode){
        System.out.println("dfs treversal");
        boolean visited[]=new boolean[vertices];
        dfs(rootnode,visited);
    }
    void dfs(int rootnode, boolean[] visited){
        visited[rootnode]=true;
        System.out.println(rootnode);
        Iterator<Integer>iterator=getAdjNodes(rootnode).iterator();
//        List<Integer> list1=getAdjNodes(x);
        while (iterator.hasNext()){
            int val= iterator.next();
            if(!visited[val]){
                dfs(val,visited);
            }
    }}
    public void toposort(){
        Queues q= new Queues(vertices);
        int indegree[]= new int[vertices];
  //calculating indegree
        for (int i = 0; i<vertices; i++){
            for(int j = 0; j<vertices; j++){
                if (matrix[i][j]!=0){
                    indegree[j]++;
                }
            }
        }
        //populating queue with vertex having 0 indegree
        for (int i=0; i<vertices;i++){
            if(indegree[i]==0){
                q.enqueue(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()){
            count++;
            int x = q.dequeue();
            System.out.println(x);
            for(int j = 0; j<vertices; j++){
                if (matrix[x][j]!=0){
                    indegree[j]--;
                    if(indegree[j]==0){
                        q.enqueue(j);
                    }
                }
            }
        }
        if(count != vertices){
            System.out.println("cycle detected");
        }
    }
    public void printGraph(){
        //visiting in rows
        for(int i = 0;i<vertices;i++){
            //i = row(vertex) is connected to
            System.out.print(i+" is connected to = ");
            //j=travelling through columns
            for (int j = 0; j<vertices; j++){
                //j=0,1,2,3,4,5
                if(matrix[i][j]!=0){   //1 or the weight(magnitude)
                    System.out.print(j+",");
                }
            }
            System.out.println();
        }
    }
    public List<Integer> getAdjNodes(int i){
        ArrayList<Integer> list=new ArrayList<>();
        for(int j = 0; j<vertices;j++){
            //j=
            if(matrix[i][j]!=0){
                list.add(j);
            }
        }

        return list;
    }

    int dijakstra(int source, int destination) {
        int dist[] = new int[vertices];
        boolean visited[] = new boolean[vertices];
        int prevpath[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }
        dist[source] = 0;

        for (int i = 0; i < vertices; i++) {
            int minvertex = findMinimumVertex(dist, visited);
            visited[minvertex] = true;
            Iterator<Integer> iterator = getAdjNodes(minvertex).iterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (!visited[v] && dist[minvertex] + matrix[minvertex][v] < dist[v]) {
                    dist[v] = dist[minvertex] + matrix[minvertex][v];
                }
            }
        }
        // print path using prevpath[] array
        return dist[destination];
    }

    int findMinimumVertex(int[] dist, boolean[] visited) {
        int minvertex = -1;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && (minvertex == -1 || dist[minvertex] > dist[i])) {
                minvertex = i;
            }
        }
        return minvertex;
    }

//    int dijakstra(int source, int destination) {
//        int dist[] = new int[vertices];
//        boolean visited[] = new boolean[vertices];
//        int prevpath[] = new int[vertices];
//
//        for (int i = 0; i < vertices; i++) {
//            dist[i] = Integer.MAX_VALUE;
//            prevpath[i] = -1;
//        }
//        dist[source] = 0;
//
//        for (int i = 0; i < vertices; i++) {
//            int minvertex = findMinimumVertex(dist, visited);
//            visited[minvertex] = true;
//            Iterator<Integer> iterator = getAdjNodes(minvertex).iterator();
//            while (iterator.hasNext()) {
//                int v = iterator.next();
//                if (!visited[v] && dist[minvertex] + matrix[minvertex][v] < dist[v]) {
//                    dist[v] = dist[minvertex] + matrix[minvertex][v];
//                }
//            }
//        }
//        // print path using prevpath[] array
//        return dist[destination];
//    }

//    int findMinimumVertex(int[] dist, boolean[] visited) {
//        int minvertex = -1;
//        for (int i = 0; i < vertices; i++) {
//            if (!visited[i] && (minvertex == -1 || dist[minvertex] > dist[i])) {
//                minvertex = i;
//            }
//        }
//        return minvertex;
//    }

    public static void main(String[] args) {
        AdjMatrix adj = new AdjMatrix(5);
//        adj.addEdge(0,1);
//        adj.addEdge(0,2);
//        adj.addEdge(0,4);
//        adj.addEdge(1,4);
//        adj.addEdge(2,4);
//        adj.addEdge(2,3);
//        adj.addEdge(3,4);
        List<Integer> adjNodes=adj.getAdjNodes(1);
        System.out.println(adjNodes);
//        adj.printGraph();
    }
}
