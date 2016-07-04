import java.lang.Thread;

class Auction
{
	private volatile Integer highestOffer;
	private volatile String bestBidder;
	private boolean auctionOpen;

	public Auction(Integer startingPrice)
	{
		highestOffer = startingPrice;
		auctionOpen = true;
	}

	public Integer getHighestOffer()
	{
		return this.highestOffer;
	}

	public synchronized void makeOffer(Integer offer, String bidder)
	{
		if ((offer > highestOffer) && (auctionOpen))
		{
			highestOffer = offer;
			bestBidder = bidder;

			new Thread()
			{
				Integer currentBid = highestOffer;
				String currentBidder = bestBidder;

				public void run()
				{
					try
					{
						Thread.sleep(3000);
					}
					catch (InterruptedException ie)
					{
						System.out.println(ie.getMessage());
					}

					synchronized(Auction.this)
					{
						if (highestOffer.equals(currentBid) && currentBidder.equals(bestBidder))
						{
							auctionOpen = false;
							System.out.println("Oggetto venduto a " + currentBidder + " per " + currentBid + " euro.");
						}
					}
				}
			}.start();
		}
	}
}