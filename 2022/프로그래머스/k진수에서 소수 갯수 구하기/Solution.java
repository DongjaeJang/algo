import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] list = change(n, k).split("0");
        
        for (String s : list) {
            if (s.equals("")) continue;
            if (check(Long.parseLong(s))) answer++;
        }
        
        return answer;
    }
    
    public boolean check(Long n) {
        if (n == 1) return false;
        
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public String change(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
}