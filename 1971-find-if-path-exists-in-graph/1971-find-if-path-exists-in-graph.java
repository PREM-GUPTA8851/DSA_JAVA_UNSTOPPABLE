import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Adjacency list: har vertex ke neighbours store karenge
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph: dono directions mein edge add hogi
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // BFS ke liye visited array aur queue
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        // Example:
        // n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]]
        // source = 0, destination = 2
        //
        // adj = [[1,2], [0], [0], [5,4], [5,3], [3,4]]
        // visited = [false,false,false,false,false,false]
        // q = []

        visited[source] = true;
        q.offer(source);

        // visited = [true,false,false,false,false,false]
        // q = [0]

        // Jab tak queue empty nahi hoti, BFS chalayenge
        while (!q.isEmpty()) {

            int node = q.poll();

            // First iteration:
            // node = 0, q = []
            // node == destination? 0 == 2 -> false

            if (node == destination) {
                return true;
            }

            // node 0 ke neighbours: [1, 2]
            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);

                    // neighbor = 1:
                    // visited[1] = true, q = [1]
                    //
                    // neighbor = 2:
                    // visited[2] = true, q = [1, 2]
                }
            }

            // Second iteration:
            // node = 1, q = [2]
            // node == destination? false
            // Neighbour 0 already visited -> skip
            //
            // Third iteration:
            // node = 2, q = []
            // node == destination? true
            // return true; destination reachable hai.
        }

        // Agar destination tak nahi pahunche, path exist nahi karta.
        return false;
    }
}