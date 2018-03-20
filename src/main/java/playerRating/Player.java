package playerRating;

public class Player {
	private String firstName;
	private String lastName;
	private String Name;

	public String getName() {
		return firstName + " " + lastName;
	}

	Player(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

class CricketPlayer {
	private String firstName;
	private String lastName;
	double averageRuns;

	CricketPlayer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}