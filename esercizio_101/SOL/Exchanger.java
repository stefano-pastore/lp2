class Exchanger<E>
{
	private E objA;
	private E objB;
	private boolean calledOnce;
	private boolean calledTwice;
	
	public E exchange(E e)
	{
		synchronized(this)
		{
			if (calledTwice)
			{
				throw new RuntimeException();
			}
			else
			{
				if (!calledOnce)
				{
					objA = e;
					calledOnce = true;
					while (!calledTwice)
					{
						try
						{
							this.wait();
						}
						catch (InterruptedException ie)
						{
							ie.getMessage();
							return null;
						}
					}
					return objB;
				}
				else
				{
					objB = e;
					calledTwice = true;
					this.notify();
					return objA;
				}
			}
		}
	}
}
