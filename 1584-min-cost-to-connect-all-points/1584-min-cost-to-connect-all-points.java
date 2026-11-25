import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {

        int v = points.length;
        // Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
        // v = 5

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        // PriorityQueue minimum weight ke according sort hogi
        // Har element ka format {weight, node}

        boolean[] visited = new boolean[v];
        // visited = [false, false, false, false, false]

        pq.offer(new int[]{0, 0});
        // PQ = [{0,0}]
        // Node 0 se start krenge, starting weight 0 hai

        int totalWeight = 0;
        int count = 0;

        while (!pq.isEmpty() && count < v) {

            int[] list = pq.poll();

            int weight = list[0];
            int node = list[1];

            // PQ se minimum weight wala element niklega

            if (visited[node]) {
                continue;
            }
            // Agar node pehle se visited hai to skip krenge

            visited[node] = true;
            totalWeight += weight;
            count++;

            // Node ko visited mark krenge
            // Uska weight totalWeight mein add krenge
            // count batayega kitne points MST mein include hue

            /*
            ITERATION 1:
            PQ se {0,0} nikla
            node = 0, weight = 0

            visited[0] = true
            totalWeight = 0
            count = 1

            Node 0 = [0,0]

            Neighbours check krenge:

            Node 1 = [2,2]
            Cost = |0-2| + |0-2| = 4

            Node 2 = [3,10]
            Cost = |0-3| + |0-10| = 13

            Node 3 = [5,2]
            Cost = |0-5| + |0-2| = 7

            Node 4 = [7,0]
            Cost = |0-7| + |0-0| = 7

            PQ = [{4,1}, {7,3}, {7,4}, {13,2}]
            */

            for (int neighbour = 0; neighbour < v; neighbour++) {

                if (!visited[neighbour]) {

                    int edgeWeight =
                        Math.abs(points[node][0] - points[neighbour][0]) +
                        Math.abs(points[node][1] - points[neighbour][1]);

                    pq.offer(new int[]{edgeWeight, neighbour});
                }
            }

            /*
            ITERATION 2:
            PQ se {4,1} nikla
            node = 1, weight = 4

            visited[1] = true
            totalWeight = 0 + 4 = 4
            count = 2

            Node 1 = [2,2]

            Node 2 = [3,10]
            Cost = |2-3| + |2-10| = 9

            Node 3 = [5,2]
            Cost = |2-5| + |2-2| = 3

            Node 4 = [7,0]
            Cost = |2-7| + |2-0| = 7

            PQ mein pehle se {7,3}, {7,4}, {13,2} bhi hain.
            Ab {3,3} sabse chhota hai.

            ITERATION 3:
            PQ se {3,3} nikla
            node = 3, weight = 3

            visited[3] = true
            totalWeight = 4 + 3 = 7
            count = 3

            Node 3 = [5,2]

            Node 4 = [7,0]
            Cost = |5-7| + |2-0| = 4

            PQ mein {4,4}, {7,4}, {7,3}, {7,4},
            aur doosre purane entries ho sakte hain.

            ITERATION 4:
            PQ se {4,4} nikla
            node = 4, weight = 4

            visited[4] = true
            totalWeight = 7 + 4 = 11
            count = 4

            Node 4 = [7,0]

            Ab sirf Node 2 unvisited hai.

            Node 2 = [3,10]
            Node 4 se cost:
            |7-3| + |0-10| = 14

            Lekin PQ mein Node 2 ke liye pehle se {9,2}
            available hai.

            ITERATION 5:
            PQ se {7,4} ya koi doosri entry aa sakti hai,
            lekin Node 4 already visited hai.
            Isliye visited check use skip kar dega.

            Aakhir mein PQ se {9,2} niklega.

            visited[2] = true
            totalWeight = 11 + 9 = 20
            count = 5

            Saare 5 points visited ho gaye.
            Loop condition count < v false ho jaegi.

            Final totalWeight = 20
            */

        }

        return totalWeight;
        // Output: 20
    }
}

/*
INPUT:
points = [[0,0],[2,2],[3,10],[5,2],[7,0]]

OUTPUT:
20

TIME COMPLEXITY:
O(V^2 log V)

SPACE COMPLEXITY:
O(V^2)

V = points ki total sankhya

Har selected node ke liye hum saare points check karte hain,
aur PriorityQueue mein edges add karte hain.
Isliye worst-case time complexity O(V^2 log V) hai.
*/