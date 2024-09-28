package snake_ladder;
import java.util.*;

public class main {
	public static void main(String args[]) {
		System.out.println("..................Welcome to snake and ladder game............");
		System.out.print("Enter how many players going to play: ");
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		Map<Integer, Integer> players= new HashMap<>();
		for(int i=1; i<= n; i++) {
			players.put(i, 0);
		}
		board.makeBoard(); 
		board.game(players);
	}
}
