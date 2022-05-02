package LowLoevelSystemDesign.tictactoe;

import static java.lang.Math.abs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToeGameBoard {

  private final int[] rowSum, colSum;
  private int diagSum, revDiagSum;
  private final int boardSize;
  private final Scanner scanner;
  private final char[][] gameBoard;
  private final Queue<Player> playerQueue;

  public TicTacToeGameBoard(final int boardSize, final Player[] players, final Scanner scanner) {
    this.rowSum = new int[boardSize];
    this.colSum = new int[boardSize];
    this.scanner = scanner;
    this.boardSize = boardSize;
    this.gameBoard = new char[boardSize][boardSize];
    this.playerQueue = new LinkedList<>();
    playerQueue.offer(players[0]);
    playerQueue.offer(players[1]);
  }


  public void initGame() {
    int count = 0;

    while (true) {
      count++;
      if (count == ((boardSize * boardSize) + 1)) {
        System.out.println("Match Draw");
        break;
      }
      Player player = playerQueue.poll();
      int boardPosition = getPlayerInput(player);
      int row = (boardPosition % boardSize == 0 ? (boardPosition / boardSize) - 1
          : (boardPosition / boardSize));
      int col = ((boardPosition % boardSize == 0 ? boardSize : boardPosition % boardSize) - 1);
      gameBoard[row][col] = player.getPlayerSymbol();
      System.out.println("Game Board After Move:");
      printBoard();
      //checkIfGameEnded(player, row, col);
      if (checkIfGameEnded(player, row, col)) {
        break;
      }
      playerQueue.offer(player);
    }
  }

  private boolean checkisEndGame(Player player, int row, int col) {
    String winString = "";
    for (int i = 0; i < boardSize; i++) {
      winString += String.valueOf(player.getPlayerSymbol());
    }

    StringBuilder rowString = new StringBuilder();
    StringBuilder colString = new StringBuilder();
    StringBuilder diagonalString = new StringBuilder();
    StringBuilder revDiagonalString = new StringBuilder();

    for (int i = 0; i < gameBoard.length; i++) {
      rowString.append(gameBoard[row][i]);
      colString.append(gameBoard[i][col]);
      if (row == col) {
        diagonalString.append(gameBoard[i][i]);
      }
      if ((row + col) == gameBoard.length - 1) {
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

  private boolean checkIfGameEnded(Player player, int row, int col) {
    int val = player.getPlayerSymbol() == 'X' ? -1 : 1;
    rowSum[row] += val;
    colSum[col] += val;
    if (row == col) {
      diagSum += val;
    }
    if (row == boardSize - 1 - col) {
      revDiagSum += val;
    }
    if (abs(rowSum[row]) == boardSize || abs(colSum[col]) == boardSize || abs(diagSum) == boardSize
        || abs(revDiagSum) == boardSize) {
      System.out.println(player.getPlayerName() + " has won the Game Hurray !!");
      return true;
    }
    return false;
  }

  private void printBoard() {
    for (char[] row : gameBoard) {
      for (char col : row) {
        System.out.print(col);
      }
      System.out.println();
    }
  }

  private int getPlayerInput(Player player) {
    System.out.println(player.getPlayerName() + " Enter Move Position btw 1-" + (boardSize * boardSize));
    int move = scanner.nextInt();
    while (!validate(move)) {
      System.out.println(
          "Wrong Position :" + player.getPlayerName() + " Please enter a valid Move Position btw 1-" + (
              boardSize * boardSize));
      move = scanner.nextInt();
    }
    return move;
  }

  private boolean validate(int move) {
    if (move < 1 || move > (boardSize * boardSize)) {
      return false;
    }
    int row = (move % boardSize == 0 ? (move / boardSize) - 1 : (move / boardSize));
    int col = ((move % boardSize == 0 ? boardSize : move % boardSize) - 1);
    if ((int) gameBoard[row][col] != 0) {
      return false;
    }
    return true;
  }
}
