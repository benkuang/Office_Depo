
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;
	DonationPackage dpk1, dpk2 ,dpk3,dpk4,dpk5,dpk6;
	Volunteer v1, v2, v3, v4, v5, v6;
	Recipient r1, r2, r3, r4, r5, r6;

	@Before
	public void setUp() throws Exception {

		manager = new DonationManager();
		dpk1 = new DonationPackage("Pens", 10);
		dpk2 = new DonationPackage("Books", 12);
		dpk3 = new DonationPackage("Papers", 5);
		dpk4 = new DonationPackage("Folders", 9);
		dpk5 = new DonationPackage("Laptop", 10);
		dpk6 = new DonationPackage("Desktop", 30);

		v1 = new Volunteer("Ben");
		v2 = new Volunteer("Sanders");
		v3 = new Volunteer("Joe");
		v4 = new Volunteer("Andrew");
		v5 = new Volunteer("Tom");
		v6 = new Volunteer("Pete");

		r1 = new Recipient("Alison");
		r2 = new Recipient("Danna");
		r3 = new Recipient("Dare");
		r4 = new Recipient("Luna");
		r4 = new Recipient("Jane");
		r4 = new Recipient("Lapis");

	}

	@After
	public void tearDown() throws Exception {

		manager = null;
	}

	/**
	 * Student test that a new DonationPackage is created and
	 * the manager correctly calls load the container
	 */
	@Test
	public void testManagerLoadcontainer()
	{
		try
		{
			//Test one package
			manager.managerLoadContainer(dpk5);
			assertEquals(manager.managerArrayPackage()[0].toString(), "Laptop");
			manager.managerLoadContainer(dpk1);
			manager.managerLoadContainer(dpk2);
			//Test a stack of three packages
			assertEquals(manager.managerArrayPackage()[0].toString(), "Books");
			assertEquals(manager.managerArrayPackage()[1].toString(), "Pens");
			assertEquals(manager.managerArrayPackage()[2].toString(), "Laptop");
			//Test an exception throw
			manager.managerLoadContainer(dpk3);
			manager.managerLoadContainer(dpk4);
			manager.managerLoadContainer(dpk6);

		}
		catch(ContainerException e)
		{
			assertTrue("Successfully threw a Container Excepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}

	}

	/**
	 * Student test that a new Volunteer is created and
	 * the manager correctly queues the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try
		{
			//Test one volunteer
			manager.managerQueueVolunteer(v1);
			assertEquals(manager.managerArrayVolunteer()[0].toString(), "Ben");
			manager.managerQueueVolunteer(v2);
			manager.managerQueueVolunteer(v3);
			//Test a queue of three volunteers
			assertEquals(manager.managerArrayVolunteer()[0].toString(), "Ben");
			assertEquals(manager.managerArrayVolunteer()[1].toString(), "Sanders");
			assertEquals(manager.managerArrayVolunteer()[2].toString(), "Joe");
			//Test an exception throw
			manager.managerQueueVolunteer(v4);
			manager.managerQueueVolunteer(v5);
			manager.managerQueueVolunteer(v6);

		}
		catch(VolunteerException e)
		{
			assertTrue("Successfully threw a Volunteer Excepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}

	}

	/**
	 * Student test that a new Recipient is created and
	 * the manager correctly queues the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		try
		{
			//Test one recipient
			manager.managerQueueRecipient(r1);
			assertEquals(manager.managerArrayRecipient()[0].toString(), "Alison");
			manager.managerQueueRecipient(r2);
			manager.managerQueueRecipient(r3);
			//Test a queue of three recipients
			assertEquals(manager.managerArrayRecipient()[0].toString(), "Alison");
			assertEquals(manager.managerArrayRecipient()[1].toString(), "Danna");
			assertEquals(manager.managerArrayRecipient()[2].toString(), "Dare");
			//Test an exception throw
			manager.managerQueueRecipient(r4);
			manager.managerQueueRecipient(r5);
			manager.managerQueueRecipient(r6);

		}
		catch(RecipientException e)
		{
			assertTrue("Successfully threw a Recipient Excepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
	}

	/**
	 * Student test that the manager correctly calls donatePackage,
	 * testing the situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		try
		{
			//Tests a single donation
			manager.managerLoadContainer(dpk1);
			manager.managerQueueVolunteer(v1);
			manager.managerQueueRecipient(r1);
			manager.donatePackage();
			assertEquals(manager.toString(), "Ben Delivered Pens package to Alison");
			//Tests three donations with 2 new volunteers first volunteer should be at the front
			manager.managerLoadContainer(dpk1);
			manager.managerQueueRecipient(r1);
			manager.managerLoadContainer(dpk2);
			manager.managerQueueVolunteer(v2);
			manager.managerQueueRecipient(r2);
			manager.managerLoadContainer(dpk3);
			manager.managerQueueVolunteer(v3);
			manager.managerQueueRecipient(r3);
			manager.donatePackage();
			assertEquals(manager.toString(), "Ben Delivered Papers package to Alison");
			manager.donatePackage();
			assertEquals(manager.toString(), "Sanders Delivered Books package to Danna");
			manager.donatePackage();
			assertEquals(manager.toString(), "Joe Delivered Pens package to Dare");
			manager.donatePackage();
		}
		catch(RecipientException e) //No recipient
		{
			assertTrue("Successfully threw a Recipient Excepetion",true);
		}
	}

}
