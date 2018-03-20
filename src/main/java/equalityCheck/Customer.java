package equalityCheck;

class Customer {
	private int customerId;
	private String name;
	private String city;
	private String phone;
	private String email;

	Customer() // Default Constructor
	{
		this.customerId = customerId;
		this.name = name;
		this.city = city;
		this.phone = phone;
		this.email = email;

	}

	// Constructor
	public Customer(int customerId, String name, String city, String phone, String email) {
		/*
		 * customerId = num; name = str; city = str1; phone = str2; email = str3;
		 */
		this.customerId = customerId;
		this.name = name;
		this.city = city;
		this.phone = phone;
		this.email = email;

	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Customer)) {
			return false;
		}
		Customer customer = (Customer) o;
		return customer.customerId == customerId && customer.name == name && customer.city == city && customer.email == email && customer.phone== phone;
	}

}
