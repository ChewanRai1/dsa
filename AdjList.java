import java.util.ArrayList;
import java.util.List;

public class AdjList {
    int vertices;
    LinkedList list[];

    AdjList(int vertices){
        this.vertices = vertices;
        list = new LinkedList[vertices];

        for(int i = 0; i<vertices;i++){
            list[i] = new LinkedList();
        }
    }
    public void printGraph(){
        for( int i =0;i<vertices;i++){
            System.out.print(i +" is connected to= ");
            LinkedList.Node current=list[i].head;
            while (current != null) {
                System.out.print(current.data+", ");
                current = current.next;
            }
            System.out.println();
        }

    }
    public List<Integer> getadjNodes(int i){
        ArrayList<Integer> adjlist=new ArrayList<>();

        LinkedList.Node current=list[i].head;
        while (current != null) {
            adjlist.add(current.data);
            current = current.next;
        }
        return adjlist;
    }

    public void addEdge (int source, int destination){
        list[source].insert(destination);
        list[destination].insert(source);
    }
}
