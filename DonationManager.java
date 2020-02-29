public class DonationManager implements DonationManageInterface
{
	private VolunteerLine volunteers = new VolunteerLine();
	private RecipientLine recipients = new RecipientLine();
	private Container container = new Container();
	private Volunteer currentVolunteer;
	private Recipient currentRecipient;
	private DonationPackage currentPackage;

	//Adds a package of type DonationPackage
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException
	{
		container.loadContainer(dPackage);
		return true;
	}

	//Adds a volunteer of type Volunteer
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException
	{
		volunteers.addNewVolunteer(v);
		return true;
	}

	//Adds a recipient of type Recipient
	public boolean managerQueueRecipient(Recipient r) throws RecipientException
	{
		recipients.addNewRecipient(r);
		return true;
	}

	//Attempts to perform the donate package process
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException
	{
		//This checks to see if Volunteers, Recipients, or Containers are empty and causes that process to throw an exception
		if (volunteers.volunteerLineEmpty()==true)
		{
			currentVolunteer = volunteers.volunteerTurn();
			return 1;
		}
		if (recipients.recipientLineEmpty()==true)
		{
			currentRecipient = recipients.recipientTurn();
			return 2;
		}
		if (container.containerEmpty()==true)
		{
			currentPackage = container.removePackageFromContainer();
			return 3;
		}

		//Otherwise they all have something inside them and this performs the donation
		if (volunteers.volunteerLineEmpty()==false && recipients.recipientLineEmpty()==false && container.containerEmpty()==false)
		{
			currentVolunteer = volunteers.volunteerTurn();
			currentRecipient = recipients.recipientTurn();
			currentPackage = container.removePackageFromContainer();
		}
		return 0;
	}

	//Calls the array generator
	public DonationPackage[] managerArrayPackage()
	{
		return container.toArrayPackage();
	}

	//Calls the array generator
	public Volunteer[] managerArrayVolunteer()
	{
		return volunteers.toArrayVolunteer();
	}

	//Calls the array generator
	public Recipient[] managerArrayRecipient()
	{
		return recipients.toArrayRecipient();
	}

	//Delivers the donation string
	public String toString()
	{
		return (currentVolunteer.toString() + " Delivered " + currentPackage.toString() + " package to " + currentRecipient.toString());
	}
}