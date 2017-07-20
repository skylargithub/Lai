package mainRun.recursionII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueens {
	
	private List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> nqueens(int n) {
		nqueensHelper(n, 0, new Integer[n]);
		return result;
	}

	public void nqueensHelper(int N, int level, Integer[] A) {

		if (level == N) {
			List<Integer> temp = Arrays.asList(A);
			result.add(temp);
			return;
		}

		for (int i = 0; i < N; i++) {
			A[level] = i;
			if (passCheck(i, level, A)) {
				nqueensHelper(N, level + 1, A);
			}
		}

	}

	private boolean passCheck(int i, int level, Integer[] A) {
		// if i is not found in A, return pass the check
		for (int j = 0; j < level - 1; j++) {
			if (i == A[j]) {
				return false;
			}
		}
		return true;
	}

}
