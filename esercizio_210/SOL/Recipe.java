import java.util.List;
import java.util.ArrayList;

class Recipe
{
	private final String name;
	private String descr;
	private final List<Ingredient> list;
	
	private class Ingredient
	{
		final String name;
		final Integer qty;
		
		Ingredient(String name, Integer qty)
		{
			if ((name == null) || (qty < 0))
			{
				throw new IllegalArgumentException();
			}
			
			this.name = name;
			this.qty = qty;
		}
		
		String getQuantitiesForAll(Integer n)
		{
			StringBuffer sb = new StringBuffer();
			
			if (!qty.equals(0))
			{
				sb.append(qty * n);
			}
			else
			{
				sb.append("q.b.");
			}
			
			sb.append(" ");
			sb.append(name);
			return sb.toString();
		}
		
	}
	public void setDescr(String descr)
	{
		this.descr = descr;
	}
	
	public Recipe(String name)
	{
		list = new ArrayList<Ingredient>();
		this.name = name;
		this.descr = null;
	}
	
	public void addIngr(Integer qty, String ingredient)
	{
		list.add(new Ingredient(ingredient, qty));
	}
	
	public String toString(Integer n)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(name + "\n\n");
		for (Ingredient i : list)
		{
			sb.append(i.getQuantitiesForAll(n));
			sb.append("\n");
		}
		sb.append("\n" + descr);
		
		return sb.toString();
	}
}
