package LowLoevelSystemDesign.snakeladder;

import LowLoevelSystemDesign.snakeladder.models.Dice;
import LowLoevelSystemDesign.snakeladder.models.Ladder;
import LowLoevelSystemDesign.snakeladder.models.Player;
import LowLoevelSystemDesign.snakeladder.models.Snake;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import lombok.NonNull;
import lombok.Setter;

public class GameEngineOrchestrator {

  private static final int DEFAULT_NO_OF_DICES = 1;
  private static final int DEFAULT_BOARD_SIZE = 100;

  @Setter
  private int numOfDice;
  @Setter
  private int numberOfPlayer;
  @Setter
  private Queue<Player> players;
  @Setter
  private boolean isGameCompleted;


  private final GameBoard gameBoard;
  private final boolean isMultipleDiceRollAllowedOnSix;

  public GameEngineOrchestrator(@NonNull final int numOfDice, @NonNull final int gameBoardSize) {
    this.numOfDice = numOfDice;
    this.isGameCompleted = false;
    this.isMultipleDiceRollAllowedOnSix = false;
    this.gameBoard = new GameBoard(gameBoardSize);
  }

  public GameEngineOrchestrator() {
    this(GameEngineOrchestrator.DEFAULT_NO_OF_DICES, GameEngineOrchestrator.DEFAULT_BOARD_SIZE);
  }

  public void initPlayers(Queue<Player> players) {
    this.players = new LinkedList<>(players);
    this.numberOfPlayer = players.size();
    Map<String, Integer> playerPieces = new HashMap<>();
    for (Player player : players) {
      playerPieces.put(player.getPlayerId(), 0);
    }
    gameBoard.setPlayerPieces(playerPieces);
  }

  public void setInitialSnakesOnBoard(List<Snake> initialSnakesOnBoard) {
    gameBoard.setBoardSnakes(initialSnakesOnBoard);
  }

  public void setInitialLadderOnBoard(List<Ladder> initialLadderOnBoard) {
    gameBoard.setBoardLadders(initialLadderOnBoard);
  }

  private int getNewPositionAfterGoingThroughSnakesAndLadder(int newPosition) {
    int prevPosition;
    do {
      prevPosition = newPosition;
      for (Snake snake : gameBoard.getBoardSnakes()) {
        if (snake.getStartPoint() == newPosition) {
          newPosition = snake.getEndPoint();
        }
      }

      for (Ladder lader : gameBoard.getBoardLadders()) {
        if (lader.getStartPoint() == newPosition) {
          newPosition = lader.getEndPoint();
        }
      }
    } while (newPosition != prevPosition);
    return newPosition;
  }

  private void movePlayer(final Player player, final int position) {
    int oldPosition = gameBoard.getPlayerPieces().get(player.getPlayerId());
    int newPosition = oldPosition + position;

    if (newPosition > gameBoard.getBoardSize()) {
      newPosition = oldPosition;
    } else {
      newPosition = getNewPositionAfterGoingThroughSnakesAndLadder(newPosition);
    }
    gameBoard.getPlayerPieces().put(player.getPlayerId(), newPosition);
    System.out.println(player.getPlayerName() + " Rolled at " + position + " and moved from " +
        oldPosition + " to " + newPosition);
  }

  private int rollDice() {
    return new Random().nextInt(6) + 1;

  }

  private boolean hasPlayerWon(final Player player) {
    int playerPosition = gameBoard.getPlayerPieces().get(player.getPlayerId());
    return (gameBoard.getBoardSize() == playerPosition);
  }

  private boolean isGameCompleted() {
    int currentNumOfPlayer = players.size();
    return currentNumOfPlayer < numberOfPlayer;
  }

  public void startGame() {
    while (!isGameCompleted()) {
      int diceValAfterRoll = rollDice();
      Player currentPlayer = players.poll();
      movePlayer(currentPlayer, diceValAfterRoll);
      if (hasPlayerWon(currentPlayer)) {
        System.out.println(currentPlayer.getPlayerName() + " Wins the Game..!");
        gameBoard.getPlayerPieces().remove(currentPlayer.getPlayerId());
      } else {
        players.add(currentPlayer);
      }
    }
  }
}
