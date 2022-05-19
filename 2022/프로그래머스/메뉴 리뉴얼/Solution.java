package nf;

import java.io.*;
import java.util.*;

// 조합 때려서 찾기
class Solution {
    public class Menu implements Comparable<Menu> {
        String name;
        int length;
        int count;
        
        public Menu(String name, int length, int count) {
            this.name = name;
            this.length = length;
            this.count = count;
        }
        
        public int compareTo (Menu o) {
            if (this.length == o.length) {
                if (this.count == o.count) return this.name.compareTo(o.name);
                return o.count - this.count;
            }
            return this.length - o.length;
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        Set<Character> uniqueMenu = new HashSet<>();
        
        int K = orders.length;
        Set[] users = new Set[K];
        for (int i = 0; i < K; i++) users[i] = new HashSet<Character>();
        
        for (int i = 0; i < K; i++) {
            String order = orders[i];
            char[] charArray = order.toCharArray();
            
            for (char c : charArray) {
                users[i].add(c);
                uniqueMenu.add(c);
            }
        }
        
        
        int N = uniqueMenu.size();
        
        char[] menus = new char[N];
        Iterator iter = uniqueMenu.iterator();
        
        
        int idx = 0;
        while (iter.hasNext()) menus[idx++] = (char)iter.next();
        Arrays.sort(menus);
        
        List<Menu> list = new ArrayList<>();
        for (int length : course) {
            int[] array = new int[N];
            
            for (int i = N - 1; i > N - 1 - length; i--) array[i] = 1;
            
            do {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (array[i] == 1) temp.append(menus[i]);
                }
                
                String tempMenu = temp.toString();
                char[] tempMenuCharArray = tempMenu.toCharArray();
                
                int count = 0;
                
                for (int i = 0; i < K; i++) {
                    boolean flag = true;
                    
                    for (char tmc : tempMenuCharArray) {
                        if (users[i].contains(tmc)) continue;
                        else { flag = false; break; }
                    }
                    
                    if (flag) count++;
                }
                
                if (count >= 2)
                    list.add(new Menu(tempMenu, length, count));
                
            } while (nextPermutation(array));
        }
        
        list.sort(null);
        
        int listLength = list.size();
        int len = list.get(0).length;
        int max = list.get(0).count;
        
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            Menu m = list.get(i);
            
            if (m.length == len) {
                if (m.count == max) {
                    answerList.add(m.name);
                }
            } else {
                answerList.add(m.name);
                len = m.length;
                max = m.count;
            }
        }
        
        answerList.sort(null);
        
        return answerList.toArray(new String[0]);
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