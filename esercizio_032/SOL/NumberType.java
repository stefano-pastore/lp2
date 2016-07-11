enum NumberType
{
	BYTE(8), SHORT(16), INT(32),
	LONG(64), FLOAT(32), DOUBLE(64);

	public Integer width;
	
	private NumberType(Integer width)
	{
		this.width = width;
	}
	
	public boolean isAssignableTo(NumberType nt)
	{
		return (this.width <= nt.width);
	}
}
