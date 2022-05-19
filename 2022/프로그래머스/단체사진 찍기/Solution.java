package nf;

import java.io.*;
import java.util.*;

// 순열만들어서 인덱스 체크
class Solution {
    public class Info {
        char A, B, op;
        int count;
        
        public Info (char A, char B, char op, int count) {
            this.A = A;
            this.B = B;
            this.op = op;
            this.count = count;
        }
    }
    
    public int solution(int n, String[] datas) {
        int answer = 0;
        
        char[] people = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        
        List<Info> orders = new ArrayList<>();
        for (String data : datas) {
            char[] charArray = data.toCharArray();
            char A = charArray[0];
            char B = charArray[2];
            char op = charArray[3];
            
            int count = charArray[4] - '0' + 1;
            
            orders.add(new Info(A, B, op, count));
        }
        
        do {
            List<Character> currentPeople = new ArrayList();
            for (int i = 0; i < 8; i++) {
                currentPeople.add(people[array[i]]);
            }
            
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                Info info = orders.get(i);
                
                int indexA = currentPeople.indexOf(info.A);
                int indexB = currentPeople.indexOf(info.B);
                
                char op = info.op;
                int count = info.count;
                
                int dist = Math.abs(indexB - indexA);
                
                switch (op) {
                    case '=': if(dist != count) flag = false; break;
                    case '>': if(dist <= count) flag = false; break;
                    case '<': if(dist >= count) flag = false; break;
                }
                
                if (!flag) break;
            }
            
            if (flag) answer++;
            
        } while(nextPermutation(array));
        
        return answer;
    }
    
    public boolean nextPermutation(int[] array) {
        int N = array.length;
        
        int i = N - 1;
        while (i > 0 && array[i - 1] >= array[i]) --i;
        if (i == 0) return false;
        
        int j = N - 1;
        while (array[i - 1] >= array[j]) --j;
        
        swap(array, i - 1, j);
        
        int k = N - 1;
        while (i < k) swap(array, i++, k--);
        return true;
    }
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}