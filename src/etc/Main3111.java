package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		StringBuilder sentence = new StringBuilder(br.readLine());
		int wordSize = word.length();
		
		int length = sentence.length();
		int searchIndex = -1;
		boolean isFirst = true;
		
		for (int i = 0; i < length; i++) {
			if (isFirst) {
				searchIndex = sentence.indexOf(word); 
			} else {
				searchIndex = sentence.lastIndexOf(word);
			}
			
			if (sentence.indexOf(word) <= -1) {
				break;
			}
			
			for (int j = searchIndex; j < searchIndex + wordSize; j++) {
				sentence.setCharAt(j, ' ');				
			}
			
			isFirst = !isFirst;
		}
		
		System.out.println(sentence.toString().trim());
	}
}
