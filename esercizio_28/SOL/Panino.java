import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.lang.StringBuffer;

class Panino
{
	LinkedList<Ingrediente> list;

	public Panino()
	{
		list = new LinkedList<>();
	}

	public void addIngrediente(Ingrediente ingrediente)
	{
		Iterator<Ingrediente> iterator = list.iterator();
		String category = ingrediente.getIngredientCategory();
		
		while (iterator.hasNext())
		{
			Ingrediente i = iterator.next();

			if (i.getIngredientCategory() == category)
			{
				throw new RuntimeException();
			}
		}

		list.add(ingrediente);
	}

	public String toString()
	{
		Iterator<Ingrediente> iterator = list.iterator();
		StringBuffer panino = new StringBuffer();

		panino.append("panino con ");

		while (iterator.hasNext())
		{
			Ingrediente i = iterator.next();
			panino.append(i.getIngredientName() + ", ");
		}
		
		panino = panino.replace(panino.length()-2, panino.length(), "");
		return panino.toString();
	}

	public enum Ingrediente
	{
		PROSCIUTTO("PROSCIUTTO", "ripieni"), SALAME("SALAME", "ripieni"),
		SOTTILETTA("SOTTILETTA", "formaggi"), MOZZARELLA("MOZZARELLA", "formaggi"),
		MAIONESE("MAIONESE", "salse"), SENAPE("SENAPE", "salse");

		private final String ingredient;
		private final String category;

		private Ingrediente(String ingredient, String category)
		{
			this.category = category;
			this.ingredient = ingredient;
		}

		public String getIngredientCategory()
		{
			return this.category;
		}

		public String getIngredientName()
		{
			return this.ingredient;
		}
	}
}