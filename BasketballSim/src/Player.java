import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Player 
{
	private int offense;
	private int defense;
	private int insidePlay;
	private int perimeterPlay;
	private int age;
	private String firstName;
	private String lastName;
	
	public Player() throws FileNotFoundException 
	{
		Random statGen = new Random();
		PlayerNames nameGen = new PlayerNames();
		
		offense = statGen.nextInt(50) + 40;
		defense = statGen.nextInt(50) + 40;
		insidePlay = statGen.nextInt(50) + 40;
		perimeterPlay = statGen.nextInt(50) + 40;
		age = statGen.nextInt(22) + 18;
		firstName = nameGen.generateFirstName();
		lastName = nameGen.generateLastName();
	}
	
	public int getOffenseStat()
	{
		return offense;
	}
	
	public int getDefenseStat()
	{
		return defense;
	}
	
	public int getInsidePlayStat()
	{
		return insidePlay;
	}
	
	public int getPerimeterPlayStat()
	{
		return perimeterPlay;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return (firstName + " " + lastName);
	}
	
	public int generatePlayerScore()
	{
		int score = 0;
		ArrayList<Integer> stats = new ArrayList<Integer>();
		stats.add(offense);
		stats.add(defense);
		stats.add(perimeterPlay);
		stats.add(insidePlay);
		int num = 0;
		for (int i = 0; i < stats.size(); i++)
		{
			num = stats.get(i);
			Random ptGen = new Random();
			if (num < 51)
				score = score + ptGen.nextInt(3);
			if (num > 50 && num < 61)
				score = score + ptGen.nextInt(4);
			if (num > 60 && num < 71)
				score = score + ptGen.nextInt(5);
			if (num > 70 && num < 81)
				score = score + ptGen.nextInt(6);
			if (num > 80 && num < 91)
				score = score + ptGen.nextInt(7);
			if (num > 90)
				score = score + ptGen.nextInt(8);
		}
		
		return score;
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Player myPlayer = new Player();
		System.out.println("Name: " + myPlayer.getName());
		System.out.println("Age: " + myPlayer.getAge());
		System.out.println("Offense: " + myPlayer.getOffenseStat());
		System.out.println("Defense: " + myPlayer.getDefenseStat());
		System.out.println("Inside Play: " + myPlayer.getInsidePlayStat());
		System.out.println("Perimeter Play: " + myPlayer.getPerimeterPlayStat());
		System.out.println(" ");
		System.out.println("Pts: " + myPlayer.generatePlayerScore() + " " + myPlayer.generatePlayerScore() + " " + myPlayer.generatePlayerScore()
				+ " " + myPlayer.generatePlayerScore() + " " + myPlayer.generatePlayerScore());
		
	}

}
