package sample.questions;

import java.util.Scanner;

public class PrimeSum {
	public static void main(String[] args) {

		System.out.print("Enter Range:");
		int m, sum = 0, n;
		Scanner get = new Scanner(System.in);
		m = get.nextInt();
		n = get.nextInt();
		System.out.println();
		if (m > n) {
			m = m + n;
			n = m - n;
			m = m - n;
			System.out.println("Swiping numbers: " + m + " " + n);

		}
		for (int i = m; i < n; i++) {
			int flag = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					flag = 1;
				// System.out.println("ex1");
			}
			if (flag == 0) {
				// System.out.print(i+" ");
				sum = sum + i;
			}
		}
		System.out.println("Sum = " + sum);
	}
}