import java.util.*;
class Node {
    int val = 0;
    int dist = 20001;
    public LinkedList<Node> edges = new LinkedList<>();
    public Node(int val) { this.val = val; }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        LinkedList<Integer> stack = new LinkedList<>();

        // 1. 그래프 생성
        Node[] graph = new Node[n+1];
        for(int i = 0; i<graph.length; i++)
            graph[i] = new Node(i);
        graph[0].dist = graph[1].dist = 0;
        
        for(int[] e : edge){
            graph[e[0]].edges.add(graph[e[1]]);
            graph[e[1]].edges.add(graph[e[0]]);
        }
        
        // 2. 각 노드와의 최단거리 계산
        stack.add(1);
        while(stack.size() > 0){
            Node cur = graph[stack.removeLast()];
            for(Node edgeNode : cur.edges){
                if (edgeNode.dist > (cur.dist+1)){
                    edgeNode.dist = (cur.dist+1);
                    stack.add(edgeNode.val);
                }
            }
        }
        
        // 3. 가장 멀리 떨어진 노드 개수
        Arrays.sort(graph, (a,b) -> b.dist - a.dist);
        int max = graph[0].dist;
        for(Node node : graph){
            if(node.dist == max){
                ++answer;
            }
        }
        
        return answer;
    }
}
