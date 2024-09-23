/*
We are given two strings P and Q, each consisting of N lowercase English letters. For each position in the strings, we have to choose one letter from either P or Q, in order to construct a new string S, such that the number of distinct letters in S is minimal. Our task is to find the number of distinct letters in the resulting string S.

For example, if P = "ca" and Q = "ab", S can be equal to: "ca", "cb", "aa" or "ab". String "aa" has only one distinct letter ('a'), so the answer is 1 (which is minimal among those strings).

Write a function:

class Solution { public int solution(String P, String Q); }

that, given two strings P and Q, both of length N, returns the minimum number of distinct letters of a string S, that can be constructed from P and Q as described above.

Examples:

1. Given P = "abc", Q = "bcd", your function should return 2. All possible strings S that can be constructed are: "abc", "abd", "acc", "acd", "bbc", "bbd", "bcc", "bcd". The minimum number of distinct letters is 2, which be obtained by constructing the following strings: "acc", "bbc", "bbd", "bcc".

2. Given P = "axxz", Q = "yzwy", your function should return 2. String S must consist of at least two distinct letters in this case. We can construct S = "yxxy", where the number of distinct letters is equal to 2, and this is the only optimal solution.

3. Given P = "bacad", Q = "abada", your function should return 1. We can choose the letter 'a' in each position, so S can be equal to "aaaaa".

4. Given P = "amz", Q = "amz", your function should return 3. The input strings are identical, so the only possible S that can be constructed is "amz", and its number of distinct letters is 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..200,000];
strings P and Q are both of length N;
strings P and Q are made only of lowercase letters (a−z);
strings P and Q contain a total of at most 20 distinct letters.
*/

public class Main {

	public static void main(String[] args) {
		System.out.println(solution2("amz","amz"));
	}

	public static int solution2(String P, String Q)
	{
		boolean[][] mark = new boolean[26][26];
		int n = P.length();

		// Fill mark array based on strings P and Q
		for (int i = 0; i < n; ++i) {
			int p = P.charAt(i) - 'a', q = Q.charAt(i) - 'a';
			mark[p][q] = mark[q][p] = true;
		}

		int temp = 0;

		// Resetting the mark matrix for characters that match themselves
		for (int i = 0; i < 26; ++i) {
			if (mark[i][i]) {
				++temp;
				for (int j = 0; j < 26; ++j) {
					mark[i][j] = mark[j][i] = false;
				}
			}
		}

		int have = 0;

		// Identifying which characters are connected in the mark matrix
		for (int i = 0; i < 26; ++i) {
			for (int j = 0; j < 26; ++j) {
				if (mark[i][j]) {
					have |= 1 << i;
					break;
				}
			}
		}

		int[] ans = new int[]{P.length()};
		dfs(have, 0, 0, mark, temp, ans);
		return ans[0];
	}
	public static void dfs(int have, int now, int state, boolean[][] mark, int num, int[] ans) {
		if (num >= ans[0]) {
			return;
		}
		int mask = 1 << now;
		if (mask > have) {
			ans[0] = num;
			return;
		}
		if ((mask & have) == 0) {
			dfs(have, now + 1, state, mark, num, ans);
		} else {
			int temp = 0, d = 0;
			for (int i = now + 1; i < 26; ++i) {
				if (mark[i][now] && (have & (1 << i)) > 0) {
					temp |= 1 << i;
					++d;
				}
			}
			dfs(have ^ temp, now + 1, state | temp, mark, num + d, ans);
			dfs(have, now + 1, state | mask, mark, num + 1, ans);
		}
	}
	
}
