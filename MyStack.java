public class MyStack<T> implements StackInterface<T>
{
	private int size = 0;
	private Node<T> top = null;

	public MyStack()
	{

	}

	public MyStack(int startSize)
	{
		for(int i=0;i<size;i++)
		{
			push(null);
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

	public T pop()
	{
		Node<T> currentNode = top;
		if (size>1)
		{
			size = size - 1;
			top = currentNode.next();
			return currentNode.value();
		}
		else if (size==1)
		{
			size = size - 1;
			top = null;
			return currentNode.value();
		}
		else
		{
			return null;
		}
	}

	public int size()
	{
		return size;
	}

	public boolean push(T e)
	{
		Node<T> newNode = new Node<T>(e, top);
		size = size + 1;
		top = newNode;
		return true;
	}

	public T[] toArray()
	{
		T[] elements = (T[]) new Object[size];
		Node<T> currentNode = top;
		for(int i=0;i<size;i++)
		{
			elements[i] = currentNode.value();
			currentNode = currentNode.next();
		}
		return elements;
	}
}