import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Vector;
public class Vocabulary extends Thread
{
	public Vocabulary(BinarySearchTree T3) 
	{
		simulation(T3);
	}

	public void simulation(BinarySearchTree Tree)
	{
		System.out.print("\nVocabulary Thread IS FUNCTIONAL.\n");
		String Path = "C:\\Users\\amnas\\Desktop\\Vocabulary.txt";
		String Input_Str = "";
		try 
		{
			BufferedReader inputBuffer = new BufferedReader(new FileReader(Path));
			try 
			{
				while ((Input_Str = inputBuffer.readLine())!=null)
				{
					Tree.addNode(Input_Str);
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

	}
	
	public void display(BinarySearchTree Tree)
	{
		Tree.preorder();
	}
}
