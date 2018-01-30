package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test01()  throws Throwable {
		GregorianCalendar gregCal = new GregorianCalendar(2018, 1, 1);
		CalDay calDay= new CalDay(gregCal);

		assertEquals(true, calDay.isValid());
		assertEquals(2018, calDay.getYear());
		assertEquals(1, calDay.getMonth());
		assertEquals(1, calDay.getDay());

		Appt appt = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		calDay.addAppt(appt);
		assertEquals(1, calDay.getSizeAppts());

		assertEquals("\t --- 1/1/2018 --- \n --- -------- Appointments ------------ --- \n" + appt.toString() + " \n", calDay.toString());

		LinkedList<Appt> appts = calDay.getAppts();
		assertEquals(appt, appts.get(0));
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test02()  throws Throwable {
		CalDay calDay= new CalDay();

		assertEquals(false, calDay.isValid());
		assertEquals("", calDay.toString());

		Appt appt = new Appt(-1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");
		calDay.addAppt(appt);


		assertEquals("", calDay.toString());

		LinkedList<Appt> appts = calDay.getAppts();
		assertEquals(null, appts);

		Iterator<?> iter = calDay.iterator();
		assertEquals(null, iter);
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test03()  throws Throwable {
		GregorianCalendar gregCal = new GregorianCalendar(2018, 1, 1);
		CalDay calDay= new CalDay(gregCal);

		Appt appt = new Appt(10,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		Appt appt2 = new Appt(1,
				1,
				1,
				1,
				2018,
				"Test",
				"Description");

		calDay.addAppt(appt);
		calDay.addAppt(appt2);
		assertEquals(2, calDay.getSizeAppts());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test04()  throws Throwable {
		GregorianCalendar gregCal = new GregorianCalendar(2018, 1, 1);
		CalDay calDay= new CalDay(gregCal);

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

		calDay.addAppt(appt);
		calDay.addAppt(appt2);
		assertEquals(2, calDay.getSizeAppts());
	}

	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test05()  throws Throwable {
		GregorianCalendar gregCal = new GregorianCalendar(2018, 1, 1);
		CalDay calDay= new CalDay(gregCal);

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

		calDay.addAppt(appt);
		calDay.addAppt(appt2);
		assertEquals(2, calDay.getSizeAppts());

		Iterator<?> iter = calDay.iterator();
		assertEquals(true, iter.hasNext());
		assertEquals(appt, iter.next());
	}
}
