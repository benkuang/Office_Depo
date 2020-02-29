public class MyQueue<T> implements QueueInterface<T>
{
	private int size = 0;
	private Node<T> front = null;
	private Node<T> end = front;

	public MyQueue()
	{

	}

	public MyQueue(int startSize)
	{
		for(int i=0;i<size;i++)
		{
			enqueue(null);
		}
	}

	public boolean isEmpty()
	{
		if(size==0)
		{
			return true; //Return true if the queue is empty
		}
		else
		{
			return false; //Otherwise queue has elements and returns false
		}
	}

	public boolean isFull()
	{
		if(size != 0)
		{
			return true; //Return true if the queue is not empty
		}
		else
		{
			return false; //Otherwise queue does not have elements and returns false
		}
	}

	public T dequeue()
	{
		Node<T> currentNode = front;
		if (size>1)
		{
			size = size - 1;
			front = currentNode.next();
			return currentNode.value();
		}
		else
		{
			size = size - 1;
			front = null;
			end = front;
			return currentNode.value();
		}

	}

	public int size()
	{
		return size;
	}

	public boolean enqueue(T e)
	{
		if (size == 0)
		{
			Node<T> newNode = new Node<T>(e);
			size = size + 1;
			front = newNode;
			end = newNode;
			return true;
		}
		else
		{
			Node<T> newNode = new Node<T>(e, end.next());
			size = size + 1;
			end.setNext(newNode);
			end = newNode;
			return true;
		}
	}

	public T[] toArray()
	{
		T[] elements = (T[]) new Object[size];
		Node<T> currentNode = front;
		for(int i=0;i<size;i++)
		{
			elements[i] = currentNode.value();
			currentNode = currentNode.next();
		}
		return elements;
	}
}