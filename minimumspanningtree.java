import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;




public class minimumspanningtree {




    private int vertices;

    private int[][] matrix;




    public minimumspanningtree(int vertices, int[][] matrix) {

        this.vertices = vertices;

        this.matrix = matrix;

    }




    // minimumspanningtree's algorithm implementation

    public int minimumspanningtree(int source, int destination) {

        int dist[] = new int[vertices];

        boolean visited[] = new boolean[vertices];

        int prevpath[] = new int[vertices];




        for (int i = 0; i < vertices; i++) {

            dist[i] = Integer.MAX_VALUE;

            prevpath[i] = -1;

        }

        dist[source] = 0;




        for (int i = 0; i < vertices - 1; i++) {

            int minVertex = findMinimumVertex(dist, visited);

            visited[minVertex] = true;




            for (int v = 0; v < vertices; v++) {

                if (!visited[v] && matrix[minVertex][v] != 0 && dist[minVertex] != Integer.MAX_VALUE &&

                        dist[minVertex] + matrix[minVertex][v] < dist[v]) {

                    dist[v] = dist[minVertex] + matrix[minVertex][v];

                    prevpath[v] = minVertex;

                }

            }

        }




        // Printing the shortest path from source to destination

        if (prevpath[destination] == -1) {

            System.out.println("There is no path from " + source + " to " + destination);

            return -1; // Return a negative value or throw an exception to indicate no path

        } else {

            System.out.println("Shortest path from " + source + " to " + destination + ":");

            printPath(prevpath, destination);

        }




        return dist[destination];

    }




    // Finding the vertex with minimum distance value

    private int findMinimumVertex(int[] dist, boolean[] visited) {

        int minVertex = -1;

        int minDistance = Integer.MAX_VALUE;




        for (int v = 0; v < vertices; v++) {

            if (!visited[v] && dist[v] < minDistance) {

                minVertex = v;

                minDistance = dist[v];

            }

        }

        return minVertex;

    }




    // Get adjacent nodes for a given vertex (dummy implementation, replace with

    // your own graph representation)

    private List<Integer> getAdjNodes(int vertex) {

        // Replace this with your own graph representation and logic to get the adjacent

        // nodes of a vertex

        List<Integer> adjNodes = new ArrayList<>();

        return adjNodes;

    }




    // Printing the shortest path

    private void printPath(int[] prevpath, int destination) {

        if (prevpath[destination] == -1) {

            System.out.print(destination);

            return;

        }

        printPath(prevpath, prevpath[destination]);

        System.out.print(" -> " + destination);

    }




    public static void main(String[] args) {

        int vertices = 6;

        int[][] matrix = {

                { 0, 4, 0, 0, 0, 0 },

                { 4, 0, 8, 0, 0, 0 },

                { 0, 8, 0, 7, 0, 4 },

                { 0, 0, 7, 0, 9, 14 },

                { 0, 0, 0, 9, 0, 10 },

                { 0, 0, 4, 14, 10, 0 }

        };

        minimumspanningtree minimumspanningtree = new minimumspanningtree(vertices, matrix);




        int source = 0;

        int destination = 5;




        int shortestDistance = minimumspanningtree.minimumspanningtree(source, destination);

        if (shortestDistance != -1) {

            System.out.println("\nShortest distance from " + source + " to " + destination + ": " + shortestDistance);

        }

    }

}




//wap to find the shortest5 path of a graph having no weight or constant weight