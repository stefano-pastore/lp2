class Apparecchio
{
	private final Integer power;
	private boolean isOn;
	private Integer availableSystemPower;
	
	public Apparecchio(Integer power)
	{
		this.power = power;
		this.isOn = false;
		this.availableSystemPower = 0;
	}
	
	public boolean isOn()
	{
		return this.isOn;
	}
	
	public Integer getPower()
	{
		return this.power;
	}
	
	public void setRemainingPower(Integer power)
	{
		if (power > 0)
		{
			this.availableSystemPower = power;
		}
	}
	
	public void on()
	{
		if (this.availableSystemPower < this.power)
		{
			throw new RuntimeException();
		}
		else
		{
			this.isOn = true;
		}
	}
	
	public void off()
	{
		this.availableSystemPower = 0;
		this.isOn = false;
	}
}
