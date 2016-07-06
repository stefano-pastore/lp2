class Sorter<T extends Comparable<T>>
{
	private T lastUsed;

	public Sorter(T element)
	{
		lastUsed = element;
	}

	public int check(T element)
	{
		int checkResult = element.compareTo(lastUsed);
		lastUsed = element;
		return checkResult;
	}
}