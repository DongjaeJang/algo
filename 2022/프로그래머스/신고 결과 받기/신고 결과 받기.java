import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        
        Map<String, Set<String>> users = new HashMap<>();   // 신고 목록
        Map<String, Integer> userIndexs = new HashMap<>();  // 유저 인덱스
        
        int index = 0;
        for (String id : id_list) {
            users.put(id, new HashSet<>());
            userIndexs.put(id, index++);
        }
        
        for (String report : reports) {
            StringTokenizer st = new StringTokenizer(report);
            
            String from = st.nextToken();   // 신고자
            String to = st.nextToken(); // 피신고자
            
            if (users.get(to).contains(from)) continue; // 이미 신고했으면 무시
            else users.get(to).add(from);   // 아니면 추가
        }
        
        for (int i = 0; i < n; i++) {
            String id = id_list[i];
            Set<String> strSet = users.get(id);
            
            if (strSet.size() >= k) {   // 정지 된 애들만 체크
                for (String cur : strSet) {
                    int idx = userIndexs.get(cur);
                    answer[idx]++;
                }
            } else continue;
        }
        
        return answer;
    }
}