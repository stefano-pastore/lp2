import java.util.ArrayList;

class Polynomial
{
	private ArrayList<Double> coefficients;

	public Polynomial(double[] c)
	{
		coefficients = new ArrayList<Double>();
		for (int i = 0; i < c.length; i++)
		{
			coefficients.add(i, c[i]);
		}
	}

	private Polynomial(ArrayList<Double> al)
	{
		coefficients = al;
	}

	public Integer getDegree() { return coefficients.size()-1; }

	protected Double get(int index) { return coefficients.get(index); }

	public Polynomial times(Polynomial p)
	{
		ArrayList<Double> al = allocatePolynomialSpace(p.getDegree() + this.getDegree());
		
		Double k = 0.0;

		for (int i = 0; i <= this.getDegree(); i++)
		{
			for (int j = 0; j <= p.getDegree(); j++)
			{
				k = al.get(i+j);
				k += coefficients.get(i) * p.get(j);
				al.set(i+j, k);
			}
		}

		return new Polynomial(al);
	}

	private ArrayList<Double> allocatePolynomialSpace(Integer degree)
	{
		ArrayList<Double> al = new ArrayList<>();

		for (int i = 0; i <= degree; i++)
		{
			al.add(0.0);
		}

		return al;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		boolean prevWereZero = true;

		for (int i = 0; i < coefficients.size(); i++)
		{
			Double k = coefficients.get(i);

			if (k != 0.0)
			{
				if ((k > 0.0) && (i > 0.0))
				{
					sb.append("+");
				}

				sb.append(k);

				if (i > 0.0)
				{
					sb.append("x^" + i);
				}
			}
			
		}

		return sb.toString();
	}
}