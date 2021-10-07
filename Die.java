/*
***************************************************************
      JAV-1001 App Development for Android
      JAV1001-Lab3 - Classes and Objects
      Submitted by Sooraj Mohan (Student ID: A00247480)
***************************************************************
*/

import java.util.Random;                        //to generate Random integers



public class Die
{
  // String to store the type of die (like D6, D20, etc)
  private String dieType;
  //int to store number of Sides
  private int nofSides;
  // int to store current side up
  private int sideUp;

// constructor with no arguments (default d6)
  public Die()
  {
    this.dieType = "D6";
    this.nofSides = 6;
  }

//constructor with one arguments (default d20)
  public Die(int nofSides)
  {
    this.dieType = "D" + nofSides;
    this.nofSides = nofSides;
  }

//constructor with two arguments (default d10 - Percentile)
  public Die(String dieType, int nofSides)
  {
    this.dieType = dieType;
    this.nofSides = nofSides;
  }

//mutators set number of Sides and Die type
  public void setDice(int nofSides)
  {
    this.nofSides = nofSides;
    this.dieType = "D" + nofSides;
  }

//accessors for number of side
  public int getnofSide()
  {
    return nofSides;
  }

//accessors for type of die
  public String getDieType()
  {
    return dieType;
  }

//accessors for current side up
  public int getSideUp()
  {
    return sideUp;
  }

//method to roll die
  public void rollthisDie()
  {
    Random rand = new Random();
    sideUp = rand.nextInt(nofSides)+1;

    if (dieType.equals("Percentile"))
    {
      sideUp *= 10;
    }
  }
}
