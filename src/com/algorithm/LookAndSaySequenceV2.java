//*********************************************************************************************
// Assignment: Program to print a series of Look and Say Sequence with given start value and number of series to be printed
//
// Author: ADHEEP M
//
// Completion time: 40 mins
//
// Honor Code:	I pledge that this program represents my own program code and 
//				I received help from no one in designing and debugging my program.
//**********************************************************************************************

package com.algorithm;

/**
 * LookAndSaySequenceV2 to print a series of Look and Say Sequence with given start value and number of series to be printed
 * 
 * @author adheep@ymail.com
 * @Created 13-06-2014 7:03:40 PM
 */
public class LookAndSaySequenceV2 {
	
	/**
	 * Execute the getNextSequence with a given series
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		printLookAndSaySequence("1",20);
	}

	/**
	 * printLookAndSequence method accepts a starting Number and number of series to be printed
	 * 
	 * @param startNumber
	 * @param iterationCount
	 */
	public static void printLookAndSaySequence(String startNumber, long iterationCount) {
		String nextSequence = startNumber;
		System.out.println(nextSequence);
		
		//Iterate till the number specified in the iterationCount
		for(int i=0;i<iterationCount;i++) {
			nextSequence = getNextSequence(nextSequence);
			System.out.println(nextSequence);
		}
	}
	
	/**
	 * getNextSequence method will accept a series(string) and return the next value in the Look and Say sequence
	 * 
	 * @param number
	 * @return
	 */
	public static String getNextSequence(String number) {
		StringBuffer nextNumber = new StringBuffer();
		try {
			//Initialize the count variable which tracks the number of char iterated
			int count = 0;
			
			//Initialize the times variable which tracks the number of times the same value occurs in sequence
			int times = 0;
			
			//Initialize the previousElement which stores the previous char value
			char previousElement = 0;
			
			//Convert string to char array
			char array[] = number.toCharArray();
			
			//Iterate through each char in the char array
			for(char element: array) {
					
					//Check if the count is less than the array length
					if(count+1 < array.length) {
						
						//Check if the count value is non zero
						if(count!=0) {
							
							//Check if the previous element and current element are equal
							if(previousElement == element) {
								times++;
							} else {
								nextNumber.append(times);
								nextNumber.append(previousElement);
								times = 1;
								previousElement = element;
							}
						} else {
							previousElement = element;
							times++;
						}
					} else {
						
						//Check if the count value is non zero
						if(count!=0) {

							//Check if the previous element and current element are equal
							if(previousElement == element) {
								times++;
								nextNumber.append(times);
								nextNumber.append(previousElement);
							} else {
								nextNumber.append(times);
								nextNumber.append(previousElement);
								times = 1;
								nextNumber.append(times);
								nextNumber.append(element);
							}
						} else {
							times = 1;
							nextNumber.append(times);
							nextNumber.append(element);
						}
					}
					count++;
			}
			
		} catch (Exception exception) {
			System.out.println(exception);
		}
		
		return nextNumber.toString();
		
	}

}
