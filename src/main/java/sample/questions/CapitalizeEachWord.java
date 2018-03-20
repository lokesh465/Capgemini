package sample.questions;

import java.util.Scanner;

public class CapitalizeEachWord {
	public static String toTitleCase(String givenString) {
		String[] arr = givenString.split(" ");
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {
			sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		String sentence;
		Scanner scan = new Scanner(System.in);
		System.out.println("Testing Scanner, write something: ");
		sentence = scan.nextLine();
		// System.out.println(testi);
		System.out.println("String that needs to be converted to Capitalize each word:");
		System.out.println(toTitleCase(sentence));
	}
}
