import java.util.Scanner;// To enable inputing string

public class Question1 {
  public static void main(String[] args) {
    String[][] input = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}}; // defining the default array
    game(input); // initiates the method
  }

  public static void game(String input[][]) {
	  
    boolean finished = false; // initialization of variable that determines whether game is over
    int inputx = 0; // variable for row input
    int inputy = 0; // variable for column input
    Scanner reader = new Scanner(System.in); // initializes the user input
    
	int turn = 0; // int variable used to determine whose turn it is
    
	String player = "X"; // variable for player, used to determine whose turn it is and to print x
                         // or o to the console
    while (finished == false) {
      if (turn % 2 == 0) { // value of turn in mod 2 is used to switch between x and o
        player = "X";
      } else {
        player = "O";
      }
      print(input); // method that print the grid out is initiated
      System.out.println("Enter a row for player " + player + ":"); // row asked
      
	  inputx = reader.nextInt() - 1; // row value saved
      
	  System.out.println("Enter a column for player " + player + ":"); // column asked
      
	  inputy = reader.nextInt() - 1; // column value saved
      
	  if (input[inputx][inputy] == " ") { // x or o is added to cell unless the cell was already
                                          // filled
        input[inputx][inputy] = player; // inputs x or o to the cell
        turn++; // increases the turn value, thus switches between x and o
        finished = gamecheck(input); // initiates the method that checks whether game is over
      } else {
        System.out.println("Cell is not empty, try again"); // error message printed id the cell
                                                            // wasn't empty
      }
    }
  }

  public static boolean gamecheck(String input[][]) {
    boolean finished = false; // initialization of variable that determines whether game is over
    for (int a = 0; a < 3; a++) {
      if (input[a][0] == input[a][1] && input[a][1] == input[a][2] && input[a][2] != " ") { // checks whether the values in the row are all Xs or Os, thus checks whether there is a winner
        finished = true; // game is finished
        print(input); // updated version of the grid is printed
        System.out.println(input[a][0] + " player won"); // prints the winning player
      } else if (input[0][a] == input[1][a] && input[2][a] == input[1][a] && input[a][2] != " ") { // checks whether the values in the column are all Xs or Os, thus checks whether there is a winner
        finished = true; // game is finished
        print(input); // updated version of the grid is printed
        System.out.println(input[a][0] + " player won");// prints the winning player
      } else if ((input[0][0] == input[1][1] && input[1][1] == input[2][2] && input[1][1] != " ")
          || (input[0][2] == input[1][1] && input[1][1] == input[2][0] && input[1][1] != " ")) { // checks whether the values in the diagonals are all Xs or Os, thus checks whether there is a winner
                                                                                                 
        finished = true;// game is finished
        print(input); // updated version of the grid is printed
        System.out.println(input[1][1] + " player won");// prints the winning player
      }
    }
    return finished; // finished is returned back to the main method
  }

  public static void print(String input[][]) {
	  
    System.out.println("-------------"); // prints the first line of dashes
    for (int a = 0; a < 3; a++) {
      for (int b = 0; b < 3; b++) {
        System.out.print("|  " + input[a][b]); // prints all the values, separated by |
      }
      System.out.print("|");
      System.out.println("\n-------------"); // prints the last lane of dashes
    }
  }
}
