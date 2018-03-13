package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try{
			 CalDay day = null;
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				 long randomseed =System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 GregorianCalendar calendar = new GregorianCalendar(
						 ValuesGenerator.getRandomIntBetween(random,-1000, 10000),
						 ValuesGenerator.getRandomIntBetween(random,-10, 40),
						 ValuesGenerator.getRandomIntBetween(random,-10, 40));

				 if(day == null)
				 	day = new CalDay(calendar);

				 // Generate random start times for appts
				 int startHour = ValuesGenerator.getRandomIntBetween(random, -3, 24);
				 int startMinute = ValuesGenerator.getRandomIntBetween(random, -3, 60);
				 int startDay = ValuesGenerator.getRandomIntBetween(random, -3, 27);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear = ValuesGenerator.getRandomIntBetween(random, 1, 260);

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
				 day.addAppt(appt);
				 if(!appt.getValid())continue;
				 for (int i = 0; i < NUM_TESTS; i++) {
					 String methodName = ApptRandomTest.RandomSelectMethod(random);
					 if (methodName.equals("setTitle")){
						 String newTitle=(String) ValuesGenerator.getString(random);
						 appt.setTitle(newTitle);
					 }
					 else if (methodName.equals("setRecurrence")){
						 int[] recurDays = null;

						 if(i != 0) {
							 int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
							 recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
						 }

						 int recur=ApptRandomTest.RandomSelectRecur(random);
						 int recurIncrement = ValuesGenerator.RandInt(random);
						 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					 }

					 day.addAppt(appt);
				 }

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");
	 }
}

//package calendar;
//
//
//		import org.junit.Test;
//
//
//		import java.util.Calendar;
//		import java.util.GregorianCalendar;
//		import java.util.Random;
//
//		import static org.junit.Assert.*;
//
//
//
///**
// * Random Test Generator  for CalDay class.
// */
//
//public class CalDayRandomTest {
//	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
//	private static final int NUM_TESTS=100;
//
//	/**
//	 * Generate Random Tests that tests CalDay Class.
//	 */
//	@Test
//	public void radnomtest()  throws Throwable  {
//		long startTime = Calendar.getInstance().getTimeInMillis();
//		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
//
//
//		System.out.println("Start testing...");
//
//		try{
//			CalDay day = null;
//			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
//
//				long randomseed =System.currentTimeMillis(); //10
//				//			System.out.println(" Seed:"+randomseed );
//				Random random = new Random(randomseed);
//
//				GregorianCalendar calendar = new GregorianCalendar(
//						ValuesGenerator.getRandomIntBetween(random,-1000, 10000),
//						ValuesGenerator.getRandomIntBetween(random,-10, 40),
//						ValuesGenerator.getRandomIntBetween(random,-10, 40));
//
//				if(day == null)
//					day = new CalDay(calendar);
//
//				int startHour=ValuesGenerator.RandInt(random);
//				int startMinute=ValuesGenerator.RandInt(random);
//				int startDay=ValuesGenerator.RandInt(random);;
//				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
//				int startYear=ValuesGenerator.RandInt(random);
//				String title="Birthday Party";
//				String description="This is my birthday party.";
//				//Construct a new Appointment object with the initial data
//				Appt appt = new Appt(startHour,
//						startMinute ,
//						startDay ,
//						startMonth ,
//						startYear ,
//						title,
//						description);
//				day.addAppt(appt);
//				if(!appt.getValid())continue;
//				for (int i = 0; i < NUM_TESTS; i++) {
//					String methodName = ApptRandomTest.RandomSelectMethod(random);
//					if (methodName.equals("setTitle")){
//						String newTitle=(String) ValuesGenerator.getString(random);
//						appt.setTitle(newTitle);
//					}
//					else if (methodName.equals("setRecurrence")){
//						int[] recurDays = null;
//
//						if(i != 0) {
//							int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
//							recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
//						}
//
//						int recur=ApptRandomTest.RandomSelectRecur(random);
//						int recurIncrement = ValuesGenerator.RandInt(random);
//						int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
//						appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
//					}
//
//					day.addAppt(appt);
//				}
//
//				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
//				if((iteration%10000)==0 && iteration!=0 )
//					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
//
//			}
//		}catch(NullPointerException e){
//
//		}
//
//		System.out.println("Done testing...");
//	}
//}
