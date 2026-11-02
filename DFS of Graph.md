## 01. DFS of Graph

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1)

### Problem Description

**Task:** Given a connected undirected graph containing V vertices represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search (DFS) traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency list, and return a list containing the DFS traversal of the graph.Note: Do traverse in the same order as they are in the given adjacency list.Examples:Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]Output: [0, 2, 4, 3, 1]Explanation: Starting from 0, the DFS traversal proceeds as follows:Visit 0 → Output: 0 Visit 2 (the first neighbor of 0) → Output: 0, 2 Visit 4 (the first neighbor of 2) → Output: 0, 2, 4 Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3 Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

#### Examples

##### Example 1

- **Output:**
```text
[0, 1, 2, 3, 4]
```
- **Explanation:** Starting from 0, the DFS traversal proceeds as follows: Visit 0 → Output: 0 Visit 1 (the first neighbor of 0) → Output: 0, 1 Visit 2 (the first neighbor of 1) → Output: 0, 1, 2 Visit 3 (the first neighbor of 2) → Output: 0, 1, 2, 3 Backtrack to 2 and visit 4 → Final Output: 0, 1, 2, 3, 4

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(V + E)
- **Expected Auxiliary Space Complexity:** O(V + E)

### Accepted Solutions (2)

#### Solution 1 (Java)

- **Submitted:** 2026-11-02 21:30:47
- **Status:** Correct
- **Marks:** 0

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Nodes 0 se V-1 tak hain, isliye boolean[] efficient hai.
        boolean[] visited = new boolean[adj.size()];

        // DFS always starts from node 0.
        dfsHelper(0, adj, visited, ans);

        return ans;
    }

    static void dfsHelper(
        int node,
        ArrayList<ArrayList<Integer>> adj,
        boolean[] visited,
        ArrayList<Integer> ans
    ) {

        // Current node ko visited mark karo.
        visited[node] = true;

        // Traversal result mein current node add karo.
        ans.add(node);

        /*
         EXAMPLE:
         adj = [[2, 3, 1], [0], [0, 4], [0], [2]]

         Initially:
         node = 0
         visited = [false, false, false, false, false]
         ans = []

         visited[0] = true
         ans = [0]

         Neighbours of 0 = [2, 3, 1]
        */

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                /*
                 Agar neighbour visit nahi hua:
                 toh us neighbour ke liye DFS call karo.

                 Example:
                 node = 0
                 neighbor = 2

                 dfsHelper(2, adj, visited, ans)
                */

                dfsHelper(neighbor, adj, visited, ans);
            }
        }

        /*
         DRY RUN:

         CALL 1: node = 0
         visited = [true, false, false, false, false]
         ans = [0]

         Neighbour 2 unvisited -> DFS(2)

         CALL 2: node = 2
         visited = [true, false, true, false, false]
         ans = [0, 2]

         Neighbours of 2 = [0, 4]

         0 already visited -> skip
         4 unvisited -> DFS(4)

         CALL 3: node = 4
         visited = [true, false, true, false, true]
         ans = [0, 2, 4]

         Neighbour of 4 = [2]
         2 already visited -> skip

         DFS(4) finishes.
         Backtrack to node 2.

         Node 2 ke neighbours complete.
         DFS(2) finishes.
         Backtrack to node 0.

         Ab node 0 ka next neighbour = 3

         CALL 4: node = 3
         visited = [true, false, true, true, true]
         ans = [0, 2, 4, 3]

         Neighbour of 3 = [0]
         0 already visited -> skip

         DFS(3) finishes.
         Backtrack to node 0.

         Ab node 0 ka next neighbour = 1

         CALL 5: node = 1
         visited = [true, true, true, true, true]
         ans = [0, 2, 4, 3, 1]

         Neighbour of 1 = [0]
         0 already visited -> skip

         DFS(1) finishes.

         Node 0 ke saare neighbours complete.
         DFS traversal complete.
        */
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-11-02 21:30:41
- **Status:** Correct
- **Marks:** 2

```java
import java.util.*;

class Solution {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Nodes 0 se V-1 tak hain, isliye boolean[] efficient hai.
        boolean[] visited = new boolean[adj.size()];

        // DFS always starts from node 0.
        dfsHelper(0, adj, visited, ans);

        return ans;
    }

    static void dfsHelper(
        int node,
        ArrayList<ArrayList<Integer>> adj,
        boolean[] visited,
        ArrayList<Integer> ans
    ) {

        // Current node ko visited mark karo.
        visited[node] = true;

        // Traversal result mein current node add karo.
        ans.add(node);

        /*
         EXAMPLE:
         adj = [[2, 3, 1], [0], [0, 4], [0], [2]]

         Initially:
         node = 0
         visited = [false, false, false, false, false]
         ans = []

         visited[0] = true
         ans = [0]

         Neighbours of 0 = [2, 3, 1]
        */

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                /*
                 Agar neighbour visit nahi hua:
                 toh us neighbour ke liye DFS call karo.

                 Example:
                 node = 0
                 neighbor = 2

                 dfsHelper(2, adj, visited, ans)
                */

                dfsHelper(neighbor, adj, visited, ans);
            }
        }

        /*
         DRY RUN:

         CALL 1: node = 0
         visited = [true, false, false, false, false]
         ans = [0]

         Neighbour 2 unvisited -> DFS(2)

         CALL 2: node = 2
         visited = [true, false, true, false, false]
         ans = [0, 2]

         Neighbours of 2 = [0, 4]

         0 already visited -> skip
         4 unvisited -> DFS(4)

         CALL 3: node = 4
         visited = [true, false, true, false, true]
         ans = [0, 2, 4]

         Neighbour of 4 = [2]
         2 already visited -> skip

         DFS(4) finishes.
         Backtrack to node 2.

         Node 2 ke neighbours complete.
         DFS(2) finishes.
         Backtrack to node 0.

         Ab node 0 ka next neighbour = 3

         CALL 4: node = 3
         visited = [true, false, true, true, true]
         ans = [0, 2, 4, 3]

         Neighbour of 3 = [0]
         0 already visited -> skip

         DFS(3) finishes.
         Backtrack to node 0.

         Ab node 0 ka next neighbour = 1

         CALL 5: node = 1
         visited = [true, true, true, true, true]
         ans = [0, 2, 4, 3, 1]

         Neighbour of 1 = [0]
         0 already visited -> skip

         DFS(1) finishes.

         Node 0 ke saare neighbours complete.
         DFS traversal complete.
        */
    }
}
```

*Generated on: 2/11/2026, 9:31:13 pm*