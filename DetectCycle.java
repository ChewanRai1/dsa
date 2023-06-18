public class DetectCycle {
    int vertices;
    int size[];
    int parent[];

    DetectCycle(int vertices) {
        this.vertices = vertices;
        size = new int[vertices];
        parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }
    }

    public void isCycleDetected(int u, int v) {           ///void=> Bool
        int uabsroot = find(u);
        int vabsroot = find(v);
        if(uabsroot==vabsroot){
            System.out.println("cycle detected");
            return;
        }
        union (vabsroot, uabsroot);
    }

    int find(int rootnode) {
        if (parent[rootnode] == -1) {
            return rootnode;
        }
        return parent[rootnode] = find(parent[rootnode]);
    }

    void union(int vabsroot, int uabsroot){
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

    public static void main(String[] args) {
        DetectCycle d = new DetectCycle(4);
        d.isCycleDetected(0,1);
    }
}
