import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Controller
{
	public Set<Function> functions;

	public Controller()
	{
		functions = new HashSet<>();
	}

	public void printOn() 
	{
		Iterator<Function> i = functions.iterator();

		while (i.hasNext())
		{
			Function f = i.next();
			if (f.getOnState())
			{
				System.out.println(f);
			}
		}
	}
	
	public Function addFunction(String name) 
	{
		Function f = new Function(name);
		functions.add(f);
		return f;
	}

	public class Function
	{
		private boolean isOn;
		private final Set<Function> incompatible_functions;
		private final String function_name;

		private Function(String name)
		{
			isOn = false;
			incompatible_functions = new HashSet<Function>();
			function_name = new String(name);
		}

		public void turnOn() 
		{ 
			this.isOn = true;
			disable_incompatible();
		}
		
		public void turnOff() 
		{ 
			this.isOn = false; 
		}

		public void setIncompatible(Function f) 
		{
			if (!incompatible_functions.contains(f))
			{
				incompatible_functions.add(f);
				f.setIncompatible(this);
			}
		}

		private boolean getOnState() 
		{ 
			return this.isOn; 
		}
		
		public String toString() 
		{ 
			return this.function_name; 
		}

		public void disable_incompatible()
		{
			if (!incompatible_functions.isEmpty())
			{
				Iterator<Function> incompatible_functions_iterator = incompatible_functions.iterator();
				Function incompatible_function = null;

				while (incompatible_functions_iterator.hasNext())
				{
					incompatible_function = incompatible_functions_iterator.next();
					
					if (incompatible_function.getOnState())
					{
						incompatible_function.turnOff();
					}
				}
			}
		}
	}
}