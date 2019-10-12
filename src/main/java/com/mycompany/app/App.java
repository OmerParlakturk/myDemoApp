package com.mycompany.app;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
   
   public static boolean myMethod(ArrayList<Integer> a1, ArrayList<Integer> a2, int i1, int i2)
/* this method check the sum of first i1 elements in array a1 and compare to sum of i2 elements in array a2, if the sum will be equal then it returns true*/
   {
	if(a1 == null)
	return false;
	
	if(a2 == null)
	return false;

	if(a1.size() == 0)
	return false;

	if(a2.size() == 0)
	return false;

	int tempSum1 = 0;
	int tempSum2 = 0;

	for(int i = 0 ; i< i1 ; i++){
	        tempSum1 = a1.get(i);
	}
	for(int i = 0 ; i< i2 ; i++){
		tempSum2 = a2.get(i);
	}

	return (tempSum1 == tempSum2);

   }
   public static void main( String[] args )
   {
	System.out.println( "Hello World" );
   }
}