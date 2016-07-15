import java.util.Set;
import java.util.HashSet;

class Impianto
{
	private final Integer power;
	private final Set<Apparecchio> connected;
	
	public Impianto(Integer power)
	{
		this.power = power;
		connected = new HashSet<Apparecchio>();
	}
	
	public Integer collega(Apparecchio a)
	{
		
		if (!this.connected.contains(a))
		{
			this.connected.add(a);
		}
			Integer absorbedPower = this.potenza();
			a.setRemainingPower(this.power - absorbedPower);

			return absorbedPower;
	}
	
	public Integer potenza()
	{
		Integer totalPower = 0;
		for (Apparecchio a : connected)
		{
			if (a.isOn())
			{
				totalPower += a.getPower();
			}
		}
		
		return totalPower;
	}
}
