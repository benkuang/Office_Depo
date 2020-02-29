public class Container implements ContainerInterface
{
	private int containerSize;
	private int containerCount = 0;
	MyStack<DonationPackage> stack = new MyStack<DonationPackage>();

	public Container()
	{
		containerSize = 5;
	}

	public Container(int size)
	{
		containerSize = size;
	}

	//Adds a package to the container stack
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException
	{
		if(containerCount < containerSize)
		{
			stack.push(dPackage);
			containerCount++;
			return true;
		}
		else
		{
			throw new ContainerException("The Container is Full");
		}
	}

	//Attempts to take a package from the pile and donate it
	public DonationPackage removePackageFromContainer() throws ContainerException
	{
		if (containerCount != 0)
		{
			containerCount--;
			return stack.pop();
		}
		else
		{
			throw new ContainerException("The Container is Empty");
		}
	}

	//Checks if the container is empty
	public boolean containerEmpty()
	{
		if(containerCount == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Returns an array using type casting
	public DonationPackage[] toArrayPackage()
	{
		DonationPackage allPackages[] = new DonationPackage[containerCount];
		Object[] temp = stack.toArray();
		for(int i=0; i<containerCount; i++)
		{
			allPackages[i] = (DonationPackage) temp[i];
		}
		return allPackages;
	}
}