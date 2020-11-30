import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.TreeMap;

public class player{

//Fields

public int N; // a variable to point to the number of computer players scecified by the user to play against

public TreeMap<String,CPUPlayer> myMap = new TreeMap<String,CPUPlayer>(); 

public char counterColour; 

public boolean hasWon; // this will be checked by an accessor method to see if a player has won yet


//Methods

//Accessor


public void checkWin(char c, char[][] board, player player){ //a method that each player will have to check if they have won. The arguments are the counter colour of the player in question, the board at that moment in time, and a player object so that the hasWon variable can be switched to true if the player has won

int count = 0; // reset count

// check horizontal

for(int i=0; i < board.length; i++){

					for(int j=0; j<board[i].length; j++){

						if(board[i][j] == c ){

							count = count + 1;

							if(count >= 4){

								player.hasWon = true; // switch 

                System.out.print("Player has won!\n");

							}

            }

            else {

              count = 0; // reset the count for the next column

            } 

				  }

          count = 0; //reset the count for the vertical check

        }

				// check vertical 

				for(int i=0; i<board[0].length; i++){

					for(int j=0; j<board.length; j++){

						if(board[j][i] == c){

							count = count + 1;

							if(count >= 4){

								player.changeWin();

                System.out.print("Player has won!\n");

							}

						}

            else {

              count = 0;

            }

					}

           count = 0;
					
				}

        //check diagonal up 

        for(int a = 3; a < board.length; a++){ // 3 because a diagonal cannot extend out of the board

			    for(int b = 0; b < board[0].length - 3; b++){ //-3 because a diagonal cannot extend out of the board
				
            if (board[a][b] == c && board[a-1][b+1] == c && board[a-2][b+2] == c && board[a-3][b+3] == c){ // check to see if a diagonal from a fixed point has the same characters
					
            player.changeWin();

                System.out.print("Player has won!\n");

				}
			}
		}

		//check diagonal down 

		for(int a = 0; a < board.length - 3; a++){

			for(int b = 0; b < board[0].length - 3; b++){

				if (board[a][b] == c && board[a+1][b+1] == c && board[a+2][b+2] == c && board[a+3][b+3] == c){
				
        player.changeWin();

                System.out.print("Player has won!\n");

				}

			}

		}

  }

//Mutator

public void changeWin(){ //used to access player 

  this.hasWon = true; 

}

public void NPlayers() throws IOException{

    char[] charArray = {'a','b','c','d','e','f','g','h','i','j','k','l'}; // an array to hold chars to be used for each CPUPLayer

    BufferedReader NInput;

	  NInput = new BufferedReader(new InputStreamReader(System.in));

    String input = NInput.readLine();

    int v = 0;

    try { //guard for false inputs
      
      v = Integer.parseInt(input);
        
        }

    catch(Exception e) {

      System.out.print("Invalid input");

    }  

    this.N = v; //store the input in N so that it can be used bu newBoard class
   
    for (int j = 1; j <= v; j++ ){ //loop to create players

    String newName = Integer.toString(j)+"CPUPlayer"; // create a string name for each CPUPLayer

    this.myMap.put(newName, new CPUPlayer(charArray[j],false)); //add each new CPUPlayer to an array map using their name as the key
    
    }

  }

//Constructor

public player(char counterColour, boolean hasWon){

  this.hasWon = hasWon; 

};

}








