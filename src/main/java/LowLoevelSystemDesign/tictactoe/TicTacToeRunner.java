package LowLoevelSystemDesign.tictactoe;

import java.util.Scanner;

public class TicTacToeRunner {

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    System.out.println("Starting Tic Tac Toe, Please Select Mode:");
    System.out.println("1) Player Vs Player");
    System.out.println("2) Player Vs Computer");
    System.out.println("3) Computer Vs Computer");
    //final int choice = sc.nextInt();
    final int choice = 1;
    if (choice == 1) {
      System.out.println("Playing Mode 1) Player Vs Player");
    } else if (choice == 2) {
      System.out.println("Playing Mode 2) Player Vs Computer");
    } else {
      System.out.println("Playing Mode 1) Computer Vs Computer");
    }
    getInputDetails(sc, choice);
  }

  /**
   * @param scanner to take inputs form console
   * @param choice  is Game Mode
   */
  private static void getInputDetails(final Scanner scanner, int choice) {
    String player1Name = "Ajay", player2Name = "Deep", player1Symbol = null, player2Symbol = null;
    System.out.println("Enter Tic Tac Toe Board Size :");
    final int boardSize = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter Player-1 Name:");
    //player1Name = scanner.nextLine();
    System.out.println("Choose Symbol Either O Or X:");
    player1Symbol = "X";
    //player1Symbol = scanner.nextLine();
    if (choice == 1) {
      System.out.println("Enter Player-2 Name:");
      //player2Name = scanner.nextLine();
      if (player1Symbol.equals("X")) {
        player2Symbol = "O";
      } else {
        player2Symbol = "X";
      }
    }
    Player[] players = initBoardPlayer(player1Name, player2Name, player1Symbol.charAt(0),
        player2Symbol.charAt(0));
    TicTacToeGameBoard gameBoard = new TicTacToeGameBoard(boardSize, players, scanner);
    gameBoard.initGame();
  }

  public static Player[] initBoardPlayer(String player1Name, String player2Name, char player1Symbol,
      char player2Symbol) {
    final Player player1 = getPlayer(player1Name, player1Symbol);
    final Player player2 = getPlayer(player2Name, player2Symbol);
    return new Player[]{player1, player2};
  }

  private static Player getPlayer(String playerName, char playerSymbol) {
    Player player = new Player();
    if (!playerName.isEmpty() && playerSymbol != ' ') {
      player.setPlayerName(playerName);
      player.setPlayerSymbol(playerSymbol);
      return player;
    }
    return player;
  }

}
