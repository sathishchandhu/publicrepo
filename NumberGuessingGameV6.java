package com.test.games;

import java.util.Scanner;
/**
 * 
 * @author SChandu
 * 
 */
public class NumberGuessingGameV6 {

	public static void main(String args[])
	{	
		int upper_limit=1000;
		int lower_limit=0;
		String temp=null; 
		int prevLower=lower_limit;
		
		 boolean navH=false,navL=false;
		
		//get a random guess between lower and higher limit
		 int numberToGuess =(int) (lower_limit + Math.random()*((upper_limit-lower_limit+1)) );
		 int seedCopy=numberToGuess;
		 
		info("Welcome to Play a Number-guessing game");
		info("Guess a number between 1 and 1000");
		info("***Type 'ready' to begin the game / 'Yes' or 'End' to Finish the Game***");
		
		
		//decl scanner
		Scanner kbinput = new Scanner(System.in);
		
		
	
		info("Is the number: "+numberToGuess);
		info("If Yes, type 'end' or 'yes';if not Type either 'higher' or 'lower're to proceed with guess");
		
		 temp=kbinput.nextLine(); 
		
		 //if it is not yes or end
		 if(!temp.equalsIgnoreCase("yes") 
				|| !temp.equalsIgnoreCase("end") )
		 {
			
		
			 
			while(temp.equalsIgnoreCase("higher") || temp.equalsIgnoreCase("lower"))
			{
				
				if(temp.equalsIgnoreCase("higher") && (numberToGuess !=0))
				{
					info("inside higher");
					
					//if you were in lower before, use that
					if(navL)
					{
						upper_limit=prevLower;
						navL=false;
					}
					//get the next guess
					numberToGuess=(upper_limit+numberToGuess)/2;					
					navH=true;			
					
					
				}
				else if(temp.equalsIgnoreCase("lower") && (numberToGuess !=0))
				{
					
				
					//if you were in higher before , reset lower & upper limit
					//this will limit the boundaries
					if(navH)
					{
						lower_limit=upper_limit=seedCopy;
						navH=false;						
					}
					
					prevLower=numberToGuess;
					//get the next guess
					numberToGuess=(lower_limit+numberToGuess)/2;
				    navL=true;
					
				}
				
				info("Is the number: "+numberToGuess);
				
				temp=kbinput.nextLine();
			}
			
		}
		else
		{
			info("Number guessed is: "+numberToGuess);
			info("Thanks for playing the game");
		}
		 
		 info("***Thanks***");
		 kbinput.close();
	}
	
	 
	  static void info(String msg)
	  {
		  System.out.println(msg);
	  }
	  
	  
}
