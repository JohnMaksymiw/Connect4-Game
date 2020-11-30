import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class humanPlayer extends player{   

  //Fields

  int input; // a variable to point to the input int that the user inserted

  //Methods

  public void humanChoice() throws IOException {
  
    System.out.print("Welcome human player, please select a column between 1 and 7:\n");

    BufferedReader userInput;

	  userInput = new BufferedReader(new InputStreamReader(System.in));

    String input = userInput.readLine();

    System.out.print("\nThank you\n\n");

    int i = 0;

    try { //guard
      
      i = Integer.parseInt(input);
      
        
        }

    catch(Exception e) {

      System.out.print("Invalid input\n");

    }   

   this.input = i;   

  }; //returns a value to be used by each player 

//Constructor

public humanPlayer(char counterColour, boolean hasWon){
  super(counterColour,hasWon);

  this.counterColour = counterColour;
  this.hasWon = hasWon;

}

}