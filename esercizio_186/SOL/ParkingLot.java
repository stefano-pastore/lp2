import java.util.Date;

class ParkingLot
{
	private final Integer m;
	private final Integer n;
	private final Date[][] parkingArea;

	public ParkingLot(Integer m, Integer n)
	{
		this.m = m;
		this.n = n;
		parkingArea = new Date[m][n];
	}

	private Pair<Integer> getFreeSpot()
	{
		Pair<Integer> position = null;
		
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (parkingArea[i][j] == null)
				{
					position = new Pair<Integer>(i,j);
				}
			}
		}

		return position;
	}

	public Pair<Integer> carIn()
	{
		Pair<Integer> position = getFreeSpot();
		
		if (position == null) return null;

		parkingArea[position.getFirst()][position.getSecond()] = new Date();

		return position;
	}

	public Integer carOut(Pair<Integer> position)
	{
		Integer i = position.getFirst();
		Integer j = position.getSecond();

		if (parkingArea[i][j] == null) return null;

		Date parked_at = parkingArea[i][j];
		Date current = new Date();

		long elapsed_ms = current.getTime() - parked_at.getTime();
		parkingArea[i][j] = null;
		return Integer.valueOf((int) elapsed_ms/1000);
	}
}