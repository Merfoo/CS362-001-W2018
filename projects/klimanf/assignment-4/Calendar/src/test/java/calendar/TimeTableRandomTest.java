package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import jdk.vm.ci.meta.Value;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 10 * 1000; /* Timeout at 30 seconds */
	private static final int NUM_APPTS=200;

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
    @Test
    public void radnomtest()  throws Throwable  {
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


        System.out.println("Start testing...");
        LinkedList<Appt> apptList = new LinkedList<Appt>();
        GregorianCalendar startCalenday = new GregorianCalendar(0, 1, 1);
        GregorianCalendar endCalenday = new GregorianCalendar(250, 1, 1);

        for(int i = 0; i < NUM_APPTS; i++)
        {
            // Create random object with current time in millis
            long randomSeed = System.currentTimeMillis();
            Random random = new Random(randomSeed);

            // Generate random start times for appts
            int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 24);
            int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 60);
            int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 27);
            int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
            int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 260);

            if(i % 10 == 0)
            {
                startHour = ValuesGenerator.RandInt(random);
                startMinute = ValuesGenerator.RandInt(random);
                startDay = ValuesGenerator.RandInt(random);
                startYear = ValuesGenerator.RandInt(random);
            }

            String title = "Its a title";
            String desc = "Its a description";
            Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, desc);

            int[] recurDays = null;

            if(i % 50 != 0) {
                int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
                recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
            }

            int recur=ApptRandomTest.RandomSelectRecur(random);
            int recurIncrement = ValuesGenerator.getRandomIntBetween(random, -3, 10);
            int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
            appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

            apptList.add(appt);
        }

        TimeTable table = new TimeTable();
        table.getApptRange(apptList, startCalenday, endCalenday);

        try
        {
            table.getApptRange(apptList, endCalenday, startCalenday);
        }

        catch(DateOutOfRangeException e){}

        System.out.println("Done testing...");
    }

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
    @Test
    public void random()  throws Throwable  {
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        // Create random object with current time in millis
        Random random = new Random(System.currentTimeMillis());

        System.out.println("Start testing...");
        LinkedList<Appt> apptList = new LinkedList<Appt>();
        GregorianCalendar startCalenday = new GregorianCalendar(0, 1, 1);
        GregorianCalendar endCalenday = new GregorianCalendar(250, 1, 1);

        for(int i = 0; i < NUM_APPTS; i++)
        {
            // Generate random start times for appts
            int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 24);
            int startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 60);
            int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 27);
            int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
            int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 260);

            if(i % 10 == 0 && i > 0)
            {
                startHour = ValuesGenerator.RandInt(random);
                startMinute = ValuesGenerator.RandInt(random);
                startDay = ValuesGenerator.RandInt(random);
                startYear = ValuesGenerator.RandInt(random);
            }

            String title = "Its a title";
            String desc = "Its a description";
            Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, desc);

            int[] recurDays = null;

            if(i % 50 != 0) {
                int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
                recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
            }

            int recur=ApptRandomTest.RandomSelectRecur(random);
            int recurIncrement = ValuesGenerator.getRandomIntBetween(random, -3, 10);
            int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
            appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

            apptList.add(appt);
        }

        TimeTable table = new TimeTable();

        table.deleteAppt(null, apptList.get(1));
        table.deleteAppt(apptList, apptList.get(0));

        for(int i = 0; i < NUM_APPTS; i++)
        {
            table.deleteAppt(apptList, apptList.get(ValuesGenerator.getRandomIntBetween(random, 0, apptList.size() - 1)));
        }

        table.deleteAppt(null, null);
        table.deleteAppt(apptList, null);

        System.out.println("Done testing...");
    }
}
