import java.io.*;
import java.util.*;

class Solution {
    public int answer = 0;
    
    public int solution(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        
        for (int i = 0; i < length; i++) {
            check(array, length);
            swap(array, length);
        }
        
        return answer;
    }
    
    public void check(char[] array, int length) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : array) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return;
                else stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') return;
                else stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return;
                else stack.pop();
            }
        }
        
        if (stack.isEmpty()) answer++;
    }
    
    public void swap(char[] array, int length) {
        char temp = array[0];
        for (int i = 1; i < length; i++) array[i - 1] = array[i];
        array[length - 1] = temp;
    }
}