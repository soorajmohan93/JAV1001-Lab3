/*
***************************************************************
      JAV-1001 App Development for Android
      JAV1001-Lab3 - Classes and Objects
      Submitted by Sooraj Mohan (Student ID: A00247480)
***************************************************************
*/

import java.util.Scanner;                       //to use scanner class object to capture user inputs
import java.util.InputMismatchException;        //to handle input invalid int user entry

public class diceGame
{
  public static void main(String[] args)
  {
    Scanner entry = new Scanner(System.in);        // Scanner object

    // App welcome message
    System.out.println("-----------------------------------------------------------------------------");
    System.out.println("                             LAB 3:  Class and Objects");
    System.out.println("                                      Dice Game");
    System.out.println("-----------------------------------------------------------------------------");

//do-while block to reuse the application if user chooses to
    do
    {
//try-catch block for input exceptions
      try
      {

//variable to hold user entry for number of sides
        int userSideEntry = 0;

// first die object (default d6)
        Die firstDie = new Die();
        System.out.println("\nCreating a default " + firstDie.getDieType() + "...");

//second die object, default d20 - user has an option to change the number of sides
        Die secondDie = new Die(20);
        System.out.println("\nCreating a " + secondDie.getDieType() + "... ");
// user choice to change the number of sides
        System.out.print("Do you want to change the number of sides for this die? (Y/N): ");
        if (userChoice() == 'Y')
        {
//number of sides input
          System.out.print("Please enter number of Sides: ");
          userSideEntry = entry.nextInt();
          entry.nextLine();
// using mutators to set the sides of die and die type
          secondDie.setDice(userSideEntry);
          System.out.println("Changing the Die to " + secondDie.getDieType() + "...");
        }

// third die default - Percentile die

        Die thirdDie = new Die("Percentile", 10);
        System.out.println("\nCreating a " + thirdDie.getDieType() + " Die (a special D10)...\n");

//fetching the starting side of each die
        firstDie.rollthisDie();
        System.out.println("The current side up for " + firstDie.getDieType() + " is " + firstDie.getSideUp());
        secondDie.rollthisDie();
        System.out.println("The current side up for " + secondDie.getDieType() + " is " + secondDie.getSideUp());
        thirdDie.rollthisDie();
        System.out.println("The current side up for " + thirdDie.getDieType() + " is " + thirdDie.getSideUp());

        //calling Roll Methods

        System.out.println("\nTesting the Roll Method");

//calling roll methods for first die. Die type and the side up is fetched using accessors
        System.out.println("Rolling the " + firstDie.getDieType() + "....");
        firstDie.rollthisDie();
        System.out.println("New side of " + firstDie.getDieType() + " is " + firstDie.getSideUp());
//calling roll methods for second die. Die type and the side up is fetched using accessors
        System.out.println("Rolling the " + secondDie.getDieType() + "....");
        secondDie.rollthisDie();
        System.out.println("New side of " + secondDie.getDieType() + " is " + secondDie.getSideUp());
//calling roll methods for thrid die. Die type and the side up is fetched using accessors
        System.out.println("Rolling the " + thirdDie.getDieType() + "....");
        thirdDie.rollthisDie();
        System.out.println("New side of " + thirdDie.getDieType() + " is " + thirdDie.getSideUp());


//making the second die to show the highest possible value

        System.out.println("\nSetting the " + secondDie.getDieType() + " to show " + secondDie.getnofSide() + "....");
//int variable nofTries to hold the number of tries used to reach the value
        int nofTries = 0;
//roll of die happens when the current side up is not equal to number of sides of the die
        while(secondDie.getSideUp() != secondDie.getnofSide())
        {
          secondDie.rollthisDie();
          nofTries++;
        }
        System.out.println("The side is now " + secondDie.getnofSide() + " with " + nofTries + " tries. Yay!!");

//Yahtzee game code

        System.out.println("\n-----");
        System.out.println("BONUS");
        System.out.println("-----");
        System.out.println("Creating five D6 dices....");

//using Array of class objects to use for the game
        Die[] yahtzeeDice = new Die[5];
//boolean is used to determine Yahtzee
        boolean yahtzee = false;

//initializing the array of five dice
        for(int index = 0; index < yahtzeeDice.length; index++)
        {
          yahtzeeDice[index] = new Die();
        }

// variable j is used to count the number of rolls
        int j = 0;
//keep looping until Yahtzee
        while(yahtzee == false)
        {
//rolls all five dice
          for(int index = 0; index < yahtzeeDice.length; index++)
          {
            yahtzeeDice[index].rollthisDie();
          }
//code to check if all five dices have same value
          for(int index = 0; index < yahtzeeDice.length-1; index++)
          {
            if (yahtzeeDice[index].getSideUp() != yahtzeeDice[index+1].getSideUp())
            {
// if the values are not same the yahtzee is kept false and loop is stopped
              yahtzee = false;
              break;
            }
            else
            {
//if the values are same, then Yahtzee is marked true but the loop is not stopped to check further dices
              yahtzee = true;
            }
          }
          j++;
        }
//while loop will be stopped only when Yahtzee is reached, variable j will have the number of rolls
        System.out.println("Yahtzee!! It took " + j + " rolls.");

      }
      catch (InputMismatchException ex)   //exception handling for invalid integer inputs
      {
        entry.nextLine();
        System.out.println("Invalid entry. Please rerun the application");
      }
      //choice for user to rerun the application
      System.out.print("Do you want to run the application again? (Y/N): ");
    }while(userChoice() == 'Y');
    //Application closing message
    System.out.println("********Thank you. Application will close now.*********");
  }

//below method is used to collect user choices to continue
  public static char userChoice()
  {
    Scanner entry = new Scanner(System.in);        // Scanner object

    String userOpt = entry.next();
    //input from user is captured into String variable userOpt and set to upper case which helps in the if statements
    userOpt = userOpt.toUpperCase();
    //First character of the String is passed into char variable optRerun
    char optChar = userOpt.charAt(0);
    entry.nextLine();
    //Fallback for invalid entry - keeps looping until user enters Y or N.
    while (optChar != 'Y' && optChar != 'N')
    {
      System.out.print("Invalid Input - Kindly enter Y/N to proceed: ");
      userOpt = entry.next();
      userOpt = userOpt.toUpperCase();
      optChar = userOpt.charAt(0);
      entry.nextLine();
    }
    return optChar;
  }



}
