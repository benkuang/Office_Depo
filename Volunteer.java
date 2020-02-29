public class Volunteer
{
	private String name;

	public Volunteer()
	{
		name = "No Name";
	}

	public Volunteer(String newName)
	{
		name = newName;
	}

	public String getName()
	{
		return name;
	}

	public String toString()
	{
		return name;
	}
}