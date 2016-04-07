import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PlayerNames 
{
	private ArrayList<String> firstNameDataBase;
	private ArrayList<String> lastNameDataBase;
	
	public PlayerNames() throws FileNotFoundException 
	{
		Scanner firstNameScnr = new Scanner(new File("firstNames.txt"));
		String firstNameFileStr = firstNameScnr.nextLine();
		firstNameScnr.close();
		firstNameDataBase = new ArrayList<String>();
		StringTokenizer firstNameStrTok = new StringTokenizer(firstNameFileStr,",");
		while(firstNameStrTok.hasMoreTokens())
		{
			String temp = firstNameStrTok.nextToken();
			if (temp != null)
				firstNameDataBase.add(temp);
		}
		
		Scanner lastNameScnr = new Scanner(new File("lastNames.txt"));
		String lastNameFileStr = lastNameScnr.nextLine();
		lastNameScnr.close();
		lastNameDataBase = new ArrayList<String>();
		StringTokenizer lastNameStrTok = new StringTokenizer(lastNameFileStr,",");
		while(lastNameStrTok.hasMoreTokens())
		{
			lastNameDataBase.add(lastNameStrTok.nextToken());
		}
	}
	
	public List<String> getFirstNameDataBase()
	{
		return firstNameDataBase;
	}
	
	public List<String> getLastNameDataBase()
	{
		return lastNameDataBase;
	}
	
	public String generateFirstName()
	{
		Random indexGen = new Random();
		int firstNameIndex = indexGen.nextInt(firstNameDataBase.size());
		return firstNameDataBase.get(firstNameIndex);
	}
	
	public String generateLastName()
	{
		Random indexGen = new Random();
		int LastNameIndex = indexGen.nextInt(lastNameDataBase.size());
		return lastNameDataBase.get(LastNameIndex);
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		PlayerNames playerNames = new PlayerNames();
		List<String> fstnameslst = playerNames.getFirstNameDataBase();
		System.out.println(fstnameslst);
		System.out.println(" ");
		List<String> lastnameslst = playerNames.getLastNameDataBase();
		System.out.println(lastnameslst);
		System.out.println(" ");
		System.out.println("Name: " + playerNames.generateFirstName() + " " + playerNames.generateLastName());
		System.out.println("Name: " + playerNames.generateFirstName() + " " + playerNames.generateLastName());
		System.out.println("Name: " + playerNames.generateFirstName() + " " + playerNames.generateLastName());
		System.out.println("Name: " + playerNames.generateFirstName() + " " + playerNames.generateLastName());
		System.out.println("Name: " + playerNames.generateFirstName() + " " + playerNames.generateLastName());
	}
}
