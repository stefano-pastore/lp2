class Test
{

	public static void main(String[] args)
	{
		int[][] arr = { { 23, 23, 45, 2, 4 }, { -10, 323, 33, 445, 4 }, { 12, 44, 90, 232, 122 } };

		System.out.println(concurrentMax(arr));
	}

	public static Integer concurrentMax(int[][] a)
	{
		final Integer[] matrix_max = { null };

		for (int i = 0; i < a.length; i++)
		{
			final Integer row = i;

			Thread t = new Thread() {
				public void run()
				{
					int max = a[row][0];

					for (int col = 0; col < a[row].length; col++)
					{
						if (a[row][col] > max)
						{
							max = a[row][col];
						}
					}

					synchronized (matrix_max)
					{
						if ((matrix_max[0] == null) || (matrix_max[0] < max))
						{
							matrix_max[0] = max;
						}
					}
				}
			};

			t.start();
			try
			{
				t.join();
			} 
			catch (InterruptedException ie)
			{
				ie.getMessage();
				return null;
			}
		}
		return matrix_max[0];
	}
}
