import java.util.List;
import java.util.ArrayList;

class Rational implements Comparable<Rational>
{
	private Integer numerator;
	private Integer denominator;
	
	public Rational(Integer numerator, Integer denominator)
	{
		if (denominator <= 0)
		{
			throw new IllegalArgumentException();
		}
		
		if (numerator == 0)
		{
			this.numerator = 0;
			this.denominator = 1;
		}
		else
		{
			this.numerator = numerator;
			this.denominator = denominator;
			this.minimize();
		}
	}
	
	private void minimize()
	{
		int min = (this.numerator < this.denominator) ? this.numerator : this.denominator;
		
		for (int i = 2; i <= min; i++)
		{
			while (((this.numerator % i) == 0) && ((this.denominator % i) == 0))
			{
				this.numerator /= i;
				this.denominator /= i;
			}
		}
	}
	
	protected Integer getDenominator() { return this.denominator; }
	protected Integer getNumerator() { return this.numerator; }
	
	public Rational times(Rational r)
	{
		return new Rational (r.getNumerator() * this.numerator, r.getDenominator() * this.denominator);
	}

	@Override
	public int compareTo(Rational r)
	{
		Integer mcd = this.getMCD(r);
		
		Rational r1 = applyMCD(mcd, this);
		Rational r2 = applyMCD(mcd, r);
		
		return r1.getNumerator().compareTo(r2.getNumerator());
	}
	
	private Rational applyMCD(Integer mcd, Rational r)
	{
		Integer numerator = (int) ((mcd / r.getDenominator()) * r.getNumerator());
		return new Rational(numerator, mcd);
	}
	
	protected List<Integer> getPrimeFactors()
	{
		List<Integer> primeFactors = new ArrayList<Integer>();
		Integer denominator = this.denominator;
		
		for (int i = 0; i < denominator; i++)
		{
			primeFactors.add(i, 0);
			while((denominator % (i+2)) == 0)
			{
				Integer k = primeFactors.get(i);
				primeFactors.remove(i);
				primeFactors.add(i, k+1);
				denominator = denominator / (i+2);
			}
		}
		
		return primeFactors;
	}
	
	public Rational plus(Rational r)
	{
		Integer mcd = this.getMCD(r);
		Integer numerator = (int) (((mcd/this.denominator) * this.numerator) + ((mcd / r.getDenominator()) * r.getNumerator()));
		
		return new Rational(numerator, mcd);
	}
	
	private Integer getMCD(Rational r)
	{
		List<Integer> factorsA = this.getPrimeFactors();
		List<Integer> factorsB = r.getPrimeFactors();
		List<Integer> factorsMCD = new ArrayList<Integer>();
		
		Integer size = (factorsA.size() < factorsB.size()) ? factorsB.size() : factorsA.size();
		
		for (int i = 0; i < size; i++)
		{
			if ((i < factorsA.size()) && (i < factorsB.size()))
			{
				Integer k = (factorsA.get(i) < factorsB.get(i)) ? factorsB.get(i) : factorsA.get(i);
				factorsMCD.add(k);
			}
			else if (i >= factorsA.size())
			{
				factorsMCD.add(factorsB.get(i));
			}
			else if (i >= factorsB.size())
			{
				factorsMCD.add(factorsA.get(i));
			}
		}
		
		Integer mcd = 1;
		
		for (int i = 0; i < size; i++)
		{
			mcd *= (int) (Math.pow(i+2, factorsMCD.get(i)));
		}
		
		return mcd;
	}
	
	public String toString()
	{
		if (this.numerator == 0) return "0";
		return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
	}
	
}
