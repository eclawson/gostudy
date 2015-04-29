package group5.project.gostudy;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.lang.Exception;


public class viewDecks extends ListActivity
{
	File rootFile;
	ArrayList<String> files;
	public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdecks);
        files = new ArrayList<String>();
        rootFile = getExternalFilesDir(null);
		
        if(rootFile != null)
        {
        	for(File temp:rootFile.listFiles())
        		files.add(temp.getName());
        }

	    setListAdapter(new ArrayAdapter<String>(this, R.layout.row ,files));
	}
	protected void onListItemClick (ListView l, View v, int position, long id)
	{
		try
		{
			File[] fileList = rootFile.listFiles();
			if(!fileList[position].getName().equals(".nomedia"))
			{
				flashcard.card_Deck.setStack(fileList[position]);
			}
		}
		catch(Exception e)
		{
		}
		finish();
	}
}
