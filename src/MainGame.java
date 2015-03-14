import javax.swing.JOptionPane;

public class MainGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		String lastGuess, lastFeedback; //string for a guess and user feedback
		
		int userChoice;

		do { //Main game loop
			GuessGame game = new GuessGame(); //init a game object
			
			do {
				lastGuess=game.makeGuess(); //make a new guess
				// show the guess
				lastFeedback=JOptionPane.showInputDialog(null, "I guessed "+game.getGuess()+". How did I do?");// as for user feedback
				game.setFeedback(lastFeedback);
			} while (!game.isWon());
			
			userChoice=JOptionPane.showOptionDialog(null, 
					"I got it! and it took me "+game.getNumTries()+" tried to guess it.\n Want to play again?", 
					"GuessGame", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					null, JOptionPane.YES_OPTION);			

		} while (userChoice!=JOptionPane.NO_OPTION); // ask if the user want to keep playing or not.

	}

}
