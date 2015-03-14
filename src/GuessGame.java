import java.util.Random;

public class GuessGame {
	
	private final int NUMBER_LEN=4;
	private String _currentGuess;
	private String _possibleDigits; //string holding the possible digits
	private String _userFeedback;
	private int _numTries;
	private boolean _digitsToGuess[]; //array of digits that we still need to guess
	
	
	public String correctGuessString;
	
	public GuessGame() 
	{
		_possibleDigits="1234567890";
		_currentGuess="";
		_userFeedback="";
		_numTries=0;
		correctGuessString = new String();
		
		_digitsToGuess = new boolean[NUMBER_LEN];
		for (int i=0; i<NUMBER_LEN; i++)
		{
			_digitsToGuess[i]=true;
			correctGuessString+="b";
	
		}
	}
	//makeGuess
	public String makeGuess() 
	{
		String newGuess;
		newGuess = new String();
		
		
		
		return newGuess;
	}
	
	public boolean isWon()
	{
		return _userFeedback.toLowerCase().equals(correctGuessString);
	}
	
	public int getNumTries()
	{
		return _numTries;
	}
	
	public boolean setFeedback(String feedback)
	{
		if (feedback.length()==NUMBER_LEN)
		{
			_userFeedback=feedback;
			return true;
		}
		return false;
	}
	//setFeedback - updates the feedback 
	
	public String getGuess()
	{
		return new String(_currentGuess);
	}
	

}
