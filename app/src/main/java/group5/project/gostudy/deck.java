package group5.project.gostudy;
import java.io.File;
import java.util.Scanner;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Random;

public class deck
{
	private ArrayList<FrontAndBack> reviewStack;
	private ArrayList<FrontAndBack> viewedStack;
	
	public deck()
	{
		reviewStack = new ArrayList<FrontAndBack>();
		viewedStack = new ArrayList<FrontAndBack>();
	}
	
	public void setStack(File QA)
	{
		try
		{
			Scanner reader = new Scanner(QA);
			
			while(reader.hasNext())
			{
				reviewStack.add(new FrontAndBack(reader.nextLine(), reader.nextLine()));
			}
		}
		//todo: handle specific exceptions
		catch(Exception e)
		{
			
		}
	}
	
	//remove all cards from both decks
	
	public void clearStack()
	{
		reviewStack = new ArrayList<FrontAndBack>();
		viewedStack = new ArrayList<FrontAndBack>();
	}
	
	//adds a FrontAndBack to the deck
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
			cardStack += (temp.getQuestion()+"\n"+temp.getAnswer()+"\n");
		}
		for(int i = 0; i<viewedStack.size(); i++)
		{
			FrontAndBack temp = viewedStack.get(i);
			cardStack += (temp.getQuestion()+"\n"+temp.getAnswer()+"\n");
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
		else if(random)
		{
			Random randy = new Random();
			FrontAndBack tempFrontAndBack = reviewStack.remove(randy.nextInt(reviewStack.size()));
			viewedStack.add(tempFrontAndBack);
			return tempFrontAndBack;
		}
		else
		{
			FrontAndBack tempFrontAndBack = reviewStack.remove(0);
			viewedStack.add(tempFrontAndBack);
			return tempFrontAndBack;
		}
	}
}
