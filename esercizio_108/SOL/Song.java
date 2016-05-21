class Song
{
	private String name;
	private Integer duration;

	public Song(String name, Integer duration)
	{
		if (name.equals("") || name == null)
		{
			throw new RuntimeException();
		}
		else
		{
			this.name = name;
		}

		if (duration <= 0)
		{
			throw new RuntimeException();
		}
		else
		{
			this.duration = duration;
		}
	}

	public Integer getDuration() { return duration; }
	public String getName() { return name; }

	public boolean equals(Object x)
	{
		if (!(x instanceof Song)) return false;

		Song song = (Song) x;

		return name.equals(song.getName()) && duration.equals(song.getDuration());
	}
}