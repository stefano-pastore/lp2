import java.util.LinkedList;
import java.util.Iterator;

class Question
{
	private String text;
	private LinkedList<Answer> answers;
	private Answer bestAnswer;

	public Question(String text)
	{
		answers = new LinkedList<>();
		this.text = text;
	}

	public void addAnswer(Answer answer)
	{
		this.answers.add(answer);
	}

	public void checkForBestAnswer()
	{
		Iterator<Answer> i = answers.iterator();
		
		while(i.hasNext())
		{
			Answer answer = i.next();

			if (bestAnswer == null)
			{
				bestAnswer = answer;
			}
			else
			{
				if (answer.getVotes() > bestAnswer.getVotes())
				{
					bestAnswer = answer;
				}
			}
		}
	}

	public String getBestAnswer()
	{
		return bestAnswer.getAnswer();
	}
}