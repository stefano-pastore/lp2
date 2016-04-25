/*
	Di seguito alcuni punti critici dell'esercizio.
*/

// La classe deve implementare l'interfaccia Comparable poiché
// fa l'overriding del metodo compareTo().
class Box implements Comparable
{
	private int height;
	private int width;
	private int depth;

	public Box(int height, int width, int depth)
	{
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	public boolean fitsIn(Box b)
	{
		return ((b.getHeight() >= this.height) && 
				(b.getWidth() >= this.width) && 
				(b.getDepth() >= this.depth));
	}

	public int getHeight() { return this.height; }
	public int getDepth() { return this.depth; }
	public int getWidth() { return this.width; }

	public boolean equals(Object x)
	{
		// Per il contratto del metodo equals() dopo
		// l'opportuno controllo...
		if (!(x instanceof Box)) return false;
		// ... c'è bisogno del cast affinché si possano
		// invocare i metodi dell'oggetto box.
		Box box = (Box) x;

		if ((this.height == box.getHeight()) && 
			(this.width == box.getWidth()) && 
			(this.height == box.getHeight())) return true;
		return false;
	}

	public int compareTo(Object x)
	{
		// Il contratto dell'interfaccia non prevede che venga effettuato
		// un controllo sul tipo dell'oggetto passato. Deve essere cura della 
		// classe cliente utilizzare il metodo con il giusto parametro. Si procede
		// quindi direttamente con il cast.
		Box box = (Box) x;
		int volume = this.height * this.depth * this.width;
		int ext_volume = box.getHeight() * box.getDepth() * box.getWidth();

		if (volume == ext_volume) return 0;
		if (volume > ext_volume) return 1;
		return -1; 
	}
}