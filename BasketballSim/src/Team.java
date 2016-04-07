import java.io.FileNotFoundException;

public class Team 
{
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private Player player5;
	private int wins;
	private int losses;
	private String teamName;
	
	public Team(String name) throws FileNotFoundException 
	{
		teamName = name;
		
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		player4 = new Player();
		player5 = new Player();
		
		wins = 0;
		losses = 0;
	}
	
	public String getRoster()
	{
		String roster;
		roster = player1.getName() + ", " + "Age: " + player1.getAge() + "\n"
				+ player2.getName() + ", " + "Age: " + player2.getAge() + "\n"
				+ player3.getName() + ", " + "Age: " + player3.getAge() + "\n"
				+ player4.getName() + ", " + "Age: " + player4.getAge() + "\n"
				+ player5.getName() + ", " + "Age: " + player5.getAge();

		return roster;
	}
	public String getTeamName()
	{
		return teamName;
	}
	
	public Player getPlayer1()
	{
		return player1;
	}
	
	public Player getPlayer2()
	{
		return player2;
	}
	
	public Player getPlayer3()
	{
		return player3;
	}
	
	public Player getPlayer4()
	{
		return player4;
	}
	
	public Player getPlayer5()
	{
		return player5;
	}
	
	public Integer getWins()
	{
		return wins;
	}
	public void setWins(int newWins)
	{
		wins = newWins;
	}
	
	public Integer getLosses()
	{
		return losses;
	}
	public void setLosses(int newLosses)
	{
		losses = newLosses;
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Team team = new Team("Orange");
		System.out.println(team.getRoster());
		System.out.println(" ");
		Player tempPlayer = team.getPlayer1();
		System.out.println(tempPlayer.getName() + " " + tempPlayer.getOffenseStat() + " " + tempPlayer.getDefenseStat() 
				+ " " + tempPlayer.getPerimeterPlayStat() + " " + tempPlayer.getInsidePlayStat());
	}
}
