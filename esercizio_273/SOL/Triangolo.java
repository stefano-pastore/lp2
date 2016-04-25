import java.lang.Math;

class Triangolo 
{
	private double sideA;
	private double sideB;
	private double sideC;

	public Triangolo(double sideA, double sideB, double sideC)
	{
		try 
		{
			if (this.isTriangle(sideA, sideB, sideC))
			{
				this.sideA = sideA;
				this.sideB = sideB;
				this.sideC = sideC;
			}
			else
			{
				throw new TriangoloException("Le misure specificate non sono adatte ai lati di un triangolo.");
			}
		}
		catch(TriangoloException e)
		{
			System.err.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	protected final boolean isTriangle(double sideA, double sideB, double sideC)
	{
		return ((sideA < sideB+sideC) && (sideB < sideA+sideC) && (sideC < sideB + sideA));
	}

	public double getArea()
	{
		double p = (this.sideA + this.sideB + this.sideC)/2;
		return Math.sqrt(p * (p-this.sideA) * (p-this.sideB) * (p-this.sideC));
	}

/*
	INNER CLASS TRIANGOLO ISOSCELE
*/
	public static class Isoscele extends Triangolo
	{
		public Isoscele(double sideA, double sideB) 
		{
			super(sideA, sideB, sideB);
		}
	}

/*
	INNER CLASS TRIANGOLO RETTANGOLO
*/
	public static class Rettangolo extends Triangolo
	{
		public Rettangolo(double catetoA, double catetoB)
		{
			super(catetoA, catetoB, Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2)));
		}
	}

/* 
	INNER CLASS TRIANGOLOEXCEPTION
*/
	protected class TriangoloException extends Exception
	{
		protected TriangoloException(String message)
		{
			super(message);
		}
	}	
}