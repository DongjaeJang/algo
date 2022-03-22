import java.io.*;
import java.util.*;

class Solution {
    private String overTen = "ABCDEF";
    private StringBuilder allString = new StringBuilder("0");
    
    private void changeNumber(int jinsu, int num) {
        StringBuilder tempString = new StringBuilder();
        
        while (num > 0) {
            int temp = num % jinsu;
            num /= jinsu;
            
            if (temp < 10) tempString.append(temp);
            else tempString.append(this.overTen.charAt(temp - 10));
        }
        
        this.allString.append(tempString.reverse());
    }
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < t * m; i++) {
            this.changeNumber(n, i);
        }
        
        String str = this.allString.toString();
        
        for (int i = 0; i < t; i++) {
            answer.append(str.charAt(p - 1 + m * i));
        }
        
        return answer.toString();
    }
}