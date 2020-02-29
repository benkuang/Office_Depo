public class RecipientLine implements RecipientLineInterface
{
	private int maxSize;
	private int currentSize = 0;
	MyQueue<Recipient> queue = new MyQueue<Recipient>();

	public RecipientLine()
	{
		maxSize = 5;
	}

	public RecipientLine(int newSize)
	{
		maxSize = newSize;
	}

	//Adds a new recipient
	public boolean addNewRecipient(Recipient rc) throws RecipientException
	{
		if(currentSize < maxSize)
		{
			queue.enqueue(rc);
			currentSize++;
			return true;
		}
		else
		{
			throw new RecipientException("The Recipient Queue is Full");
		}
	}

	//Lets a recipient have their turn and removes them from the queue
	public Recipient recipientTurn() throws RecipientException
	{
		if(currentSize != 0)
		{
			currentSize--;
			return queue.dequeue();
		}
		else
		{
			throw new RecipientException("The Recipient Queue is empty");
		}
	}

	//Checks if the line is empty
	public boolean recipientLineEmpty()
	{
		if(currentSize == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Returns an array using type casting
	public Recipient[] toArrayRecipient()
	{
		Recipient allRecipients[] = new Recipient[currentSize];
		Object[] temp = queue.toArray();
		for(int i=0; i<currentSize; i++)
		{
			allRecipients[i] = (Recipient) temp[i];
		}
		return allRecipients;
	}
}