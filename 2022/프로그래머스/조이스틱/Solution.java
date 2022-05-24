package nf;

import java.io.*;
import java.util.*;

class Solution {
    public List<Character> alphabets;
    public int N;
    public int answer;
    
    public int solution(String name) {
        alphabets = new ArrayList<>();
        for (int i = 0; i < 26; i++) alphabets.add((char)('A' + i));
        
        answer = Integer.MAX_VALUE;
        
        N = name.length();
        String string = "";
        for (int i = 0; i < N; i++) string += "A";
        
        start(name, string, 0, 0);
        
        return answer;
    }
    
    public void start(String name, String string, int idx, int num) {
        if (name.equals(string)) {
            answer = Math.min(answer, num);
            return;
        }
        // 우측
        int rightIdx = idx;
        int rightNum = 0;
        while (true) {
            if (name.charAt(rightIdx) != string.charAt(rightIdx)) {
                StringBuilder temp = new StringBuilder(string);
                rightNum += upOrDown(name.charAt(rightIdx), string.charAt(rightIdx));
                temp.setCharAt(rightIdx, name.charAt(rightIdx));
                String newString = temp.toString();
                
                start(name, newString, rightIdx, num + rightNum);
                
                break;
            }
            rightIdx++;
            rightNum++;
            rightIdx %= N;
        }
        // 좌측
        int leftIdx = idx;
        int leftNum = 0;
        while (true) {
            if (name.charAt(leftIdx) != string.charAt(leftIdx)) {
                StringBuilder temp = new StringBuilder(string);
                leftNum += upOrDown(name.charAt(leftIdx), string.charAt(leftIdx));
                temp.setCharAt(leftIdx, name.charAt(leftIdx));
                String newString = temp.toString();
                
                start(name, newString, leftIdx, num + leftNum);
        
                break;
            }
            leftIdx--;
            leftNum++;
            if (leftIdx < 0) leftIdx += N;
        }
    }
    
    public int upOrDown(char a, char b) {
        int aIdx = alphabets.indexOf(a);
        int bIdx = alphabets.indexOf(b);
        
        return Math.min(Math.abs(bIdx - aIdx), 26 - Math.abs(bIdx - aIdx));
    }
}