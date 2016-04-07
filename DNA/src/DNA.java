import java.util.Scanner;

/**
 * ******************************************************************************************************
 * 
 * Author: Drew Bigelow
 * Date: March 1st, 2016
 * Assignment 3
 * 
 * Task: Use linked lists to model DNA strands made up of nucleotides.
 * 
 * Input: Integers and characters are entered through the keyboard to operate the program's menu system.
 * 		  This includes the characters that make up the base pairs.
 * 
 * Output: characters, booleans, or integers that show that the chosen method has completed its task.
 * 
 * Certification of Authenticity: I certify that this code is entirely my own work.
 *
 * ******************************************************************************************************
 */
public class DNA 
{
	/**
	 * Purpose: Nested class that is a specialized node to store a base and connect to other nucleotides
	 * Preconditions: The class is called from in the DNA class
	 * Postconditions: A nucleotide is stored in memory
	 */
	public class Nucleotide
	{
		private char data; // each base is represented by a character
		private Nucleotide next; // next nucleotide in strand
		private Nucleotide across; // nucleotide that completes a base pair
		
		/**
		 * Purpose: To retrieve the base in the nucleotide
		 * Preconditions: The method is called on a nucleotide
		 * Postconditions: The base is returned as a character
		 */
		public char getData()
		{
			return data;
		}
		
		/**
		 * Purpose: To change the base
		 * Preconditions: The new base is a parameter 
		 * Postconditions: The base is has been changed
		 */
		public void setData(char base)
		{
			data = base;
		}
		
		/**
		 * Purpose: To set the next nucleotide in the strand
		 * Preconditions: The next nucleotide is entered as a parameter
		 * Postconditions: The next nucleotide in the strand has been set
		 */
		public void setNext(Nucleotide next)
		{
			this.next = next;
		}
		
		/**
		 * Purpose: To return the next nucleotide in the strand
		 * Preconditions: The method is called
		 * Postconditions: The next nucleotide in the strand is returned
		 */
		public Nucleotide getNext()
		{
			return next;
		}
		
		/**
		 * Purpose: To set the link to the nucleotide on the other strand
		 * Preconditions: The across nucleotide is a parameter
		 * Postconditions: The nucleotide has been linked with the other strand
		 */
		public void setAcross(Nucleotide across)
		{
			this.across = across;
		}
		
		/**
		 * Purpose: To return the nucleotide across from the current one in the strand
		 * Preconditions: The method is called
		 * Postconditions: The nucleotide across from the current one is returned
		 */
		public Nucleotide getAcross()
		{
			return across;
		}
		 
	} // end of Nucleotide class
	

	private Nucleotide left; // first node in the left DNA strand
	private Nucleotide right; // first node in the right DNA strand
	
	private int length = 0; //logical length of DNA strands
	
	/**
	 * Purpose: Constructor for the DNA class
	 * Preconditions: The DNA is instantiated
	 * Postconditions: The two strands are created
	 */
	public DNA()
	{
		left = new Nucleotide();
		right = new Nucleotide();
		
		//base pairs are connected
		left.setAcross(right);
		right.setAcross(left);
	}
	
	/**
	 * Purpose: To insert a pair of nucleotides into the DNA
	 * Preconditions: The index of insertion and the base pair are entered as parameters
	 * Postconditions: The nucleotides have been inserted
	 */
	public void insert(int index, String basePair)
	{
		if ( index < 0 || index > length )
            throw new IndexOutOfBoundsException();
		
		// new nucleotides are constructed
		Nucleotide newLeft = new Nucleotide();
		Nucleotide newRight = new Nucleotide();
		newLeft.setData(basePair.charAt(0));
		newRight.setData(basePair.charAt(1));
		
		// the nucleotides are linked
		newLeft.setAcross(newRight);
		newRight.setAcross(newLeft);
		
		if (index == 0) // if the nucleotide is at index 0, it is the new head nucleotide
		{
			newLeft.setNext(left);
			newRight.setNext(right);
			left = newLeft;
			right = newRight;
		}
		else
		{
			Nucleotide lp = left;//left pointer
			Nucleotide rp = right;//right pointer
			
			for (int i = 0; i < index - 1; i++)// loop for traversing list to point of insertion
			{
				lp = lp.getNext();//lp points to the nucleotide before the point of insertion
				rp = rp.getNext();//rp points to the nucleotide before the point of insertion
			}
			
			newLeft.setNext(lp.getNext());
			newRight.setNext(rp.getNext());
			lp.setNext(newLeft);
			rp.setNext(newRight);
		}
		length++; //logical length is increased
	}
	
	/**
	 * Purpose: To remove a base pair from the DNA
	 * Preconditions: The index of the base pair is entered as a parameter
	 * Postconditions: The removed base pair is returned as a string
	 */
	public String remove(int index)
	{
		if ( index < 0 || index > length )
            throw new IndexOutOfBoundsException();
		
		String result = ""; // result is removed base pair to be returned
		if(index == 0) // the first nucleotide is removed
		{
			result = "" + left.getData() + right.getData();
			left = left.getNext();
			right = right.getNext();
		}
		else
		{
			Nucleotide lp = left;//left pointer
			Nucleotide rp = right;//right pointer
			
			for (int i = 0; i < index - 1; i++) // loop for traversal to point of removal
			{
				lp = lp.getNext();// lp points to nucleotide before point of removal
				rp = rp.getNext();// rp points to nucleotide before point of removal
			}
			
			if (index == length - 1) // the last nucleotide is removed
			{
				result = "" + lp.getNext().getData() + rp.getNext().getData();
				lp.setNext(null);
				rp.setNext(null);
			}
			
			else // a middle nucleotide is removed
			{
				result = "" + lp.getNext().getData() + rp.getNext().getData();
				lp.setNext(lp.getNext().getNext());
				rp.setNext(rp.getNext().getNext());
			}
		}
		
		length = length - 1; //logical length is reduced
		return result;
	}
	
	/**
	 * Purpose: To print a specified range of base pairs
	 * Preconditions: The start and end indexes are entered as parameters
	 * Postconditions: The specified base pairs are printed in the console
	 */
	public void print(int startIndex, int endIndex)
	{
		if ( startIndex < 0 || startIndex > length )
            throw new IndexOutOfBoundsException();
		if ( endIndex < 0 || endIndex > length )
            throw new IndexOutOfBoundsException();
		
		Nucleotide p = left; // pointer
		String result = ""; // string to be printed
		
		for (int i = 0; i < startIndex; i++) // the strand is traversed to the start index
			p = p.getNext();
		
		for (int i = startIndex; i <= endIndex; i++) // the strand is traversed to the end index
		{
			result = result + p.getData() + p.getAcross().getData(); // base pairs are added to the string
			p = p.getNext();
		}
		System.out.println(result); // the string is printed
	}
	
	/**
	 * Purpose: To make the DNA strand empty
	 * Preconditions: The method is called
	 * Postconditions: The DNA strand is empty
	 */
	public void clear()
	{
		//new empty strands are created
		left = new Nucleotide();
		right = new Nucleotide();
		
		//left and right strands are connected
		left.setAcross(right);
		right.setAcross(left);
		
		length = 0;//logical length is reset
	}
	
	/**
	 * Purpose: To check if the DNA strand is empty
	 * Preconditions: The method is called
	 * Postconditions: A boolean is returned indicating whether the strand is empty
	 */
	public boolean isEmpty()
	{
		if (length == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Purpose: to find logical length of the DNA strand 
	 * Preconditions: The method is called
	 * Postconditions: The logical length of the DNA strand is returned
	 */
	public int getLength()
	{
		return length;
	}
	
	/**
	 * Purpose: To see if a specified base pair is in the DNA strand
	 * Preconditions: The base pair to be searched for is entered as a parameter
	 * Postconditions: The index of the pair is returned if it is found, otherwise -1 is returned
	 */
	public int find(String basePair)
	{
		int result = -1; // index to be returned if pair is found
		int count = 0; // count of nucleotides searched
		Nucleotide lp = left;//left pointer
		Nucleotide rp = right;//right pointer
		
		
		while( result < 0 && count < length )
		{
			if (lp.getData() == basePair.charAt(0) && rp.getData() == basePair.charAt(1))
				result = count; // if the basepair matches the nucleotide, result is the count and loop is broken
			else
			{
				// otherwise, the next nuleotide is pointed to and the count is increased
				count++;
				lp = lp.getNext();
				rp = rp.getNext();
			}
		}
		
		return result;
	}
	
	/**
	 * Purpose: To print the left side of the DNA strand
	 * Preconditions: The method is called
	 * Postconditions: The left side of the DNA strand is printed
	 */
	public void printLeft()
	{
		String result = ""; //string of bases to be returned
		Nucleotide p = left; //pointer
		for (int i = 0; i < length; i++)
		{
			result = result + p.getData();
			p = p.getNext();
		}
		System.out.println(result); // dna strand is printed
	}
	
	/**
	 * Purpose: To print the right side of the DNA strand
	 * Preconditions: The method is called
	 * Postconditions: The right side of the DNA strand is printed
	 */
	public void printRight()
	{
		String result = ""; //string of bases to be returned
		Nucleotide p = right; //pointer
		for (int i = 0; i < length; i++)
		{
			result = result + p.getData();
			p = p.getNext();
		}
		System.out.println(result); // dna strand is printed
	}
	
	/**
	 * Purpose: To print a specified base pair in a specified order
	 * Preconditions: The index and order are entered as parameters
	 * Postconditions: The base pair is printed
	 */
	public void printBasePair(int index, int helix)
	{
		if ( index < 0 || index > length )
            throw new IndexOutOfBoundsException();
		if ( helix < 0 || helix > 1 )
            throw new IndexOutOfBoundsException();
		
		Nucleotide p; // pointer
		String result = ""; // string to be printed
		
		if (helix == 0) //left helix is traversed 
			p = left;
		
		else //right helix is traversed
			p = right;
		
		for (int i = 0; i < index; i ++) // dna strand is traversed
			p = p.getNext();
		
		result = result + p.getData() + p.getAcross().getData(); // base pair string constructed
		System.out.println(result); // base pair is printed
	}
	
	/**
	 * Purpose: To return data based on DNA strands through user input
	 * Preconditions: The amount of commands, then commands themselves are entered
	 * Postconditions: The output from the commands are printed
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); // The scanner will scan input from the keyboard.
		int lines = Integer.parseInt(scanner.nextLine()); // the amount of commands entered
		int count = 0; // the number of times the while loop has run
		String result = ""; // final string to be printed
		DNA dna = new DNA(); // DNA strands are created
		
		while (count < lines)
		{
			String input = scanner.nextLine();
			String[] line = input.split(" ");
			int method = Integer.parseInt(line[0]);
			
			if (method == 1) // void insert
			{
				int index = Integer.parseInt(line[1]);
				String basepair = line[2];
				dna.insert(index, basepair);
			}
			
			else if (method == 2) // string remove
			{
				int index = Integer.parseInt(line[1]);
				result = result + dna.remove(index) + "\n";
			}
			
			else if (method == 3) // void print
			{
				int startIndex = Integer.parseInt(line[1]);
				int endIndex = Integer.parseInt(line[2]);
				dna.print(startIndex, endIndex);
			}
			
			else if (method == 4) // void clear
			{
				dna.clear();
			}
			
			else if (method == 5) // bool isEmpty
			{
				result = result + dna.isEmpty() + "\n";
			}
			
			else if (method == 6) // int getLength
			{
				result = result + dna.getLength() + "\n";
			}
			
			else if (method == 7) // int find
			{
				String basePair = line[1];
				result = result + dna.find(basePair) + "\n";
			}
			
			else if (method == 8) // void printLeft
			{
				dna.printLeft();
			}
			
			else if (method == 9) // void printRight
			{
				dna.printRight();
			}
			
			else if (method == 10) // void printBasePair
			{
				int index = Integer.parseInt(line[1]);
				int helix = Integer.parseInt(line[2]);
				dna.printBasePair(index, helix);
			}
			count++;
		}
		
		System.out.println(result);
		scanner.close();
	}
}
