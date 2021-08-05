package swea.d2.d2_1983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] scores = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
		int testNum = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testNum; tc++) {
			String[] info = br.readLine().split(" ");
			
			int stuNum = Integer.parseInt(info[0]);
			int targetStu = Integer.parseInt(info[1]);
			double targetStuJumsu = 0;
			
			List<Double> jumsuList = new ArrayList<>();
			
			for (int i = 0; i < stuNum; i++) {
				String[] jumsuInfo = br.readLine().split(" ");
				double total = Integer.parseInt(jumsuInfo[0]) * 35 / 100. + Integer.parseInt(jumsuInfo[1]) * 45 / 100 + Integer.parseInt(jumsuInfo[2]) * 20 / 100.;
				if (i+1 == targetStu) targetStuJumsu = total;
				jumsuList.add(total);
			}

			jumsuList.sort(null);
			int idx = -1;
			for (int i = 0; i < stuNum; i++) {
				if (targetStuJumsu == jumsuList.get(i)) {
					idx = i;
					break;
				}
			}
			System.out.printf("#%d %s%n", tc, scores[idx / (stuNum / 10)]);
		}
	}
}
