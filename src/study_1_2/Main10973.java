package study_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10973 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sizeOfArray = Integer.parseInt(br.readLine());
		int[] num = new int[sizeOfArray];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < sizeOfArray; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		if (next_permutation(num)) {
			System.out.println(print(num));
		} else {
			System.out.println(-1);
		}
	}
	
	private static String print(int[] num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			sb.append(num[i]).append(" ");
		}
		return sb.toString();
	}

	private static boolean next_permutation(int[] num) {
		int length = num.length;
		int pivotIndex = 0;
		int sortStartIndex = 0;
		
		for (int i = length - 1; i > 0; i--) {
			if (num[i - 1] > num[i]) {
				pivotIndex = i;
				break;
			}
		}
		
		if (pivotIndex <= 0) {
			return false;
		}
		
		for (int i = length - 1; i >= pivotIndex; i--) {
			if (num[pivotIndex - 1] > num[i]) {
				sortStartIndex = i;
				break;
			}
		}
		
		int temp = num[pivotIndex - 1];
		num[pivotIndex - 1] = num[sortStartIndex];
		num[sortStartIndex] = temp;
		
		sortStartIndex = length - 1;
		
		while (pivotIndex <= sortStartIndex) {
			temp = num[pivotIndex];
			num[pivotIndex] = num[sortStartIndex];
			num[sortStartIndex] = temp;
			
			pivotIndex++;
			sortStartIndex--;
		}
		
		return true;
	}
}
