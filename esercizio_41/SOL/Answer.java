class Answer
{
	private String text;
	
	// Una volta data una risposta ad una domanda, non può essere
	// cambiata la domanda alla quale si è data risposta.
	private final Question question;
	private int votes;

	public Answer(Question q, String text)
	{
		this.question = q;
		this.text = text;
		this.votes = 0;
		this.question.addAnswer(this);
	}

	public void voteUp()
	{
		this.votes += 1;
		question.checkForBestAnswer();
	}

	public String getAnswer()
	{
		return this.text;
	}

	public int getVotes()
	{
		return this.votes;
	}
}