package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	* Test that the gets methods work as expected.
	*/
	@Test
	public void test01()  throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());

		assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());

		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}

	@Test
	public void test02()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
			startMinute ,
			startDay ,
			startMonth ,
			startYear ,
			title,
			description);
		// assertions
		//assertTrue(appt.getValid());

		assertEquals(null, appt.toString());

		appt.setStartHour(5);
		assertEquals(5, appt.getStartHour());

		appt.setStartMinute(5);
		assertEquals(5, appt.getStartMinute());

		appt.setStartDay(20);
		assertEquals(20, appt.getStartDay());

		appt.setStartMonth(2);
		assertEquals(2, appt.getStartMonth());

		appt.setStartYear(2000);
		assertEquals(2000, appt.getStartYear());

		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());

		System.out.println(appt.toString());
		assertEquals("\t2/20/2000 at 5:5am ,Birthday Party, This is my birthday party.\n", appt.toString());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test03()  throws Throwable  {
		int startHour=12;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		// assertions
//		assertTrue(appt.getValid());
		appt.setStartMonth(12);
		assertEquals(12, appt.getStartMonth());

		appt.setStartDay(0);
		assertEquals(0, appt.getStartDay());

		appt.setStartDay(32);
		assertEquals(32, appt.getStartDay());

		appt.setStartMinute(-1);
		assertEquals(-1, appt.getStartMinute());

		appt.setStartMinute(60);
		assertEquals(60, appt.getStartMinute());

		appt.setStartHour(0);
		assertEquals(0, appt.getStartHour());

		appt.setStartHour(25);
		assertEquals(25, appt.getStartHour());


		assertEquals(2018, appt.getStartYear());
		appt.setRecurrence(null, 0, 0, 0);
//		assertEquals("Birthday Party", appt.getTitle());
//		assertEquals("This is my birthday party.", appt.getDescription());
	}
	
}
