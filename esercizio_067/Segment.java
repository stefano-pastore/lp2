import java.lang.Math;

class Segment implements Cloneable
{
	private Point a;
	private Point b;

	public Segment(double x1, double y1, double x2, double y2)
	{
		a = new Point(x1, y1);
		b = new Point(x2, y2);
	}

	public Double getDistance()
	{
		Double area = ((a.getX() * b.getY()) - (b.getX() * a.getY())/2);
		if (area < 0) area *= -1;

		Double base = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
		if (base.equals(0.0))
		{
			throw new RuntimeException();
		}
		else if (base < 0)
		{
			base *= -1;
		}

		return ((2 * area) / base);
	}

	protected Point getSegmentStart() { return a; }
	protected Point getSegmentEnd() { return b; }

	@Override
	public boolean equals(Object x)
	{
		if (!(x instanceof Segment)) return false;
		Segment s = (Segment) x;

		return ((s.getSegmentStart().equals(a) && s.getSegmentEnd().equals(b)) ||
						(s.getSegmentStart().equals(b) && s.getSegmentEnd().equals(a)));
	}

	@Override
	public Segment clone()
	{
		Segment segment = null;

		try
		{
			// La classe Segment consta unicamente di
			// valori immutabili, pertanto la copia
			// superficiale è sufficiente.
			segment = (Segment) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			System.err.println(e.getMessage());
		}

		return segment;
	}

	// Ovviamente essendo una classe interna privata
	// nessuno dall'esterno potrà vedere che Point è
	// clonabile e l'interfaccia di tag è pertanto
	// superflua.
	private class Point implements Cloneable
	{
		Double x;
		Double y;

		Point(Double x, Double y)
		{
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o)
		{
			if (!(o instanceof Point)) return false;

			Point p = (Point) o;

			return (x.equals(p.getX()) && y.equals(p.getY()));
		}

		@Override
		public Point clone()
		{
			Point point = null;

			try
			{
				// Gli oggetti Double sono immutabili,
				// pertanto è sufficiente una copia superficiale.
				point = (Point) super.clone();
				
			}
			catch (CloneNotSupportedException e)
			{
				System.err.println(e.getMessage());
			}

			return point;
		}

		Double getX() { return x; }
		Double getY() { return y; }
	}
}