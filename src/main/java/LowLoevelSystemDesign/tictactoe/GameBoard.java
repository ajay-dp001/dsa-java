package LowLoevelSystemDesign.tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {

  private final int boardSize;
  private final char[][] gameBoard;
  private final Scanner playerInput;
  private final Queue<Player> playerQueue;

  public GameBoard(int boardSize, Player[] players) {
    this.boardSize = boardSize;
    this.gameBoard = new char[(2 * boardSize) - 1][(2 * boardSize) - 1];
    initGameBoard(gameBoard);
    playerQueue = new LinkedList<>();
    playerQueue.offer(players[0]);
    playerQueue.offer(players[1]);
    playerInput = new Scanner(System.in);
  }

  /**
   * Game Board design | | -+-+- | | -+-+- | |
   */
  private void initGameBoard(char[][] gameBoard) {
    for (int i = 0; i < gameBoard.length; i++) {
      for (int j = 0; j < gameBoard[0].length; j++) {
        if (i % 2 == 0 && j % 2 == 0) {
          gameBoard[i][j] = '|';
        }
        if (i % 2 != 0 && j % 2 == 0) {
          gameBoard[i][j] = '-';
        }
        if (i % 2 != 0 && j % 2 != 0) {
          gameBoard[i][j] = '*';
        }
      }
    }
  }

  private void printBoard() {
    for (char[] row : gameBoard) {
      for (char col : row) {
        System.out.print(col);
      }
      System.out.println();
    }
  }

  public void beginGame() {
    int count = 0;
    while (true) {
      count++;
      if (count == ((boardSize * boardSize) + 1)) {
        System.out.println("Match Draw");
        break;
      }

      Player player = playerQueue.poll();
      int boardPosition = getPlayerInput(player);
      int rowPosition = 2 * ((boardPosition % boardSize == 0) ? (boardPosition / boardSize) - 1
          : boardPosition / boardSize);
      int columnPosition = 2 * ((boardPosition % boardSize == 0 ? boardSize : boardPosition % boardSize) - 1);
      gameBoard[rowPosition][columnPosition] = player.getPlayerSymbol();
      System.out.println("Game Board After Move:");
      printBoard();
      if (count > boardSize && checkisEndGame(player, rowPosition, columnPosition)) {
        break;
      }
      playerQueue.offer(player);
    }
  }

  private boolean checkisEndGame(Player player, int rowPosition, int columnPosition) {
    String winString = "";
    for (int i = 0; i < boardSize; i++) {
      winString += String.valueOf(player.getPlayerSymbol());
    }

    StringBuilder rowString = new StringBuilder();
    StringBuilder colString = new StringBuilder();
    StringBuilder diagonalString = new StringBuilder();
    StringBuilder revDiagonalString = new StringBuilder();

    for (int i = 0; i < gameBoard.length; i += 2) {
      rowString.append(gameBoard[rowPosition][i]);
      colString.append(gameBoard[i][columnPosition]);
      if (rowPosition == columnPosition) {
        diagonalString.append(gameBoard[i][i]);
      }
      if ((rowPosition + columnPosition) == gameBoard.length - 1) {
        revDiagonalString.append(gameBoard[gameBoard.length - 1 - i][i]);
      }
    }

    if (winString.equals(rowString.toString()) || winString.equals(colString.toString()) || winString.equals(
        diagonalString.toString())
        || winString.equals(revDiagonalString.toString())) {
      System.out.println(player.getPlayerName() + " has won the Game Hurray !!");
      return true;
    }
    return false;
  }

  private int getPlayerInput(Player player) {
    System.out.println(
        player.getPlayerName() + " Please Enter Move Position btw 1-" + (boardSize * boardSize));
    int move = playerInput.nextInt();
    while (validateInput(move)) {
      System.out.println("Wrong Position - " + player.getPlayerName() +
          " Please Enter a valid Move Position btw 1-" + (boardSize * boardSize));
      move = playerInput.nextInt();
    }
    return move;
  }

  private boolean validateInput(int move) {
    if (move < 1 || move > (boardSize * boardSize)) {
      return false;
    }
    int row = 2 * ((move % boardSize == 0) ? (move / boardSize) - 1 : move / boardSize);
    int col = 2 * ((move % boardSize == 0 ? boardSize : move % boardSize) - 1);
    if ((int) gameBoard[row][col] != 0) {
      return false;
    }
    return true;
  }
}
