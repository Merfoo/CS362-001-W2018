package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test01()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt, appts.get(1));
		assertEquals(appt2, appts.get(2));
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test02()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		try {
			LinkedList<CalDay> calDays = tb.getApptRange(appts, endCal, startCal);
		}
		catch(DateOutOfRangeException e) {

		}
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test03()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt4 = new Appt(0,
				10,
				11,
				10,
				2018,
				"Test Title",
				"Description Test");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt, appts.get(1));
		assertEquals(appt2, appts.get(2));

		tb.deleteAppt(appts, appt4);
		calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt, appts.get(1));
		assertEquals(appt2, appts.get(2));

		tb.deleteAppt(appts, appt);
		calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt2, appts.get(1));

		tb.deleteAppt(null, appt);
		calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt2, appts.get(1));

		tb.deleteAppt(null, null);
		calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt2, appts.get(1));

		tb.deleteAppt(appts, null);
		calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt2, appts.get(1));

		tb.deleteAppt(appts, appt3);
		calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt2, appts.get(1));
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test04()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");
		appt.setRecurrence(new int[]{1, 2, 3, 4}, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt, appts.get(1));
		assertEquals(appt2, appts.get(2));
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test05()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt, appts.get(1));
		assertEquals(appt2, appts.get(2));

		try {
			LinkedList<Appt> permuteDays = tb.permute(appts, new int[]{1, 2, 3, 4, 6});
		}
		catch (IllegalArgumentException e) {

		}

		LinkedList<Appt> permuteDays = tb.permute(appts, new int[]{0, 1, 2});
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test06()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");
		appt.setRecurrence(new int[]{}, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt, appts.get(1));
		assertEquals(appt2, appts.get(2));
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test07()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(-1,
				1,
				5,
				1,
				2018,
				"Test",
				"Description");
		appt.setRecurrence(new int[]{}, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		Appt appt2 = new Appt(-10,
				1,
				5,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				5,
				1,
				2018,
				"Test",
				"Description");

		assertFalse(appt3.getValid());

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(new LinkedList(), startCal, endCal);
		assertEquals(9, calDays.size());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test08()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				5,
				1,
				2018,
				"Test",
				"Description");
		appt.setRecurrence(new int[]{}, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		Appt appt2 = new Appt(10,
				1,
				5,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(10,
				1,
				5,
				1,
				2018,
				"Test",
				"Description");

		assertTrue(appt3.getValid());

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(9, calDays.size());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test09()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt, appts.get(1));
		assertEquals(appt2, appts.get(2));

		try {
			LinkedList<Appt> permuteDays = tb.permute(appts, new int[]{1, 2, 3, 4, 6});
		}
		catch (IllegalArgumentException e) {

		}

		LinkedList<Appt> permuteDays = tb.permute(new LinkedList<Appt>(), new int[]{});
		assertEquals(0, permuteDays.size());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test10()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 1, 10);

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(appt3, appts.get(0));
		assertEquals(appt, appts.get(1));
		assertEquals(appt2, appts.get(2));

		try {
			LinkedList<Appt> permuteDays = tb.permute(appts, new int[]{1, 2, 3, 4, 6});
		}
		catch (IllegalArgumentException e) {

		}

		LinkedList<Appt> permuteDays = tb.permute(new LinkedList<Appt>(), new int[]{});
		assertEquals(0, permuteDays.size());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test11()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 0, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 12, 10);

		Appt appt = new Appt(-1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		assertFalse(appt.getValid());
		assertTrue(appt2.getValid());
		assertFalse(appt3.getValid());

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		appt2.setRecurrence(new int[]{1, 2, 3, 4, 5}, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(374, calDays.size());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test12()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 0, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 12, 10);

		Appt appt = new Appt(-1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2019,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		assertFalse(appt.getValid());
		assertTrue(appt2.getValid());
		assertFalse(appt3.getValid());

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		appt2.setRecurrence(new int[]{1, 2, 3, 4, 5}, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(374, calDays.size());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test13()  throws Throwable {
		TimeTable tb = new TimeTable();
		GregorianCalendar startCal = new GregorianCalendar(2018, 0, 1);
		GregorianCalendar endCal = new GregorianCalendar(2018, 12, 10);

		Appt appt = new Appt(-1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(10,
				1,
				1,
				1,
				2019,
				"Test",
				"Description");

		Appt appt3 = new Appt(-10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		assertFalse(appt.getValid());
		assertTrue(appt2.getValid());
		assertFalse(appt3.getValid());

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt3);
		appts.add(appt);
		appts.add(appt2);

		appt2.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		LinkedList<CalDay> calDays = tb.getApptRange(appts, startCal, endCal);
		assertEquals(374, calDays.size());
	}
}
