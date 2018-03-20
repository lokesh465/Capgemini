package EXAM.CapGemini;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which Fibonocci element u need");
		int n = sc.nextInt();
		if (n <= 0) {
			System.out.println("-1");
			System.exit(0);
		}
		if (n >= 100) {
			System.out.println("-2");
			System.exit(0);
		}
		int a = 0, b = 0, c = 1;
		// System.out.println("Fibonacci Series for 100 elements:");
		for (int i = 1; i <= n; i++) {
			a = b;
			b = c;
			c = a + b;
			// System.out.println(a+" ");
		}
		System.out.println("value of " + n + " element is: " + a);
	}
}
