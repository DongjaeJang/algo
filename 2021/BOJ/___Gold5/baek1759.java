package hwalgo15_서울_07반_장동재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		
		char[] list = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) list[i] = st.nextToken().charAt(0);
		
		int[] checked = new int[C];
		for (int i = 0; i < L; i++) checked[C - i - 1] = 1;
		
		Arrays.sort(list);
		
		do {
			char[] temp = new char[L];
			int index = 0;
			for (int i = 0; i < C; i++) if (checked[i] == 1) temp[index++] = list[i];
			
			if (isOk(temp)) {
				for (int i = L - 1; i >= 0; i--) answer.append(temp[i]);
				answer.append("\n");
			}
		} while (np(checked));
		System.out.println(answer.deleteCharAt(answer.length() - 1).reverse());
	}
	
	private static boolean isOk(char[] arr) {
		int m = 0, j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (isMoum(arr[i])) m++;
			else j++;
		}
		
		return ((m >= 1) && (j >= 2)) ? true : false;
	}
	
	private static boolean isMoum(char c) {
		char[] moum = {'a', 'e', 'i', 'o', 'u'};
		for (int i = 0; i < 5; i++) if (c == moum[i]) return true;
		return false;
	}
	private static boolean np(int[] arr) {
		int N = arr.length;
		
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) --i;
		
		if (i == 0) return false;
		
		int j = N - 1;
		while (arr[i - 1] >= arr[j]) --j;
		
		swap(arr, i - 1, j);
		
		int k = N - 1;
		while (i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
