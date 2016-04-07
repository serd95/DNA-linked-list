import java.io.FileNotFoundException;
import java.util.Random;


public class Game 
{
	private int t1p1_Score;
	private int t1p2_Score;
	private int t1p3_Score;
	private int t1p4_Score;
	private int t1p5_Score;
	
	private int t2p1_Score;
	private int t2p2_Score;
	private int t2p3_Score;
	private int t2p4_Score;
	private int t2p5_Score;
	
	private int team1_Score;
	private int team2_Score;
	private String winningTeam;
	private String boxScore;
	
	private Team team1;
	private Team team2;
	
	public Game(Team team1in, Team team2in) 
	{
		team1 = team1in;
		team2 = team2in;
		t1p1_Score = team1.getPlayer1().generatePlayerScore();
		t1p2_Score = team1.getPlayer2().generatePlayerScore();
		t1p3_Score = team1.getPlayer3().generatePlayerScore();
		t1p4_Score = team1.getPlayer4().generatePlayerScore();
		t1p5_Score = team1.getPlayer5().generatePlayerScore();
		
		t2p1_Score = team2.getPlayer1().generatePlayerScore();
		t2p2_Score = team2.getPlayer2().generatePlayerScore();
		t2p3_Score = team2.getPlayer3().generatePlayerScore();
		t2p4_Score = team2.getPlayer4().generatePlayerScore();
		t2p5_Score = team2.getPlayer5().generatePlayerScore();
		
		team1_Score = t1p1_Score + t1p2_Score + t1p3_Score + t1p4_Score + t1p5_Score;
		team2_Score = t2p1_Score + t2p2_Score + t2p3_Score + t2p4_Score + t2p5_Score;
		
		String winner = new String();
		if (team1_Score > team2_Score)
			winner = "team1";
		if (team1_Score < team2_Score)
			winner = "team2";
		if (team1_Score == team2_Score)
		{
			Random overtime = new Random();
			int tiePt = overtime.nextInt(2);
			if (tiePt ==0)
			{
				team1_Score++;
				winner = "team1";
			}
			else
			{
				team2_Score++;
				winner = "team2";	
			}
		}
		if (winner == "team1")
			winningTeam = team1.getTeamName();
		if (winner == "team2")
			winningTeam = team2.getTeamName();
	}
	
	public String winner()
	{
		return winningTeam;
	}
	
	public String boxScore()
	{
		boxScore = 
				team1.getTeamName() + ":" + "\n" +
				team1.getPlayer1().getName() + ": " + t1p1_Score + "\n" +
				team1.getPlayer2().getName() + ": " + t1p2_Score + "\n" +
				team1.getPlayer3().getName() + ": " + t1p3_Score + "\n" +
				team1.getPlayer4().getName() + ": " + t1p4_Score + "\n" +
				team1.getPlayer5().getName() + ": " + t1p5_Score + "\n" +
				"Total: " + team1_Score + "\n" +
				"\n" +
				team2.getTeamName() + ":" + "\n" +
				team2.getPlayer1().getName() + ": " + t2p1_Score + "\n" +
				team2.getPlayer2().getName() + ": " + t2p2_Score + "\n" +
				team2.getPlayer3().getName() + ": " + t2p3_Score + "\n" +
				team2.getPlayer4().getName() + ": " + t2p4_Score + "\n" +
				team2.getPlayer5().getName() + ": " + t2p5_Score + "\n" +
				"Total: " + team2_Score + "\n" +
				"\n" + 
				winningTeam + " win";
		
		return boxScore;
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Team Knicks = new Team("Knicks");
		Team Bucks = new Team("Bucks");
		Game game = new Game(Knicks, Bucks);
		System.out.println(game.boxScore());
	}
}
