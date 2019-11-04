import java.util.Arrays;

public class BinaryHeap
{
	private int [] data = new int[10];
	private int size = 0;

	public void add(int item)
	{
		if (size == data.length)
			grow_array();

		data[size++] = item;
		int child = size-1;
		int parent = (child - 1) / 2;

		while ((data[parent] > data[child]) && parent >= 0)
		{
			swap(data, parent, child);
			child = parent;
			parent = (child - 1) / 2;
		}
	}

	public int remove()
	{
		int removed = data[0];
		data[0] = data[--size];
		siftdown(0);
		return removed;
	}

	private void siftdown(int pos)
	{
		int child = 2 * pos + 1;

		if(child < size)
		{
			if ((data[child] > data[child + 1]) && ((child + 1) < size))
				++child;
			if (data[pos] > data[child])
			{
				swap(data, pos, child);
				siftdown(child);
			}
		}
	}

	public void swap(int [] a, int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	private void grow_array()
	{
		int len = data.length;
		int [] new_array = new int[len*2];
		new_array = Arrays.copyOf(data, len*2);
		data = new_array;
	}
}