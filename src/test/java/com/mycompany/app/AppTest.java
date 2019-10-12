package com.mycompany.app;
import java.util.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    /*
    public void testResult(){
    	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
	ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(3,3,4,5,6,7,8,9,10));

	assertTrue(new App().myMethod(array1,array2, 5,4) );
    }*/



}
