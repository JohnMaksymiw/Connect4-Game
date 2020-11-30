import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  
  public static void main(String[] args) throws IOException {

    System.out.print("\nPlease enter the number of CPU players you would like to play against:\n\n");

    humanPlayer newHumanPlayer = new humanPlayer('r',false); //create a human player object

    player player = new player(' ',false); //create player object. this is required so we do not have to check the hasWon field for each player, and it will also store the array holding the CPUPlayers objects

    player.NPlayers(); // asks the user how many CPU players they want to play against

    newBoard newBoard2 = new newBoard(); //constructor for a new board
    
    newBoard2.printBoard(); //prints a board to show to the human user where to insert a slot

   while (player.hasWon == false){ // checks to see if a player has won yet. if they haven't then we continue play

     newHumanPlayer.humanChoice(); //asks the user to input a column number

     if(newHumanPlayer.input!=0){ //guard

       if(newHumanPlayer.input<=0 ||   newHumanPlayer.input >7 ){ //guard

         System.out.print("Invalid input\n");

         }

         else{
           

          newBoard2.placeCounter(newHumanPlayer.input,newHumanPlayer.counterColour); //inserts a counter
          newHumanPlayer.checkWin(newHumanPlayer.counterColour,newBoard2.grid, player); //checks if there is a winner
          newBoard2.printBoard(); //prints board to show placement

          System.out.print("CPU turn:\n");

          for(int NPlayer = 1; NPlayer <= player.N; NPlayer ++ ){ // loops through each CPUPlayer object

          String Name = Integer.toString(NPlayer)+"CPUPlayer";

          newBoard2.placeCounter(player.myMap.get(Name).CPUChoice(newBoard2.checkSpace()),player.myMap.get(Name).counterColour);//places counter
          player.myMap.get(Name).checkWin(player.myMap.get(Name).counterColour,newBoard2.grid,player); // checks win

          System.out.print("\n" + Name + " turn:\n");

          newBoard2.printBoard(); //prints board

          }
     
        }

      }

    }

  }

}



