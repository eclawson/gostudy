package group5.project.gostudy;

import android.app.*;
import android.os.Bundle;
import java.io.*;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.*;
import java.util.*;

public class saveDeck extends ListActivity implements OnClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savenewdeck);
        ArrayList<String> files = new ArrayList<String>();
        File rootFile = getExternalFilesDir(null);
        ((Button)findViewById(R.id.save_button)).setOnClickListener(this);
		
        if(rootFile != null)
        {
        	for(File temp:rootFile.listFiles())
        		files.add(temp.getName());
        }
        else
        {
        	AlertDialog error = new AlertDialog.Builder(this).create();
            error.setMessage("no sd card");
            error.show();
        }
	    setListAdapter(new ArrayAdapter<String>(this, R.layout.row ,files));
    }
    public void onClick(View v)
    {
        String fileName = ((EditText)findViewById(R.id.file_name)).getText().toString();
        File saveFile = new File(getExternalFilesDir(null), fileName);
        try
        {
            FileOutputStream writer = new FileOutputStream(saveFile);
            writer.write(flashcard.stackOfCards.saveDeck().getBytes());
        }
        catch(Exception e)
        {
            AlertDialog error = new AlertDialog.Builder(this).create();
            error.setMessage("no sd card");
            error.show();
        }
        finish();
    }
    protected void onListItemClick (ListView l, View v, int position, long id)
	{
		try
		{
			File[] fileList = getExternalFilesDir(null).listFiles();
			if(!fileList[position].getName().equals(".nomedia"))
			{
				((EditText)findViewById(R.id.file_name)).setText(fileList[position].getName());
			}
		}
		catch(Exception e)
		{

		}
	}
    

}
