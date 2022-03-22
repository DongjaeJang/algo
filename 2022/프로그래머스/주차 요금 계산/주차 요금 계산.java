import java.io.*;
import java.util.*;

class Solution {
    class Car implements Comparable<Car> {  // 차 넘버 순 정렬
        String no;
        int time;
        
        public Car(String no) {
            this.no = no;
            this.time = 0;
        }
        
        public int compareTo(Car c) {
            return this.no.compareTo(c.no);
        }
    }
    private Map<String, Integer> recordsMap;    // 입차 정보 담을 Map
    private List<Car> costList; // 차량 요금 정보 담을 List
    
    private final String IN = "IN"; // 입차
    private final String OUT = "OUT";   // 출차
    private int BASE_MINUTE;    // 기본 시간
    private int BASE_COST;  // 기본 요금
    private int UNIT_MINUTE;    // 단위 시간
    private int UNIT_COST;  // 단위 요금
    
    public int[] solution(int[] fees, String[] records) {
        BASE_MINUTE = fees[0];
        BASE_COST = fees[1];
        UNIT_MINUTE = fees[2];
        UNIT_COST = fees[3];
        
        recordsMap = new HashMap<>();
        costList = new ArrayList<>();
        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            
            String[] timeInfo = st.nextToken().split(":");
            String no = st.nextToken();
            String op = st.nextToken();
            
            int hour = Integer.parseInt(timeInfo[0]);
            int minute = Integer.parseInt(timeInfo[1]);
            int time = hour * 60 + minute;
            
            if (op.equals(IN)) {
                recordsMap.put(no, time);   // 입차 시 Map에 입차 시간 정보 추가
            } else {
                int startTime = recordsMap.get(no); // 출차 시 해당 차량 입차 시간 받아오기
                recordsMap.remove(no);  // Map에서 제거
                
                int carIndex = findCarIndex(no);    // List내 인덱스 체크
                if (carIndex == -1) {
                    carIndex = costList.size();
                    costList.add(new Car(no));
                }
                
                int accumulatedTime = time - startTime; // 누적 시간
                costList.get(carIndex).time += accumulatedTime; // 누적 시간 추가
            }
        }
        // 입차만 있고 출차만 안찍힌 경우, 최종시간으로 한번 더 체크
        for (String no : recordsMap.keySet()) {
            int startTime = recordsMap.get(no);
            
            int carIndex = findCarIndex(no);
            if (carIndex == -1) {
                carIndex = costList.size();
                costList.add(new Car(no));
            }
            
            int accumulatedTime = 23 * 60 + 59 - startTime;
            costList.get(carIndex).time += accumulatedTime;
        }
        
        costList.sort(null);    // 차량 번호 순 정렬
        int N = costList.size();
        
        int[] answer = new int[N];
        for (int i = 0; i < costList.size(); i++) { // 순회하며 차량요금계산
            int totalTime = costList.get(i).time - BASE_MINUTE;
            answer[i] = BASE_COST + ((totalTime >= 0) ? ((totalTime % UNIT_MINUTE == 0) ? (totalTime / UNIT_MINUTE) : (totalTime / UNIT_MINUTE) + 1) : 0) * UNIT_COST;
        }
        
        return answer;
    }
    // 리스트 내 차량 정보 등록되어있는지 체크
    private int findCarIndex(String no) {
        int length = costList.size();
        
        for (int i = 0; i < length; i++) {
            if (costList.get(i).no.equals(no)) 
                return i;
        }
        
        return -1;
    }
}