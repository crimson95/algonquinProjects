package lab2tasks;

/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Sandra Iroakazi
 * Lab number: Lab 2
 */

/**
 * Initializes a round-robin scheduler for given participants, each instance of
 * String is the name of a participant. The length of the array should be
 * divisible by 2. If it is not, then prints an error message and terminates the
 * program
 * @author Jay Chao
 * @version 1.0
 * @since 2025.05.21
 */
public class MeetingRound {

	private String[] participants;
	private int currentRound = 0;
	private int totalRound;

	/** default constructor */
	public MeetingRound() {
	}

	/**
	 * constructs a MeetingRound with even-numbered participants
	 * @param participants an array of participants name, its length must be even
	 */
	public MeetingRound(String[] participants) {
		if (participants == null || participants.length % 2 != 0) {
			System.err.printf("Error: The length of the array (%d) should be divisible by 2.%n", participants.length);
			System.exit(1);
		}
		this.participants = participants;
		this.totalRound = participants.length - 1;
	}

	/**
	 * a public method with no parameters that returns a 2D array of String
	 * representing the current round of parings
	 * @return String[][] round
	 */
	public String[][] getCurrentRound() {
		int n = participants.length;
		int half = n / 2;

		String[][] round = new String[2][half];
		for (int i = 0; i < half; i++) {
			round[0][i] = participants[i];
			round[1][i] = participants[i + half];
		}
		return round;
	}

	/**
	 * a public method with no parameters that returns a boolean indicating whether
	 * all rounds have been generated
	 * @return boolean currentRound >= totalRound
	 */
	public boolean isComplete() {
		return currentRound >= totalRound;
	}

	/**
	 * a public method with no parameters that advances the meeting schedule and
	 * return the next round using the same 2D String array format
	 * @return String[][] round
	 */
	public String[][] nextRound() {
		if (isComplete()) return null;

		int n = participants.length;
		int half = n / 2;

		String[][] round = getCurrentRound();

		String overflow = participants[half - 1];
		String underflow = participants[half];

		for (int i = half - 1; i > 1; i--) {
			participants[i] = participants[i - 1];
		}

		for (int i = half; i < n - 1; i++) {
			participants[i] = participants[i + 1];
		}

		participants[n - 1] = overflow;
		participants[1] = underflow;

		currentRound++;
		return round;
	}

	/**
	 * a public method with no parameters that returns an int
	 * giving the total number of rounds that can be produced
	 * @return int totalRound
	 */
	public int totalRound() {
		return totalRound;

	}
}
