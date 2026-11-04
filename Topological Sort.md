## 01. Topological Sort

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/topological-sort/1?utm=codolio)

### Problem Description

**Task:** Given a Directed Acyclic Graph (DAG) with V vertices numbered from 0 to V - 1, represented by an adjacency list adj[][], return a topological ordering of its vertices.A topological ordering is a linear ordering of vertices such that for every directed edge u - > v, vertex u appears before vertex v in the ordering.Note: Multiple valid topological orderings may exist. Any valid ordering is accepted. The output is true if the returned ordering is valid; otherwise, it is false.Examples:Input: adj[][] = [[], [0], [0], [0]]Output: trueExplanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0][1, 2, 3, 0][2, 3, 1, 0]Input: adj[][] = [[], [3], [3], [], [1, 0], [0, 2]]Output: true

#### Examples

##### Example 1

- **Explanation:** The output true denotes that the order is valid. Few valid Topological orders for the graph are:[4, 5, 0, 1, 2, 3][5, 2, 4, 0, 1, 3]

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(V + E)
- **Expected Auxiliary Space Complexity:** O(V)

### Accepted Solutions (5)

#### Solution 1 (Java)

- **Submitted:** 2026-11-05 00:04:51
- **Status:** Correct
- **Marks:** 0

```java
import java.util.*;

class Solution {
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
/*topological sort meaning :-- jb aapn ko directed acyclic graph
(DAG) m aese nodes sbse pehle chahiye jinke outgoing edges jaa rhi ho
means unpe incoming edges n ho aese nodes pehle chahiye

so graph ko aapn pehle last tk visite krenge means depth m
jisse uske saaare neighbours cover up ho aur jaise hi neighbours
end ho usko stack m push krennge
bcz yha last in first out jaisa pttern follow ho rha h

Node ko neighbours par jaane se pehle visited mark karna zaroori hai.
Isse agar graph mein cycle ho ya koi neighbour wapas
isi node tak pahunchta ho, toh DFS us node ko dobara
call nahi karega

apprach :--
*/
    // so sbse pehle visited mark k liye array create krenge
    // jisse pta lge is index k neighbour aapn visit kr liye h
    boolean[] visited = new boolean[adj.size()];

    // Initially:
    // visited = [F, F, F, F]

    // we are using stack for retreiving answer at last
    Stack<Integer> st = new Stack<>();

    // Initially:
    // st = []

    ArrayList<Integer> ans = new ArrayList<>();

    // Initially:
    // ans = []

    // TEST CASE:
    // V = 4
    //
    // Graph: 0--> 1 & 2 --> 3
    // 0 -> 1
    // 0 -> 2
    // 1 -> 3
    // 2 -> 3
    //
    // adj.get(0) = [1, 2]
    // adj.get(1) = [3]
    // adj.get(2) = [3]
    // adj.get(3) = []

    // apply dfs to each node
    for(int i = 0; i < adj.size(); i++){

        // i = 0
        // visited[0] = false
        // Isliye dfs(0) call hoga.

        if(!visited[i]) dfs(i, adj, st, visited);

        // DFS(0) complete hone ke baad:
        //
        // visited = [T, T, T, T]
        // Stack bottom -> top = [3, 1, 2, 0]
        //
        // i = 1 -> already visited, DFS nahi chalega
        // i = 2 -> already visited, DFS nahi chalega
        // i = 3 -> already visited, DFS nahi chalega
    }

    // yha tk to saare elements stack m aa jaenge
    // to fhr stack se element nikalenge aur arraylist m add krenge

    // Stack bottom -> top = [3, 1, 2, 0]
    // Stack ka TOP element = 0

    while(!st.isEmpty()){

        // 1st pop: 0
        // ans = [0]
        //
        // 2nd pop: 2
        // ans = [0, 2]
        //
        // 3rd pop: 1
        // ans = [0, 2, 1]
        //
        // 4th pop: 3
        // ans = [0, 2, 1, 3]

        ans.add(st.pop());
    }

    return ans;
    // Final answer = [0, 2, 1, 3]
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    Stack<Integer> st, boolean[] visited){

        // node 0 aaya

        visited[node] = true;

        // DFS(0):
        // node = 0
        // visited = [T, F, F, F]
        // Neighbours = [1, 2]
        //
        // Pehla neighbour = 1
        // visited[1] false hai, so dfs(1) call hoga.

        // DFS(1):
        // node = 1
        // visited = [T, T, F, F]
        // Neighbours = [3]
        //
        // Neighbour = 3
        // visited[3] false hai, so dfs(3) call hoga.

        // DFS(3):
        // node = 3
        // visited = [T, T, F, T]
        // Neighbours = []
        //
        // Koi neighbour nahi hai.
        // Loop nahi chalega.
        // st.push(3)
        // Stack = [3]

        // DFS(3) return hoga, control DFS(1) mein aayega.
        //
        // DFS(1):
        // Neighbour 3 process ho chuka hai.
        // Ab st.push(1)
        // Stack = [3, 1]

        // DFS(1) return hoga, control DFS(0) mein aayega.
        //
        // DFS(0):
        // Ab next neighbour = 2
        // visited[2] false hai, so dfs(2) call hoga.

        // DFS(2):
        // node = 2
        // visited = [T, T, T, T]
        // Neighbours = [3]
        //
        // visited[3] already true hai.
        // Isliye dfs(3) dobara call nahi hoga.
        //
        // Ab st.push(2)
        // Stack = [3, 1, 2]

        // DFS(2) return hoga, control DFS(0) mein aayega.
        //
        // DFS(0):
        // Neighbours 1 aur 2 dono process ho gaye.
        // Ab st.push(0)
        // Stack = [3, 1, 2, 0]

        for(int neighbour: adj.get(node)){

            if(!visited[neighbour]){

                // Tumhare code mein ye line thi:
                // visited[neighbour] = true;
                //
                // Iski zaroorat nahi hai, kyunki dfs()
                // ke start mein hi visited[node] = true hota hai.
                // Isliye extra line hata sakte ho.

                dfs(neighbour, adj, st, visited);
            }
        }

// in short
        // Node ko neighbours visit karne KE BAAD push karte hain.
        // Isi wajah se stack se pop karne par topological order milta hai.

        st.push(node);
    }
}
```
