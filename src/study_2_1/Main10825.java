package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	String name;
	int korScore;
	int engScore;
	int mathScore;
	
	@Override
	public int compareTo(Student obj) {
		int compareValue = compareValue(this.korScore, obj.korScore, true);
		if (compareValue != 0) {
			return compareValue;
		}
		
		compareValue = compareValue(this.engScore, obj.engScore, false);
		if (compareValue != 0) {
			return compareValue;
		}
		
		compareValue = compareValue(this.mathScore, obj.mathScore, true);
		if (compareValue != 0) {
			return compareValue;
		}
		
		return this.name.compareTo(obj.name);
	}
	
	private int compareValue(int thisValue, int objValue, boolean isDesc) {
		if (thisValue < objValue) {
			return (isDesc) ? 1 : -1;
		} else if (thisValue == objValue) {
			return 0;
		} else {
			return (isDesc) ? -1 : 1;
		}
	}
}

public class Main10825 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int studentCount = Integer.parseInt(br.readLine());
		Student[] students = new Student[studentCount];
		
		for (int i = 0; i < studentCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students[i] = new Student();
			students[i].name = st.nextToken();
			students[i].korScore = Integer.parseInt(st.nextToken());
			students[i].engScore = Integer.parseInt(st.nextToken());
			students[i].mathScore = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(students);
		StringBuilder sb = new StringBuilder();
		for (Student student : students) {
			sb.append(student.name).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
