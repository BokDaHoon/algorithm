package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main2309 {

	public static final int countOfDwarf = 9;
	public static ArrayList<Integer> answer = new ArrayList<Integer>();
	public static boolean isFlag = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[countOfDwarf];
		boolean[] check = new boolean[countOfDwarf];
		
		for (int i = 0; i < countOfDwarf; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		solve(0, 0, 0, dwarf, check);
	}

	private static void solve(int index, int count, int sum, int[] dwarf, boolean[] check) {
		if (isFlag) {
			return;
		}
		
		if (index == countOfDwarf) {
			if (count == 7 && sum == 100) {
				print(dwarf, check);
			}
			return;
		}
		
		check[index] = true;
		solve(index + 1, count + 1, sum + dwarf[index], dwarf, check);
		check[index] = false;
		solve(index + 1, count, sum, dwarf, check);
	}
	
	private static void print(int[] dwarf, boolean[] check) {
		for (int i = 0; i < countOfDwarf; i++) {
			if (check[i]) {
				answer.add(dwarf[i]);
			}
		}
		
		Collections.sort(answer);
		
		for (int num : answer) {
			System.out.println(num);
		}
		
		isFlag = true;
	}
}
