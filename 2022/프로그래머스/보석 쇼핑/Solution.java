package nf;

import java.io.*;
import java.util.*;

// 투 포인터 사용
class Solution {
    public int[] solution(String[] gems) {
        Set<String> uniqueGems = new HashSet<>();
        for (String gem : gems) uniqueGems.add(gem);
        
        int N = gems.length;
        int K = uniqueGems.size();
        
        int dist = Integer.MAX_VALUE;
        int left = 0, right = 0;
        
        int start = 0, end = 0;
        
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            if (map.size() == K) {
                map.put(gems[left], map.get(gems[left]) - 1);
                
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                
                left++;
            } else if (right == N) {
                break;
            } else {
                if (!map.containsKey(gems[right])) map.put(gems[right], 0);
                map.put(gems[right], map.get(gems[right]) + 1);
                right++;
            } 
            
            if (map.size() == K && dist > right - left) {
                dist = right - left;
                start = left + 1;
                end = right;
            }
        }
        
        return new int[]{start, end};
    }
}