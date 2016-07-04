import java.lang.Thread;

class Test
{
	public static void main(String args[]) throws InterruptedException
	{
		Auction a = new Auction(1000);
		a.makeOffer(1100, "Marco");
		a.makeOffer(1200, "Luca");
		Thread.sleep(1000);
		a.makeOffer(200, "Anna");
		Thread.sleep(1000);
		a.makeOffer(1500, "Giulia");
		Thread.sleep(4000);
	}
}