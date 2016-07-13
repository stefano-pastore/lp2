class Test
{
	static class ExchangingThread<E> extends Thread
	{
		private E element;
		private Exchanger<E> e;
		
		public ExchangingThread(E element, Exchanger<E> e)
		{
			this.element = element;
			this.e = e;
		}
		
		public void run()
		{
			E a = e.exchange(element);
			System.out.println(a);
		}
	}
	
	public static void main(String[] args)
	{
		Exchanger<String> e = new Exchanger<String>();
		ExchangingThread<String> et1 = new ExchangingThread<String>("Pippo", e);
		et1.start();
		
		String a = e.exchange("ciao");
		System.out.println(a);
	}
}
