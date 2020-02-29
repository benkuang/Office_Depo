public class VolunteerLine implements VolunteerLineInterface
{
	private int maxSize;
	private int currentSize = 0;
	MyQueue<Volunteer> queue = new MyQueue<Volunteer>();

	public VolunteerLine()
	{
		maxSize = 5;
	}

	public VolunteerLine(int newSize)
	{
		maxSize = newSize;
	}

	//Add a new volunteer
	public boolean  addNewVolunteer(Volunteer v) throws VolunteerException
	{
		if(currentSize < maxSize)
		{
			queue.enqueue(v);
			currentSize++;
			return true;
		}
		else
		{
			throw new VolunteerException("Volunteer Queue is full");
		}
	}

	//Lets a volunteer and their turn and puts them in the back of the queue
	public  Volunteer volunteerTurn () throws VolunteerException
	{
		if(currentSize != 0)
		{
			Volunteer currentVolunteer = queue.dequeue();
			currentSize--;
			addNewVolunteer(currentVolunteer);
			return currentVolunteer;
		}
		else
		{
			throw new VolunteerException("Volunteer queue is empty");
		}
	}

	//Checks if the line is empty
	public boolean volunteerLineEmpty()
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
	public Volunteer[] toArrayVolunteer()
	{
		Volunteer allVolunteers[] = new Volunteer[currentSize];
		Object[] temp = queue.toArray();
		for(int i=0; i<currentSize; i++)
		{
			allVolunteers[i] = (Volunteer) temp[i];
		}
		return allVolunteers;
	}
}