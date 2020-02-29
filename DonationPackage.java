public class DonationPackage
{
	private String description;
	private double weight;

	public DonationPackage(String newDescription, double newWeight)
	{
		description = newDescription;
		weight = newWeight;
	}

	public String getDescription()
	{
		return description;
	}

	public double getWeight()
	{
		return weight;
	}

	public boolean isHeavy()
	{
		if (weight>20)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String toString()
	{
		return description;
	}
}