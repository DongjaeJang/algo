import java.io.*;
import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        int N = numbers.length;
        long[] answer = new long[N];
        
        int idx = 0;
        for (long number : numbers) {
            if (number % 2 == 0) {
                answer[idx++] = number + 1;
                continue;
            }
            String binary = Long.toString(number, 2);
            int length = binary.length();
            
            int lastIdx = binary.lastIndexOf("0");
            
            StringBuilder sb = new StringBuilder();
            if (lastIdx != -1) sb.append(binary.substring(0, lastIdx)).append("10").append(binary.substring(lastIdx + 2, length));
            else sb.append("10").append(binary.substring(1, length));
            
            answer[idx++] = Long.parseLong(sb.toString(), 2);
        }
        
        return answer;
    }
}