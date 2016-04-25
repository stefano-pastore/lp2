import java.lang.StringBuffer;

/*
	Di seguito alcuni punti critici dell'esercizio.
*/

// La classe fa l'overriding del metodo compareTo, quindi
// deve segnalare che ne implementa l'interfaccia.
class Time implements Comparable
{
	private int hours;
	private int minutes;
	private int seconds;

	// Dal momento che si usano delle costanti enumerate
	// ma contenute all'interno della classe Time stessa,
	// si costruisce una variabile pubblica, final e statica
	// in alternativa al classico costrutto enum.
	public static final Time MIDDAY = new Time(12,0,0);
	public static final Time MIDNIGHT = new Time(0,0,0);

	public Time(int hours, int minutes, int seconds)
	{
		if (isValid(hours, minutes, seconds))
		{
			this.hours = hours;
			this.minutes = minutes;
			this.seconds = seconds;
		}
		else
		{
			throw new RuntimeException();
		}
	}

	public int getHours() { return hours; }
	public int getMinutes() { return minutes; }
	public int getSeconds() { return seconds; }

	protected boolean isValid(int hours, int minutes, int seconds)
	{
		if ((hours <= 23) && (hours >= 0) &&
			(minutes <= 59) && (minutes >= 0) &&
			(seconds <= 59) && (seconds >= 0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int compareTo(Object x)
	{
		Time t = (Time) x;
		int this_seconds = this.convert_to_seconds();
		int t_seconds = t.convert_to_seconds();
		
		if (this_seconds > t_seconds)
		{
			return 1;
		}
		else if (this_seconds == t_seconds)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}

	public Time minus(Time x)
	{
		int comparison = this.compareTo(x);
		int this_time = this.convert_to_seconds();
		int x_time = x.convert_to_seconds();
		int t = 0;
		int h = 0;
		int m = 0;
		int s = 0;

		if (comparison == 1)
		{
			t = this_time - x_time;
		}
		else if (comparison == -1)
		{
			t = x_time - this_time;
		}

		h = t / 3600;
		m = (t - h * 3600) / 60;
		s = t - (h * 3600 + m * 60);
		return new Time(h,m,s);
	}

	protected int convert_to_seconds()
	{
		return this.getHours()*3600 + this.getMinutes()*60 + this.getSeconds();
	}

	// Poiché l'oggetto deve essere stampato in maniera "nativa", 
	// allora la classe deve provvedere a fare l'overriding del
	// metodo toString().
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.getHours() + ":");

		if (this.getMinutes() < 0)
		{
			sb.append("0");
		}

		sb.append(this.getMinutes() + ":");

		if (this.getSeconds() < 0)
		{
			sb.append("0");
		}

		sb.append(this.getSeconds());


		return sb.toString();
	}

}