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
		Random randomGenerator = new Random();
		int digitIndex;

		_currentGuess="";

		for (int pos=0; pos<NUMBER_LEN; pos++)
		{
			if (_digitsToGuess[pos]) // if I should guess this digit  
			{
				digitIndex=randomGenerator.nextInt( _possibleDigits.length() ); //add a random number from the possible digits
				_currentGuess+=_possibleDigits.charAt(digitIndex);
			}
		}
		return new String(_currentGuess);
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
			processFeedback();
			return true;
		}
		return false;
	}
	//setFeedback - updates the feedback 

	private void processFeedback() {

		if (_currentGuess!="")
		{

			for (int pos=0; pos<NUMBER_LEN; pos++) //loop from 0 to NUMBER_LEN
			{
				char currentDigit = _userFeedback.toLowerCase().charAt(pos);
				if (currentDigit=='b')//if the char at pos is B
				{
					_digitsToGuess[pos]=false; //don't check this digit again
					_possibleDigits=_possibleDigits.replace(_currentGuess.charAt(pos)+"", "");// remove digit from list
				} else if (currentDigit=='x')
				{
					_possibleDigits=_possibleDigits.replace(_currentGuess.charAt(pos)+"", "");// remove digit from list
				}
			}


		}

	}


	public String getGuess()
	{
		return new String(_currentGuess);
	}


}
