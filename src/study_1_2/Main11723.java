package study_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main11723 {
	
	private static final int COMMAND = 0;
	private static final int VALUE = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		HashSet<String> hashSet = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		
		String[] input;
		while (testCase-- > 0) {
			input = br.readLine().split(" ");
			
			switch (input[COMMAND]) {
				case "add":
					hashSet.add(input[VALUE]);
					break;
				case "remove":
					hashSet.remove(input[VALUE]);
					break;
				case "check":
					sb.append((hashSet.contains(input[VALUE]) == true) ? "1" : "0").append("\n");
					break;
				case "toggle":
					if ((hashSet.contains(input[VALUE]) == true)) {
						hashSet.remove(input[VALUE]);
					} else {
						hashSet.add(input[VALUE]);						
					}
					break;
				case "all":
					for (int i = 1; i <= 20; i++) {
						hashSet.add(String.valueOf(i));
					}
					break;
				case "empty":
					hashSet.clear();
					break;
			}
		}
		System.out.println(sb.toString());
	}
}
