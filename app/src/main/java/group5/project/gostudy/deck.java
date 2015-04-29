package group5.project.gostudy;
import java.io.File;
import java.util.Scanner;
import java.lang.Exception;
import java.util.ArrayList;

public class deck
{
	private ArrayList<FrontAndBack> reviewStack;
	private ArrayList<FrontAndBack> viewedStack;
	
	public deck()
	{
		reviewStack = new ArrayList<FrontAndBack>();
		viewedStack = new ArrayList<FrontAndBack>();
	}
	
	public void setStack(File flashc)
	{
		try
		{
			Scanner reader = new Scanner(flashc);
			
			while(reader.hasNext())
			{
				reviewStack.add(new FrontAndBack(reader.nextLine(), reader.nextLine()));
			}
		}
		catch(Exception e)
		{
			
		}
	}
	

	public void clearArrays()
	{
		reviewStack = new ArrayList<FrontAndBack>();
		viewedStack = new ArrayList<FrontAndBack>();
	}
	
	public void addCard(FrontAndBack newFrontAndBack)
	{
		reviewStack.add(newFrontAndBack);
	}
	
	public String saveDeck()
	{
		String cardStack = new String();
		for(int i = 0; i<reviewStack.size(); i++)
		{
			FrontAndBack temp = reviewStack.get(i);
			cardStack += (temp.getFrontCard()+"\n"+temp.getBackCard()+"\n");
		}
		for(int i = 0; i < viewedStack.size(); i++)
		{
			FrontAndBack temp = viewedStack.get(i);
			cardStack += (temp.getFrontCard()+"\n"+temp.getBackCard()+"\n");
		}
		return cardStack;
	}
	
	public FrontAndBack getCard(boolean random)
	{
		if(reviewStack.size()==0)
		{
			if(viewedStack.size() == 0)
				return null;
			reviewStack = viewedStack;
			viewedStack = new ArrayList<FrontAndBack>();
			return getCard(random);
		}
		else
		{
			FrontAndBack tempFrontAndBack = reviewStack.remove(0);
			viewedStack.add(tempFrontAndBack);
			return tempFrontAndBack;
		}
	}
}
