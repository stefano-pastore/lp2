class Test
{
	public static void main(String[] args)
	{
		Pizza margherita = new Pizza();
		Pizza marinara = new Pizza();

		margherita.addIngrediente(Pizza.Ingrediente.POMODORO);
		margherita.addIngrediente(Pizza.Ingrediente.MOZZARELLA);
		marinara.addIngrediente(Pizza.Ingrediente.POMODORO);
		marinara.addIngrediente(Pizza.Ingrediente.AGLIO);

		Pizza altra = margherita.clone();
		System.out.println(altra.compareTo(marinara));
	}
}