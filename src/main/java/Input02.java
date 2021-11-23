import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;
public class Input02 extends Thread
{
	Vector<String> Str_Vector = new Vector<String>();
	Vector<String> Tokenized_Vector = new Vector<String>();
	Map<String,Integer> map_var = new TreeMap<String, Integer>();
	
	public Input02(BinarySearchTree T2) 
	{
		simulate(T2);
	}

	public void simulate(BinarySearchTree Tree)
	{
		System.out.print("\nInput02 Thread IS FUNCTIONAL.\n");
		
		String Path = "C:\\Users\\amnas\\Desktop\\Input02.txt";
		String Input_Str = "";
		try 
		{
			BufferedReader inputBuffer = new BufferedReader(new FileReader(Path));
			try 
			{
				while ((Input_Str = inputBuffer.readLine())!=null)
				{
					Str_Vector.add(Input_Str);
					StringTokenizer Token_check = new StringTokenizer(Input_Str);
					while(Token_check.hasMoreTokens())
					{
						Tokenized_Vector.add(Token_check.nextToken());
					}
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
		
		for (int i=0; i < Tokenized_Vector.size(); i++)
		{
			String token = "";
			token = Tokenized_Vector.elementAt(i);
			if(Tree.search(token))
			{
				if(map_var.containsKey(token))
					map_var.put(token, map_var.get(token)+1);
				else
					map_var.put(token,1);
			}
		}
	}
	
	public void display()
	{
		System.out.println(Tokenized_Vector);
	}
	
	public void displaymap()
	{
		for(Map.Entry<String,Integer> inserted: map_var.entrySet())
		{
			System.out.print("\n"+inserted.getKey()+" : "+inserted.getValue());
		}
	}
	
	public boolean search(String str)
	{
		if(Tokenized_Vector.contains(str))
			return true;
		return false;
	}
}
