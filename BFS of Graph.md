## 01. BFS of Graph

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1)

### Problem Description

**Task:** Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i.Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.Note: Do traverse in the same order as they are in the given adjacency list.Examples:Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]Output: [0, 2, 3, 1, 4]Explanation: Starting from 0, the BFS traversal will follow these steps: Visit 0 → Output: 0 Visit 2 (first neighbor of 0) → Output: 0, 2 Visit 3 (next neighbor of 0) → Output: 0, 2, 3 Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 1Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]Output: [0, 1, 2, 3, 4]Explanation: Starting from 0, the BFS traversal proceeds as follows: Visit 0 → Output: 0 Visit 1 (the first neighbor of 0) → Output: 0, 1 Visit 2 (the next neighbor of 0) → Output: 0, 1, 2 Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3 Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(V + E)
- **Expected Auxiliary Space Complexity:** O(V + E)

### Accepted Solutions (4)

#### Solution 1 (Java)

- **Submitted:** 2026-11-22 16:52:43
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // for BFS --> [[2,3,1], [0], [0, 4], [0], [2]]
        // indexing --> 0,       1,    2,     3,    4
        // bfs --->     0-->(2 -->4),3,1
        /*
        0
    2   3   1
    4
        */
        // structure --> level wise traverse 
        // 0 2 3 1 4
        // here first node 0 add up then it's neighbours then 
        // we retrieve from first node itsel
        // that means first in first out jaisa structure
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        // ek array lenge jisme hum visited store kr rhe honge 
        boolean[] visited = new boolean[adj.size()]; 
        // visited = [false, false, false, false, false]
        q.offer(0);
        visited[0] = true;
        
        // iska means queue m element aa gye 
        while(!q.isEmpty()){
            int node = q.poll();
            // humne sbse pehle element nikal liya ab 
            ans.add(node); // 0, 2 , 3, 1, 4
            for(int neighbour : adj.get(node)){
                // 2, 3, 1
                if(!visited[neighbour]){
                    // means vo neighbour mark nhi h 
                    visited[neighbour] = true;
                    q.add(neighbour); // 3,1,4
                }
            }
        }
        return ans;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-11-01 23:15:57
- **Status:** Correct
- **Marks:** 0

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        // Example:
        // adj = [[2, 3, 1], [0], [0, 4], [0], [2]]
        // Start node = 0
        //
        // Initially:
        // ans = []
        // visited= [false, false, false, false, false]
        // q = []

        visited[0] = true;
        q.offer(0);

        // visited = [true, false, false, false, false]
        // q = [0]

        while (!q.isEmpty()) {

            int node = q.poll();

            // Iteration 1:
            // node = 0
            // q = []
            // ans = [0]

            ans.add(node);

            // adj.get(0) = [2, 3, 1]
            // Neighbors ko given order mein visit karna hai.

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);

                    // neighbor = 2:
                    // visited[2] = true
                    // q = [2]
                    //
                    // neighbor = 3:
                    // visited[3] = true
                    // q = [2, 3]
                    //
                    // neighbor = 1:
                    // visited[1] = true
                    // q = [2, 3, 1]
                }
            }

            // Iteration 2:
            // node = 2
            // q = [3, 1]
            // ans = [0, 2]
            //
            // adj.get(2) = [0, 4]
            // 0 already visited -> skip
            // 4 not visited -> mark visited, add to queue
            // q = [3, 1, 4]

            // Iteration 3:
            // node = 3
            // q = [1, 4]
            // ans = [0, 2, 3]
            //
            // adj.get(3) = [0]
            // 0 already visited -> skip
            // q = [1, 4]

            // Iteration 4:
            // node = 1
            // q = [4]
            // ans = [0, 2, 3, 1]
            //
            // adj.get(1) = [0]
            // 0 already visited -> skip
            // q = [4]

            // Iteration 5:
            // node = 4
            // q = []
            // ans = [0, 2, 3, 1, 4]
            //
            // adj.get(4) = [2]
            // 2 already visited -> skip
            // q = []

            // Queue empty -> while loop terminates.
        }

        return ans; // [0, 2, 3, 1, 4]
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-11-01 23:00:00
- **Status:** Correct
- **Marks:** 0

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        // Example:
        // adj = [[2, 3, 1], [0], [0, 4], [0], [2]]
        // Start node = 0
        //
        // Initially:
        // ans = []
        // visited = []
        // q = []

        visited.add(0);
        q.offer(0);

        // visited = [0]
        // q = [0]

        while (!q.isEmpty()) {

            int node = q.poll();
            ans.add(node);

            // Iteration 1:
            // node = 0
            // ans = [0]
            // Neighbours = [2, 3, 1]

            for (int neighbor : adj.get(node)) {

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.offer(neighbor);
                }
            }

            // After node 0:
            // visited = [0, 2, 3, 1]
            // q = [2, 3, 1]
            //
            // Iteration 2: node = 2
            // ans = [0, 2]
            // Neighbour 0 already visited; add 4.
            // q = [3, 1, 4]
            //
            // Iteration 3: node = 3
            // ans = [0, 2, 3]
            // Neighbour 0 already visited.
            // q = [1, 4]
            //
            // Iteration 4: node = 1
            // ans = [0, 2, 3, 1]
            // Neighbour 0 already visited.
            // q = [4]
            //
            // Iteration 5: node = 4
            // ans = [0, 2, 3, 1, 4]
            // Neighbour 2 already visited.
            // q = []
            //
            // Queue empty -> loop terminates.
        }

        return ans; // [0, 2, 3, 1, 4]
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-11-01 19:48:33
- **Status:** Correct
- **Marks:** 2

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        // Example:
        // adj = [[2, 3, 1], [0], [0, 4], [0], [2]]
        // Start node = 0
        //
        // Initially:
        // ans = []
        // visited = [false, false, false, false, false]
        // q = []

        visited[0] = true;
        q.offer(0);

        // visited = [true, false, false, false, false]
        // q = [0]

        while (!q.isEmpty()) {

            int node = q.poll();

            // Iteration 1:
            // node = 0
            // q = []
            // ans = [0]

            ans.add(node);

            // adj.get(0) = [2, 3, 1]
            // Neighbors ko given order mein visit karna hai.

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);

                    // neighbor = 2:
                    // visited[2] = true
                    // q = [2]
                    //
                    // neighbor = 3:
                    // visited[3] = true
                    // q = [2, 3]
                    //
                    // neighbor = 1:
                    // visited[1] = true
                    // q = [2, 3, 1]
                }
            }

            // Iteration 2:
            // node = 2
            // q = [3, 1]
            // ans = [0, 2]
            //
            // adj.get(2) = [0, 4]
            // 0 already visited -> skip
            // 4 not visited -> mark visited, add to queue
            // q = [3, 1, 4]

            // Iteration 3:
            // node = 3
            // q = [1, 4]
            // ans = [0, 2, 3]
            //
            // adj.get(3) = [0]
            // 0 already visited -> skip
            // q = [1, 4]

            // Iteration 4:
            // node = 1
            // q = [4]
            // ans = [0, 2, 3, 1]
            //
            // adj.get(1) = [0]
            // 0 already visited -> skip
            // q = [4]

            // Iteration 5:
            // node = 4
            // q = []
            // ans = [0, 2, 3, 1, 4]
            //
            // adj.get(4) = [2]
            // 2 already visited -> skip
            // q = []

            // Queue empty -> while loop terminates.
        }

        return ans; // [0, 2, 3, 1, 4]
    }
}
```

*Generated on: 22/11/2026, 5:01:30 pm*