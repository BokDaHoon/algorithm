package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main10867 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize = Integer.parseInt(br.readLine());
		HashSet<Integer> check = new HashSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arraySize; i++) {
			check.add(Integer.parseInt(st.nextToken()));
		}
		
		Iterator<Integer> iter = check.iterator();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		
		for (int num : result) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
