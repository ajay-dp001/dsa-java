package LowLoevelSystemDesign.snakeladder;

import LowLoevelSystemDesign.snakeladder.models.Ladder;
import LowLoevelSystemDesign.snakeladder.models.Player;
import LowLoevelSystemDesign.snakeladder.models.Snake;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.UUID;

public class SnakeLadderGameMainController {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter Num of Snakes...");

    int numOfSnakes = scan.nextInt();
    List<Snake> snakes = new ArrayList<>();
    for (int i = 0; i < numOfSnakes; i++) {
      snakes.add(new Snake(scan.nextInt(), scan.nextInt()));
    }

    System.out.println("Enter Num of Ladders...");

    int numOfLadders = scan.nextInt();
    List<Ladder> ladders = new ArrayList<>();
    for (int i = 0; i < numOfLadders; i++) {
      ladders.add(new Ladder(scan.nextInt(), scan.nextInt()));
    }

    System.out.println("Enter Num of Players.");
    int noOfPlayers = scan.nextInt();
    Queue<Player> players = new LinkedList<>();
    for (int i = 0; i < noOfPlayers; i++) {
      players.offer(new Player(UUID.randomUUID().toString(), scan.next()));
    }

    GameEngineOrchestrator gameEngineOrchestrator = new GameEngineOrchestrator();
    gameEngineOrchestrator.initPlayers(players);
    gameEngineOrchestrator.setInitialLadderOnBoard(ladders);
    gameEngineOrchestrator.setInitialSnakesOnBoard(snakes);

    gameEngineOrchestrator.startGame();

  }

}
