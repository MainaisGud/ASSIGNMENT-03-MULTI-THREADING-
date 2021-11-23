import java.util.Scanner;
import java.util.Vector;
public class mainThread extends Thread
{
	public static void main (String[] args) throws InterruptedException
	{
		BinarySearchTree T = new BinarySearchTree();
		
		Vocabulary TH_01 = new Vocabulary(T);
		TH_01.start();
		TH_01.join();
		
		Input01 TH_02 = new Input01(T);
		TH_02.start();
		TH_02.join();
		
		Input02 TH_03 = new Input02(T);
		TH_03.start();
		TH_03.join();
		
		Scanner reader = new Scanner(System.in);
		int choice = 0;
		do 
		{
				System.out.print("\nNOTE : ENTER THE NUMBER CORRESPONDING TO YOUR DESIRED CHOICE."
						+ "\n1) Displaying BST build from Vocabulary File."
						+ "\n2) Displaying Vectors build from Input Files."
						+ "\n3) Viewing match words and their frequency."
						+ "\n4) Searching a query."
						+ "\n5) Exiting."
						+ "\nCHOICE : ");
				
			choice = reader.nextInt();
			
			if(choice == 1)
			{
				TH_01.display(T);
			}
			else if(choice == 2)
			{
				TH_02.display();
				TH_03.display();
			}
			else if(choice == 3)
			{
				TH_02.displaymap();
				TH_03.displaymap();
			}
			else if(choice == 4)
			{
				String query = "";
				System.out.print("\nQUERY : ");
				query += reader.next();
				
				if(TH_02.search(query))
				{
					System.out.print("\nQUERY WORD FOUND IN INPUT TEXT FILE 01.");
				}
				
				if(TH_03.search(query))
				{
					System.out.print("\nQUERY WORD FOUND IN INPUT TEXT FILE 02.");
				}
				else
					System.out.print("\nQUERY WORD NOT FOUND IN ALL FILES.");
			}
		}
		while (choice!=5);		
	}
}
