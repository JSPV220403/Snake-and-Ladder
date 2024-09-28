package snake_ladder;
import java.util.*;

public class board {
	static int[][] gboard= new int[10][10];
	static Map<Integer, Integer> snakes= new HashMap<>();
	static Map<Integer, Integer> ladders= new HashMap<>();
	static Queue<Integer> pturn= new LinkedList<>();
	
	static {
		snakes.put(20, 10);
		snakes.put(40, 25);
	}
	static {
		ladders.put(5, 10);
		ladders.put(15, 25);
	}
	
	
	public static void makeBoard() {
		int colnumber=0;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				gboard[i][j]=++colnumber;
			}
		}
	}
	
	public static void game(Map<Integer, Integer> players) {
		for(Map.Entry<Integer, Integer>m: players.entrySet()) {
			pturn.add(m.getKey());
		}
		Random r= new Random();
		int dice;
		int currPlayer;
		
		while(true) {
			currPlayer= pturn.poll();
			System.out.println("Current Player is "+ currPlayer);
			dice= r.nextInt(6)+1;
			System.out.println("The dice value is "+ dice);
			if(ladders.containsKey(players.get(currPlayer)+dice)) {
				System.out.println("Got Ladder!!!");
				System.out.println("Now player "+currPlayer+" moved from "
						+players.get(currPlayer)+" to "+(players.get(currPlayer)+dice+ladders.get(players.get(currPlayer)+dice)));
						players.put(currPlayer, players.get(currPlayer)+dice+ladders.get(players.get(currPlayer)+dice));
			}
			if(snakes.containsKey(players.get(currPlayer)+dice)) {
				System.out.println("Faced snake");
				System.out.println("Now player "+currPlayer+" moved from "
						+players.get(currPlayer)+" to "+(players.get(currPlayer)+dice-snakes.get(players.get(currPlayer)+dice)));
						players.put(currPlayer, players.get(currPlayer)+dice-snakes.get(players.get(currPlayer)+dice));
			
			}
			else if(players.get(currPlayer)+dice<=100) {
				System.out.println("Now player "+currPlayer+" moved from "
				+players.get(currPlayer)+" to "+(players.get(currPlayer)+dice));
				players.put(currPlayer, players.get(currPlayer)+dice);
			}
			else {
				System.out.println("Can't move because of board exit");
			}
			pturn.add(currPlayer);
			if(players.get(currPlayer)==100) {
				System.out.println("Player "+currPlayer+" won the game!!!!");
				System.exit(0);
			}
		}
	}
	
}
