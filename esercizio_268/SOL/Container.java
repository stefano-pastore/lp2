import java.util.ArrayList;

class Container
{
	private ArrayList<Container> connected_containers;
	private float capacity;

	public Container()
	{
		connected_containers = new ArrayList<>();
		capacity = 0;
	}

	public void addWater(float l)
	{
		capacity = ((capacity + l) < 0) ? 0 : capacity + l;
	}

	public void connect(Container c)
	{
		this.add_container(c);
		c.add_container(this);
		
		for (int i = 0; i < connected_containers.size(); i++)
		{
			Container current_container = connected_containers.get(i);

			for (int j = 0; j < connected_containers.size(); j++)
			{
				Container cc = connected_containers.get(j);
				current_container.add_container(cc);
			}
		}

		updateCapacity();
	}

	protected void updateCapacity()
	{
		float scc = getSingleContainerCapacity();
		this.setWater(scc);
		
		for (int i = 0; i < connected_containers.size(); i++)
		{
			connected_containers.get(i).setWater(scc);
		}
	}

	protected void add_container(Container c)
	{
		if ((!(connected_containers.contains(c))) && (c != this))
		{
			connected_containers.add(c);
		}
	} 

	public float getAmount()
	{
		return capacity;
	}

	private float getSingleContainerCapacity()
	{	
		float total = this.capacity;
		
		for (Container c : connected_containers)
		{
			total += c.getAmount();
		}

		return (total / (connected_containers.size() + 1));
	}

	protected void setWater(float l)
	{
		this.capacity = l;
	}
}