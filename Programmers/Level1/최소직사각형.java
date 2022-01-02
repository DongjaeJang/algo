import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int N = sizes.length;
        
        List<Integer> widthList = new ArrayList<>();
        List<Integer> heightList = new ArrayList<>();
        
        for (int[] size : sizes) {
            int a = size[0], b = size[1];
            if (a < b) {
                widthList.add(a);
                heightList.add(b);
            } else {
                widthList.add(b);
                heightList.add(a);
            }
        }
        
        widthList.sort(null);
        heightList.sort(null);
        
        return widthList.get(N - 1) * heightList.get(N - 1);
    }
}