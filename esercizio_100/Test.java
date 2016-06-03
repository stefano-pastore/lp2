import java.util.Comparator;

class Test
{
	public static void main(String[] args)
	{
		NutrInfo x = new NutrInfo(500);
		x.setNutrient(Nutrient.FAT, 12.0);
		x.setNutrient(Nutrient.CARBO, 20.0);
		x.setNutrient(Nutrient.PROTEIN, 15.0);

		Comparator<NutrInfo> c = NutrInfo.comparatorBy(Nutrient.PROTEIN);	
	}
}