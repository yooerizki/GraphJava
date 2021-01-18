import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class App {

    // var
    public int V;
    public LinkedList<Integer> adjacency[];
    public boolean visited[];

    // mendeklarasikan var
    App(int v) {
        V = v;
        adjacency = new LinkedList[v]; // untuk menyimapan vertex
        visited = new boolean[v];

        for (int i = 0; i < v; ++i) // loop
            adjacency[i] = new LinkedList();
    }

    void addEdge(int v, int w) { // tambah penghubung
        adjacency[v].add(w);
    }

    public void DFS(int s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        while (!stack.isEmpty()) {
            stack.pop(); // masukkan data
            // node
            if (visited[s] == false) {
                visited[s] = true;
                System.out.print(s + " ");

            }
            // cek semua node
            Iterator<Integer> i = adjacency[s].listIterator(); //
            while (i.hasNext()) { // loop dan cek kondisi nilai pada interator
                int n = i.next();
                if (!visited[n]) // jika penghubung tidak ada
                    DFS(n);
            }
        }

    }

    public void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;

        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll(); // hapus queue
            System.out.print(s + " ");

            Iterator<Integer> i = adjacency[s].listIterator();
            while (i.hasNext()) { // loop dan cek kondisi nilai pada interator
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        App graph = new App(18); // nilai edge
        // nilai graph
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);
        graph.addEdge(7, 11);
        graph.addEdge(8, 9);
        graph.addEdge(8, 11);
        graph.addEdge(9, 5);
        graph.addEdge(9, 8);
        graph.addEdge(11, 7);
        graph.addEdge(11, 10);

        // di mulai dari node
        System.out.println("Depth First Search : ");
        graph.DFS(1);
        System.out.println("\nBreadth First Search : ");
        graph.BFS(1);
    }
}
