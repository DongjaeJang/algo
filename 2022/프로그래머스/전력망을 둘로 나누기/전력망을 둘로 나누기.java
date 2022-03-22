import java.io.*;
import java.util.*;

class Solution {
    class Edge {    // 간선 리스트 위한 클래스
        int start, end;
        
        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    boolean[][] graph;  // 전체 그래프
    boolean[] visited;  // 방문 체크
    List<Edge> edges;   // 간선 리스트
    int count;  // 이어진 노드 카운팅
    
    public int solution(int n, int[][] wires) {
        int N = wires.length;   // 간선 갯수
        int answer = Integer.MAX_VALUE; // 정답
        // 초기화
        graph = new boolean[n + 1][n + 1];
        edges = new ArrayList<>();
        // 그래프 갱신, 간선 리스트 저장
        for (int[] wire : wires) {
            int start = wire[0], end = wire[1];
            
            graph[start][end] = true;
            graph[end][start] = true;
            edges.add(new Edge(start, end));
        }
        // 간선 하나씩 없애고, dfs, 다시 잇고
        for (int i = 0; i < N; i++) {
            Edge current = edges.get(i);
            
            graph[current.start][current.end] = false;
            graph[current.end][current.start] = false;
            visited = new boolean[n + 1];
            count = 0;
            
            dfs(n, 1);
            
            answer = Math.min(answer, Math.abs(count - (n - count)));   // 카운팅한 노드 수, 남은 노드 수
            
            graph[current.start][current.end] = true;
            graph[current.end][current.start] = true;
        }
        
        return answer;
    }
    
    public void dfs(int n, int node) {
        if (visited[node]) return;  // 방문한 곳 탈출
        visited[node] = true;   // 방문 체크
        count++;    // 노드 카운팅
        // 그래프 정보 확인하며 이어진 곳 돌기
        for (int i = 1; i <= n; i++) {
            if (!graph[node][i]) continue;
            if (visited[i]) continue;
            dfs(n, i);
        }
    }
}