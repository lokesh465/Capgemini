package EXAM.CapGemini;

import java.util.Scanner;

public class VoteEligilbility {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age");
		int age = sc.nextInt();
		System.out.println("Enter your Nationality");
		String name = sc.next();
		String nationality = "indian";
		if (age > 17 && name.equalsIgnoreCase(nationality)){
			System.out.println("Eligible");
		} else {
			System.out.println("Not Eligible");
		}
	}
}
