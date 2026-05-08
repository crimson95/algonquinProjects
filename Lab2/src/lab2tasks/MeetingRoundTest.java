package lab2tasks;

/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Sandra Iroakazi
 * Lab number: Lab 2
 */

/**
 * Driver that prints the schedule using the exact spacing required.
 * Each column is left-justified in a 10-character field; no tabs are used.
 * @author Jay Chao
 * @version 1.0
 * @since 2025.05.21
 */
public class MeetingRoundTest {

    private static final int COL_WIDTH = 10;         // 10 spaces per column
    
    /** default constructor */
    public MeetingRoundTest() {}
    
    /**
     * main line method that exercises the features of the class MeetingRound
     * @see MeetingRound
     * @param args command line arguments - ignored by this method
     */
    public static void main(String[] args) {

        // PRESS followed by the G7 countries (Canada, France, …, US)
        String[] participants = {
                "PRESS",
                "Canada", "France", "Germany",
                "Italy", "Japan", "UK", "US"
        };

        MeetingRound scheduler = new MeetingRound(participants);
        int roundNo = 1;

        while (!scheduler.isComplete()) {
            String[][] round = scheduler.nextRound();

            // round.length provides #of rows.  round[0].length provides number of columns
         
            System.out.printf("Round %d:%n", roundNo);
            
            for(int i = 0; i < round.length; i++) {
            	for(int j = 0; j < round[0].length; j++) {
            		System.out.printf("%-" + COL_WIDTH + "s", round[i][j]);
            	}
            	System.out.println();
            }
            roundNo++;
            System.out.println();
        //YOUR CODE ENDS HERE    
            
        }//while
    }//main
}//class
