import java.util.Comparator;

class NutrInfo implements Comparable
{
	private Integer calories;

	// Ho scelto l'array "primitivo" e quindi immutabile per rispecchiare il fatto
	// che ogni alimento è unicamente formato dalle tre componenti sistetizzate
	// qui come "fat", "carbo" e "protein".
	private final Double[] nutrients;


	public NutrInfo(Integer cal)
	{
		calories = cal;
		nutrients = new Double[3];
		nutrients[Nutrient.FAT.ordinal()] = 0.0;
		nutrients[Nutrient.CARBO.ordinal()] = 0.0;
		nutrients[Nutrient.PROTEIN.ordinal()] = 0.0;
	}

	public void setNutrient(Nutrient nutrient, Double grams)
	{
		// Il metodo ordinal() restituisce la posizione dell'etichetta
		// all'interno dell'enum. Il suo contrario è values().
		nutrients[nutrient.ordinal()] = grams;
	}

	// Potrebbe anche essere dichiarata privata dal momento che questa
	// classe è l'unica utente di questa funzione membro.
	public Integer getCalories() { return this.calories; }

	private Double getNutrient(Nutrient nutrient) { return nutrients[nutrient.ordinal()]; }

	public int compareTo(Object x)
	{
		NutrInfo ext = (NutrInfo) x;
		return calories.compareTo(ext.getCalories());
	}

	public static Comparator<NutrInfo> comparatorBy(Nutrient nutrient)
	{
		return new Comparator<NutrInfo> ()
		{
			@Override
			public int compare(NutrInfo x, NutrInfo y)
			{
				return x.getNutrient(nutrient).compareTo(y.getNutrient(nutrient));
			}
		};
	}
}