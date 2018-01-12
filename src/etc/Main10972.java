package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10972 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sizeOfNum = Integer.parseInt(br.readLine());
		int[] num = new int[sizeOfNum];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < sizeOfNum; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		
		do {
			System.out.println(Arrays.toString(num));
		} while (next_permutation(num));
	}
	
	public static boolean next_permutation(int[] num) {
		int length = num.length;
		int pivotIndex = 0;
		int sortStartIndex = 0;
		
		for (int i = length - 1; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				pivotIndex = i;
				break;
			}
		}
		
		if (pivotIndex <= 0) {
			return false;
		}
		
		for (int i  = length - 1; i >= pivotIndex; i--) {
			if (num[pivotIndex - 1] < num[i]) {
				sortStartIndex = i;
				break;
			}
		}
		
		int temp = num[pivotIndex - 1];
		num[pivotIndex - 1] = num[sortStartIndex];
		num[sortStartIndex] = temp;
		
		sortStartIndex = length - 1;
		
		while (pivotIndex <= sortStartIndex) {
			int sortTemp = num[pivotIndex];
			num[pivotIndex] = num[sortStartIndex];
			num[sortStartIndex] = sortTemp;
			
			pivotIndex++;
			sortStartIndex--;
		}
		
		return true;
	}
}
