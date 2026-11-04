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
    // we are using stack for retreiving answer at last
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> ans = new ArrayList<>();
    
    // 0 --> 1 & 2 --> 3 --> adj --> [1,2], [3], [3], []
    
    // apply dfs to each node
    for(int i = 0; i < adj.size(); i++){
        if(!visited[i]) dfs(i, adj, st, visited);
    }
    
    // yha tk to saare elements stack m aa jaenge
    // to fhr stack se element nikalenge aur arraylist m add krenge 
    while(!st.isEmpty()){
        ans.add(st.pop());
    }
    return ans;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj, Stack<Integer> st,boolean[] visited){
        // node 0 aaya 
        
        visited[node] = true;
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                dfs(neighbour, adj, st, visited);
            }
        }
        st.push(node);
    }
    
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-11-05 00:00:17
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
/*topological sort meaning :-- jb aapn ko directed acyclic graph
(DAG) m aese nodes sbse pehle chahiye jinke outgoing edges jaa rhi ho
means unpe incoming edges n ho aese nodes pehle chahiye 

so graph ko aapn pehle last tk visite krenge means depth m
jisse uske saaare neighbours cover up ho aur jaise hi neighbours 
end ho usko stack m push krennge 
bcz yha last in first out jaisa pttern follow ho rha h
apprach :-- 
*/
    // so sbse pehle visited mark k liye array create krenge
    // jisse pta lge is index k neighbour aapn visit kr liye h 
    boolean[] visited = new boolean[adj.size()];
    // we are using stack for retreiving answer at last
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> ans = new ArrayList<>();
    
    // 0 --> 1 & 2 --> 3 --> adj --> [1,2], [3], [3], []
    
    // apply dfs to each node
    for(int i = 0; i < adj.size(); i++){
        if(!visited[i]) dfs(i, adj, st, visited);
    }
    
    // yha tk to saare elements stack m aa jaenge
    // to fhr stack se element nikalenge aur arraylist m add krenge 
    while(!st.isEmpty()){
        ans.add(st.pop());
    }
    return ans;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj, Stack<Integer> st,boolean[] visited){
        // node 0 aaya 
        
        visited[node] = true;
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                dfs(neighbour, adj, st, visited);
            }
        }
        st.push(node);
    }
    
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-11-04 22:52:25
- **Status:** Correct
- **Marks:** 0

```java
import java.util.*;

class Solution {
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        boolean[] visited = new boolean[V];
        // visited = [F, F, F, F]

        Stack<Integer> st = new Stack<>();
        // Stack bottom -> top

       
        // Edges: 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
        //
        // adj.get(0) = [1, 2]
        // adj.get(1) = [3]
        // adj.get(2) = [3]
        // adj.get(3) = []

        for (int i = 0; i < V; i++) {

            // i = 0
            // visited[0] = false, so DFS(0) call hoga

            // i = 1, 2, 3 baad mein check honge
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }

        // DFS complete hone ke baad:
        // Stack bottom -> top: [3, 1, 2, 0]
        //
        // visited = [T, T, T, T]

        ArrayList<Integer> ans = new ArrayList<>();

        while (!st.isEmpty()) {

            // Pop 0 -> ans = [0]
            // Pop 2 -> ans = [0, 2]
            // Pop 1 -> ans = [0, 2, 1]
            // Pop 3 -> ans = [0, 2, 1, 3]

            ans.add(st.pop());
        }

        return ans; // [0, 2, 1, 3]
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj,
             boolean[] visited, Stack<Integer> st) {

        visited[node] = true;

        // DFS(0):
        // visited[0] = true
        // Neighbours = [1, 2]

        // DFS(1):
        // visited[1] = true
        // Neighbours = [3]

        // DFS(3):
        // visited[3] = true
        // Neighbours = []
        // Koi neighbour nahi, so stack mein 3 push
        // Stack: [3]

        // DFS(1) resumes:
        // Neighbour 3 already visited hai
        // Ab 1 push hoga
        // Stack: [3, 1]

        // DFS(0) resumes:
        // Next neighbour 2 par jayenge

        // DFS(2):
        // visited[2] = true
        // Neighbours = [3]
        // 3 already visited hai
        // Ab 2 push hoga
        // Stack: [3, 1, 2]

        // DFS(0) resumes:
        // Saare neighbours process ho gaye
        // Ab 0 push hoga
        // Stack: [3, 1, 2, 0]

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, st);
            }
        }
// in short
        // Node ko neighbours visit karne KE BAAD push karte hain.
        // Isi wajah se stack se pop karne par topological order milta hai.
        st.push(node);
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-11-03 22:56:27
- **Status:** Correct
- **Marks:** 0

```java
import java.util.*;

class Solution {
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        boolean[] visited = new boolean[V];
        // visited = [F, F, F, F]

        Stack<Integer> st = new Stack<>();
        // Stack bottom -> top

       
        // Edges: 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
        //
        // adj.get(0) = [1, 2]
        // adj.get(1) = [3]
        // adj.get(2) = [3]
        // adj.get(3) = []

        for (int i = 0; i < V; i++) {

            // i = 0
            // visited[0] = false, so DFS(0) call hoga

            // i = 1, 2, 3 baad mein check honge
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }

        // DFS complete hone ke baad:
        // Stack bottom -> top: [3, 1, 2, 0]
        //
        // visited = [T, T, T, T]

        ArrayList<Integer> ans = new ArrayList<>();

        while (!st.isEmpty()) {

            // Pop 0 -> ans = [0]
            // Pop 2 -> ans = [0, 2]
            // Pop 1 -> ans = [0, 2, 1]
            // Pop 3 -> ans = [0, 2, 1, 3]

            ans.add(st.pop());
        }

        return ans; // [0, 2, 1, 3]
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj,
             boolean[] visited, Stack<Integer> st) {

        visited[node] = true;

        // DFS(0):
        // visited[0] = true
        // Neighbours = [1, 2]

        // DFS(1):
        // visited[1] = true
        // Neighbours = [3]

        // DFS(3):
        // visited[3] = true
        // Neighbours = []
        // Koi neighbour nahi, so stack mein 3 push
        // Stack: [3]

        // DFS(1) resumes:
        // Neighbour 3 already visited hai
        // Ab 1 push hoga
        // Stack: [3, 1]

        // DFS(0) resumes:
        // Next neighbour 2 par jayenge

        // DFS(2):
        // visited[2] = true
        // Neighbours = [3]
        // 3 already visited hai
        // Ab 2 push hoga
        // Stack: [3, 1, 2]

        // DFS(0) resumes:
        // Saare neighbours process ho gaye
        // Ab 0 push hoga
        // Stack: [3, 1, 2, 0]

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, st);
            }
        }
// in short
        // Node ko neighbours visit karne KE BAAD push karte hain.
        // Isi wajah se stack se pop karne par topological order milta hai.
        st.push(node);
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-11-03 22:56:10
- **Status:** Correct
- **Marks:** 0

```java
import java.util.*;

class Solution {
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        boolean[] visited = new boolean[V];
        // visited = [F, F, F, F]

        Stack<Integer> st = new Stack<>();
        // Stack bottom -> top

       
        // Edges: 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
        //
        // adj.get(0) = [1, 2]
        // adj.get(1) = [3]
        // adj.get(2) = [3]
        // adj.get(3) = []

        for (int i = 0; i < V; i++) {

            // i = 0
            // visited[0] = false, so DFS(0) call hoga

            // i = 1, 2, 3 baad mein check honge
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }

        // DFS complete hone ke baad:
        // Stack bottom -> top: [3, 1, 2, 0]
        //
        // visited = [T, T, T, T]

        ArrayList<Integer> ans = new ArrayList<>();

        while (!st.isEmpty()) {

            // Pop 0 -> ans = [0]
            // Pop 2 -> ans = [0, 2]
            // Pop 1 -> ans = [0, 2, 1]
            // Pop 3 -> ans = [0, 2, 1, 3]

            ans.add(st.pop());
        }

        return ans; // [0, 2, 1, 3]
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj,
             boolean[] visited, Stack<Integer> st) {

        visited[node] = true;

        // DFS(0):
        // visited[0] = true
        // Neighbours = [1, 2]

        // DFS(1):
        // visited[1] = true
        // Neighbours = [3]

        // DFS(3):
        // visited[3] = true
        // Neighbours = []
        // Koi neighbour nahi, so stack mein 3 push
        // Stack: [3]

        // DFS(1) resumes:
        // Neighbour 3 already visited hai
        // Ab 1 push hoga
        // Stack: [3, 1]

        // DFS(0) resumes:
        // Next neighbour 2 par jayenge

        // DFS(2):
        // visited[2] = true
        // Neighbours = [3]
        // 3 already visited hai
        // Ab 2 push hoga
        // Stack: [3, 1, 2]

        // DFS(0) resumes:
        // Saare neighbours process ho gaye
        // Ab 0 push hoga
        // Stack: [3, 1, 2, 0]

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, st);
            }
        }

        // IMPORTANT:
        // Node ko neighbours visit karne KE BAAD push karte hain.
        // Isi wajah se stack se pop karne par topological order milta hai.
        st.push(node);
    }
}
```

*Generated on: 5/11/2026, 12:05:20 am*