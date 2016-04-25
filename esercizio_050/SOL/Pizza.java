import java.util.LinkedList;

class Pizza implements Comparable<Pizza>, Cloneable
{
	private LinkedList<Ingrediente> list;
	private Integer calorie;

	public Pizza() 
	{
		list = new LinkedList<>();
		calorie = new Integer(0);
	}

	public void addIngrediente(Ingrediente ingrediente)
	{
		calorie += ingrediente.getCalorie();
		list.add(ingrediente);
	}

	public int getCalorie() { return this.calorie; }

	public int compareTo(Pizza pizza)
	{
		int ext_calorie = pizza.getCalorie();

		if (this.calorie > ext_calorie)
		{
			return 1;
		}
		else if (this.calorie < ext_calorie)
		{
			return -1;
		}
		return 0;
	}

	public Pizza clone()
	{
		Pizza pizza;

		try
		{
			pizza = (Pizza) super.clone();
			pizza.list = (LinkedList<Ingrediente>) list.clone();
			pizza.calorie = this.getCalorie();
		}
		catch (CloneNotSupportedException e)
		{
			pizza = null;
			System.err.println(e.getMessage());
		}

		return pizza;
	}

	public enum Ingrediente
	{
		POMODORO("pomodoro", 5), AGLIO("aglio", 1), MOZZARELLA("mozzarella", 10);

		private int calorie;
		private String ingrediente;

		private Ingrediente(String ingrediente, int calorie)
		{
			this.calorie = calorie;
			this.ingrediente = ingrediente;
		}

		public int getCalorie() { return this.calorie; }
		public String getIngrediente() { return this.ingrediente; }
	}
}