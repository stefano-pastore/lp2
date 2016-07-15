import java.util.List;
import java.util.ArrayList;

class MultiBuffer<E>
{
	private final Integer size;
	List<Buffer<E>> bufferList;

	public MultiBuffer(Integer size)
	{
		if (size <= 0)
		{
			throw new RuntimeException();
		}
		this.size = size;
		bufferList = new ArrayList<Buffer<E>>();
		for (int i = 0; i < this.size; i++)
		{
			bufferList.add(new Buffer<E>());
		}
	}

	private Buffer<E> getSmallestBuffer()
	{
		Buffer<E> smallestBuffer = null;

		for (int i = 0; i < this.size; i++)
		{
			Buffer<E> currentBuffer = bufferList.get(i);
			if ((smallestBuffer == null) || (smallestBuffer.size < currentBuffer.size))
			{
				smallestBuffer = currentBuffer;
			}

		}

		return smallestBuffer;
	}

	public synchronized void insert(E e)
	{
		Buffer<E> smallestBuffer = this.getSmallestBuffer();
		smallestBuffer.add(e);
	}

	public synchronized E take(Integer i)
	{
		return bufferList.get(i).getFirst();
	}

	private class Buffer<K>
	{
		List<K> buffer;
		Integer size;

		Buffer()
		{
			buffer = new ArrayList<K>();
			size = 0;
		}

		boolean add(K e)
		{
			boolean success = false;
			success = buffer.add(e);
			if (success)
				size = size + 1;
			return success;
		}

		K getFirst()
		{
			K e = null;
			if (!buffer.isEmpty())
			{
				e = buffer.get(0);
				if (buffer.remove(0))
				{
					size = size - 1;
				}
			}
			return e;
		}
	}
}
