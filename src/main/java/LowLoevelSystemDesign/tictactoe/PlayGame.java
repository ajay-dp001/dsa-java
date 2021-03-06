package LowLoevelSystemDesign.tictactoe;

public class PlayGame {

  public static void main(String[] args) {
    Player player1 = new Player();
    player1.setPlayerId(1);
    player1.setPlayerName("Aj");
    player1.setPlayerRanking(1);
    player1.setPlayerSymbol('X');

    Player player2 = new Player();
    player2.setPlayerId(2);
    player2.setPlayerName("Dp");
    player2.setPlayerRanking(2);
    player2.setPlayerSymbol('O');

    Player[] players = new Player[]{player1, player2};

    GameBoard gameBoard = new GameBoard(3, players);
    gameBoard.beginGame();
  }
}
