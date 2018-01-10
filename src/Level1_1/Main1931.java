package Level1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 그리디 알고리즘
 * 회의실배정 문제
 * https://www.acmicpc.net/problem/1931
 *
 */
class Pair implements Comparable<Pair> {
	int startTime;
	int endTime;
	
	public Pair(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Pair o) {
		
		if (this.endTime < o.endTime) {
			return -1;
		} else if (this.endTime == o.endTime) {
			if (this.startTime < o.startTime) {
				return -1;
			} else if (this.startTime == o.startTime) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return "Pair [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}

public class Main1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		Pair[] list = new Pair[testCase];
		
		String[] input;
		for (int i = 0; i < testCase; i++) {
			input = br.readLine().split(" ");
			list[i] = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		
		Arrays.sort(list);
		
		int now = 0;
		int ans = 0;
		for (int i = 0; i < list.length; i++) {
			if(now <= list[i].startTime){
				System.out.println(list[i].toString());
				now = list[i].endTime;
				ans += 1;
			}
		}
		
		System.out.println(ans);
	}
}
