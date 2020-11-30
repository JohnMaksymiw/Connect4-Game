public class newBoard{

//Fields

public char [][] grid; // a variable to point to a board

//Methods

//Mutator

private void createBoard(){ // a mutator to create the board we require


this.grid = new char[][] 

{{'.','.','.','.','.','.','.'},
{'.','.','.','.','.','.','.'},
{'.','.','.','.','.','.','.'},
{'.','.','.','.','.','.','.'},
{'.','.','.','.','.','.','.'},
{'.','.','.','.','.','.','.'},
{'1','2','3','4','5','6','7'}};

}


//Mutator

public void placeCounter(int inputPosition, char counterColour){

int position = inputPosition - 1; //-1 because the grid array reference is 0 - 6 whereas our board reference is 1 - 7

outerloop: 

			for(int i = this.grid.length-1; i>=0; i--){

					if(this.grid[i][position] == counterColour && (this.grid[i][position] != counterColour && this.grid[i][position]!='.')){ // starting from the bottom of the board going upwards, check to make sure that each position does not equal a char or a . char

						// skip

					}

					else if(this.grid[i][position] == '.'){

						this.grid[i][position] = counterColour; // if a position on the grid does equal '.' then insert our character

            break outerloop;

					}
          
				}
        
      }

      //Accessor

public void printBoard(){

  for (char[] row : this.grid){

    for(char c : row){

      System.out.print(c);

    }

    System.out.println();

  }

  System.out.print("\n");

}



public int[] checkSpace(){ // a method to return a list of ints relating to the number of filled spacec

  int[] numberList = new int[7];

    for(int l = 1; l <= 7; l++){

      if(this.grid[0][l-1] != '.'){ //-1 so that each reference correspeconds to the 0-6 reference of the grid

        numberList[l]=l;

      }

    }

  return numberList;

}

  
  //Constructor

  public newBoard(){ 

    createBoard();

  }

      
  }




