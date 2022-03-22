import java.io.*;
import java.util.*;

class Solution {
    private final String[] languages = {"cpp", "java", "python", "-"};  // 올 수 있는 언어
    private final String[] jobs = {"backend", "frontend", "-"}; // 올 수 있는 직군
    private final String[] careers = {"junior", "senior", "-"}; // 올 수 있는 경력
    private final String[] foods = {"chicken", "pizza", "-"};   // 올 수 있는 음식
    
    private Map<String, List<Integer>> infoMap; // 해시에 따른 리스트 저장
    // 맵 초기화
    private void initMap() {
        this.infoMap = new HashMap<>();
        
        for (int l = 0; l < this.languages.length; l++) {
            for (int j = 0; j < this.jobs.length; j++) {
                for (int c = 0; c < this.careers.length; c++) {
                    for (int f = 0; f < this.foods.length; f++) {
                        StringBuilder str = new StringBuilder();
                        str.append(l).append(j).append(c).append(f);    // index 스트링으로 해시맵 키 생성
                        
                        this.infoMap.put(str.toString(), new ArrayList<Integer>()); // 리스트 초기화 해주기
                    }
                }
            }
        }
    }
    // 맵 만들기
    private void makePeopleInfo(String[] infos) {
        for (String info : infos) {
            StringTokenizer st = new StringTokenizer(info);
            
            String language = st.nextToken();   // 언어
            String job = st.nextToken();    // 직군
            String career = st.nextToken(); // 경력
            String food = st.nextToken();   // 음식
            int score = Integer.parseInt(st.nextToken());   // 점수
            
            int languageIndex = 0;
            for (String l : this.languages) {
                if (language.equals(l)) break;
                else languageIndex++;
            }
            
            int jobIndex = 0;
            for (String j : this.jobs) {
                if (job.equals(j)) break;
                else jobIndex++;
            }
            
            int careerIndex = 0;
            for (String c : this.careers) {
                if (career.equals(c)) break;
                else careerIndex++;
            }
            
            int foodIndex = 0;
            for (String f : this.foods) {
                if (food.equals(f)) break;
                else foodIndex++;
            }
            // 해시맵에 키매핑해서 스코어 추가해주기
            for (int l = 0; l < 2; l++) {
                for (int j = 0; j < 2; j++) {
                    for (int c = 0; c < 2; c++) {
                        for (int f = 0; f < 2; f++) {
                            StringBuilder str = new StringBuilder();
                            str.append(l == 0 ? 3 : languageIndex)
                                .append(j == 0 ? 2 : jobIndex)
                                .append(c == 0 ? 2 : careerIndex)
                                .append(f == 0 ? 2 : foodIndex);

                            this.infoMap.get(str.toString()).add(score);
                        }
                    }
                }
            }
        }
    }
    // binary search를 위한 소팅
    private void sortInfoMap() {
        for (int l = 0; l < this.languages.length; l++) {
            for (int j = 0; j < this.jobs.length; j++) {
                for (int c = 0; c < this.careers.length; c++) {
                    for (int f = 0; f < this.foods.length; f++) {
                        StringBuilder str = new StringBuilder();
                        str.append(l).append(j).append(c).append(f);
                        
                        this.infoMap.get(str.toString()).sort(null);
                    }
                }
            }
        }
    }
    
    public int[] solution(String[] info, String[] queries) {
        this.initMap();
        this.makePeopleInfo(info);
        this.sortInfoMap();
        
        int[] answer = new int[queries.length];
        int queryIndex = 0;
        for (String query : queries) {
            String newQuery = query.replace(" and ", " ");
            StringTokenizer st = new StringTokenizer(newQuery);
            
            String language = st.nextToken();
            String job = st.nextToken();
            String career = st.nextToken();
            String food = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            
            int languageIndex = 0;
            for (String l : this.languages) {
                if (language.equals(l)) break;
                else languageIndex++;
            }
            
            int jobIndex = 0;
            for (String j : this.jobs) {
                if (job.equals(j)) break;
                else jobIndex++;
            }
            
            int careerIndex = 0;
            for (String c : this.careers) {
                if (career.equals(c)) break;
                else careerIndex++;
            }
            
            int foodIndex = 0;
            for (String f : this.foods) {
                if (food.equals(f)) break;
                else foodIndex++;
            }
            
            StringBuilder str = new StringBuilder();
            str.append(languageIndex).append(jobIndex).append(careerIndex).append(foodIndex);
            
            List<Integer> current = this.infoMap.get(str.toString());
            int result = 0;
            int index = Collections.binarySearch(current, score);
            // 음수일 때는 절댓값 취하고 하나 빼줘야 함
            if (index < 0) index = Math.abs(index) - 1;
            // 같은 점수가 여러개 있을 때 lower bound를 찾아야하므로
            while (index > 0) {
                if (current.get(index - 1) == score) index--;
                else break;
            }
            
            answer[queryIndex++] = current.size() - index;
        }
        
        return answer;
    }
}