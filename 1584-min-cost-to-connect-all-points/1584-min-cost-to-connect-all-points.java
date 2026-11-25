import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {

        int v = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        boolean[] visited = new boolean[v];

        pq.offer(new int[]{0, 0});

        int totalWeight = 0;
        int count = 0;

        while (!pq.isEmpty() && count < v) {

            int[] list = pq.poll();

            int weight = list[0];
            int node = list[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalWeight += weight;
            count++;

            for (int neighbour = 0; neighbour < v; neighbour++) {

                if (!visited[neighbour]) {

                    int edgeWeight =
                        Math.abs(points[node][0] - points[neighbour][0]) +
                        Math.abs(points[node][1] - points[neighbour][1]);

                    pq.offer(new int[]{edgeWeight, neighbour});
                }
            }
        }

        return totalWeight;
    }
}