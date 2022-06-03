import java.util.*;

// 부모 노드 표시해서 사이즈 뽑기
class Solution {
    public int[] parents;
    
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        
        for (int i = 0; i < n - 1; i++) {
            int[] computer = computers[i];
            int a = i;
            for (int j = i + 1; j < n; j++) {
                if (computer[j] == 0) continue;
                
                int b = j;
                if (findParent(a) != findParent(b)) {
                    merge(a, b);
                }
            } 
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(parents[i]);
        
        return set.size();
    }
    
    public int findParent(int a) {
        if (parents[a] != a) parents[a] = findParent(parents[a]);
        return parents[a];
    }
    
    public void merge(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == (parentA < parentB ? parentB : parentA)) {
                parents[i] = (parentA < parentB ? parentA : parentB);
            }
        }
    }
}