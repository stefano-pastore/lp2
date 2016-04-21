class Test
{
	public static void main(String[] args)
	{
		Panino p = new Panino();
		p.addIngrediente(Panino.Ingrediente.SALAME);
		p.addIngrediente(Panino.Ingrediente.SOTTILETTA);
		System.out.println(p);
		p.addIngrediente(Panino.Ingrediente.MOZZARELLA);
	}
}