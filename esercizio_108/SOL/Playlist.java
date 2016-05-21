import java.util.List;
import java.util.LinkedList;

class Playlist implements Comparable
{
	private List<Song> playlist;
	private Integer duration;

	public Playlist()
	{
		playlist = new LinkedList<Song>();
		duration = 0;
	}

	public void add(Song s)
	{
		playlist.add(s);
		duration += s.getDuration();
	}

	// Potrebbe sorgere la tentazione di creare un ciclo mediante un iteratore
	// scorrere la collezione ed eliminare gli elementi.
	// ERRORE! Questa operazione viola il contratto di Iterator, il quale pretende
	// che la lista rimanga in sola lettura.

	public void remove(Song s)
	{
		while (playlist.remove(s))
		{
			duration -= s.getDuration();
		}
	}

	public Integer getDuration() { return duration; }

	public int compareTo(Object x)
	{
		Playlist playlist = (Playlist) x;
		return duration.compareTo(playlist.getDuration());
	}
}