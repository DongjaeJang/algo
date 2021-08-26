package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Temp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		int[] frequency = new int[8001];
		int sum = 0;
		int max = -4001;
		int min = 4001;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sum += num;	// 1. 산술 평균위해
			numbers[i] = num;	// 2. 중앙값을 위해
			frequency[num + 4000]++;	// 3. 최빈도 값을 위해
			if (min > num) min = num;	// 4. 최대최소 범위를 위해
			if (max < num) max = num;
		}
		
		Arrays.sort(numbers);
		
		int freqmax = -1;
		int count = 0;
		int freqidx = -1;
		
		// 최빈도 체크
		for (int i = 0; i < 8001; i++) {
			if (frequency[i] > freqmax) {
				freqidx = i;
				freqmax = frequency[i];
				count = 1;
			} else if (frequency[i] == freqmax) count++;
		}

		System.out.println(Math.round(sum / (double)N));
		System.out.println(numbers[N / 2]);
		if (count == 1) 
			System.out.println(freqidx - 4000);
		else {
			int tempCount = 0;
			for (int i = 0; i < 8001; i++) {
				if (frequency[i] == freqmax) {
					tempCount++;
					if (tempCount == 2) {
						System.out.println(i - 4000);
						break;
					}
				}
			}
		}
		System.out.println(max - min);
	}
}
