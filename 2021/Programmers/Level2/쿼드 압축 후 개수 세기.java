package boj_self;

class Programmers_쿼드트리 {
	public int zero, one;

	public int[] solution(int[][] arr) {
		zero = 0;
		one = 0;
		if (isSame(arr, 0, 0, arr.length, arr[0][0]))
			quadTree(arr, 0, 0, arr.length);
		return new int[] { zero, one };
	}

	public void quadTree(int[][] arr, int x, int y, int length) {
		if (length == 1) {
			if (arr[x][y] == 0)
				zero++;
			else
				one++;
			return;
		}

		int tempLength = length / 2;

		if (!isSame(arr, x, y, tempLength, arr[x][y])) 
			quadTree(arr, x, y, tempLength);

		if (!isSame(arr, x, y + tempLength, tempLength, arr[x][y + tempLength])) 
			quadTree(arr, x, y + tempLength, tempLength);

		if (!isSame(arr, x + tempLength, y, tempLength, arr[x + tempLength][y])) 
			quadTree(arr, x + tempLength, y, tempLength);

		if (!isSame(arr, x + tempLength, y + tempLength, tempLength, arr[x + tempLength][y + tempLength])) 
			quadTree(arr, x + tempLength, y + tempLength, tempLength);
	}

	public boolean isSame(int[][] arr, int x, int y, int length, int current) {
		for (int i = x; i < x + length; i++) {
			for (int j = y; j < y + length; j++) {
				if (arr[i][j] != current)
					return false;
			}
		}
		
		if (arr[x][y] == 0) zero++;
		else one++;
		
		return true;
	}

}