package equalityCheck;

public class CustomerTest {
	public static void main(String[] args) {
		Customer c1 = new Customer(1, "vinod", "banglore", null, null);
		Customer c2 = new Customer(1, "vinod", "banglore", null, null);
		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c1));
		c1.setEmail("vinod@gmail.com");
		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c1));
		c2.setEmail("vinod@gmail.com");
		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c1));
	}
}
// 1,"vinod","banglore", null, null