class Alarm extends Thread
{
	private boolean onGoingAnomaly;
	private Integer alarmTimeout;
	private Thread timeout;

	public Alarm(Integer seconds)
	{
		onGoingAnomaly = false;
		alarmTimeout = seconds;
		timeout = null;
	}

	public void anomalyStart()
	{
		if (!onGoingAnomaly)
		{
			onGoingAnomaly = true;
			timeout = new Thread() {
				public void run()
				{
					try
					{
						Thread.sleep(alarmTimeout * 1000);
					}
					catch (InterruptedException e)
					{
						return;
					}

					if (onGoingAnomaly)
					{
						System.out.println("Allarme!");
					}
				}
			};

			timeout.start();
		}
	}

	public void anomalyEnd()
	{
		onGoingAnomaly = false;
	}
}