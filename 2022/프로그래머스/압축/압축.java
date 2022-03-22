import java.io.*;
import java.util.*;

class Solution {
    public Map<String, Integer> dictionary;
    
    public int[] solution(String msg) {
        initDictionary();
        List<Integer> answerList = new ArrayList<>();
        
        int length = msg.length();
        int index = 26;
        
        for (int i = 0; i < length; i++) {
            StringBuilder temp = new StringBuilder(msg.charAt(i));
            temp.append(msg.charAt(i));
            
            while (true) {
                if (i + 1 >= length) break;
                
                StringBuilder temp2 = new StringBuilder();
                temp2.append(temp.toString()).append(msg.charAt(++i));
                
                if (dictionary.get(temp2.toString()) != null) {
                    temp.append(msg.charAt(i));
                } else {
                    --i;
                    dictionary.put(temp2.toString(), ++index);
                    break;
                }
            }
            answerList.add(dictionary.get(temp.toString()));
        }
        int size = answerList.size();
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) answer[i] = answerList.get(i);
        
        return answer;
    }
    
    public void initDictionary() {
        dictionary = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < 26; i++) {
            dictionary.put(alphabet.charAt(i) + "", i + 1);
        }
    }
}