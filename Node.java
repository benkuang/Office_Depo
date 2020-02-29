public class Node<E>
{
	private E data;
	private Node<E> next;

	public Node(E newEntry)
	{
		data=newEntry;
		next=null;
	}

	public Node(E newEntry, Node<E> nextNode)
	{
		data=newEntry;
		next=nextNode;
	}

	public Node<E> next()
	{
		return next;
	}

	public void setNext(Node<E> nextNode)
	{
		next=nextNode;
	}

	public void setValue(E newEntry)
	{
		data=newEntry;
	}

	public E value()
	{
		return data;
	}
}
