package EXAM.CapGemini;

import java.util.Scanner;

public class PalindromeCheckString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word");
		String name = sc.next();
		char[] warray = name.toCharArray();
		System.out.println(istPalindrom(warray));
	}

	public static boolean istPalindrom(char[] wort) {
		boolean palindrom = false;
		if (wort.length % 2 == 0) {
			for (int i = 0; i < wort.length / 2 - 1; i++) {
				if (wort[i] != wort[wort.length - i - 1]) {
					return false;
				} else {
					palindrom = true;
				}
			}
		} else {
			for (int i = 0; i < (wort.length - 1) / 2 - 1; i++) {
				if (wort[i] != wort[wort.length - i - 1]) {
					return false;
				} else {
					palindrom = true;
				}
			}
		}
		return palindrom;
	}

}
