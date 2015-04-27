package group5.project.gostudy;

//icon was taken from the public domain, at url http://www.clker.com/clipart-8139.html

import java.io.File;
import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Menu;

import group5.project.gostudy.R;

public class flashcard extends Activity implements OnClickListener 
{
	TextView questionField;
	TextView answerField;
	Button nextButton;
	Button hideOrShowButton;
    Button howtobut;
	//ToggleButton randomToggleButton;
	
	public static deck stackOfCards;
	private FrontAndBack currentQuestion;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	
    	stackOfCards = new deck();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcardscreen);
        try
		{
			FileOutputStream nomedia = new FileOutputStream(new File(getExternalFilesDir(null), ".nomedia"));
			nomedia.write('a');
			nomedia.close();
		}
		catch(Exception e)
		{
		}
        questionField = (TextView)findViewById(R.id.questionView);
        answerField = (TextView)findViewById(R.id.answerView);
        nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(this);
        //addnew = (Button)findViewById(R.id.addbutton);
        howtobut = (Button)findViewById(R.id.howtobutton);
        howtobut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helppage();
            }
        });

        hideOrShowButton = (Button)findViewById(R.id.hideButton);
        hideOrShowButton.setOnClickListener(this);
        
       // randomToggleButton = (ToggleButton)findViewById(R.id.randomToggleButton);
    }
    private void helppage(){
        Intent intent = new Intent(this, howto.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.flashmenu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem menu)
    {
    	Intent loader;
    	switch(menu.getItemId())
    	{
    		case R.id.menu_import: 	loader = new Intent(getBaseContext(), viewDecks.class);
    								startActivity(loader);
    								break;
    		case R.id.menu_create:	loader = new Intent(getBaseContext(), newCards.class);
									startActivity(loader);
									break;
    		case R.id.menu_save: 	loader = new Intent(getBaseContext(), saveDeck.class);
									startActivity(loader);
									break;
    		case R.id.menu_clear_stack:
    								stackOfCards.clearStack();
    								questionField.setText("");
    								answerField.setText("");
    								currentQuestion = null;
    								break;
    	}
    	return false;
    }
    
    public void onClick(View v)
    {
    	switch(v.getId())

    	{



    		case R.id.nextButton: 
    			currentQuestion = stackOfCards.getCard(true);
    			if(currentQuestion!=null)
    			{
    				questionField.setText(currentQuestion.getQuestion());
    				answerField.setText("");
    				hideOrShowButton.setText("Show Answer");
    			}
    			break;
    		case R.id.hideButton: 
    			if(currentQuestion != null && answerField.getText().equals(""))
    			{
    				answerField.setText(currentQuestion.getAnswer());
    				hideOrShowButton.setText("Hide Answer");
    			}
    			else if (currentQuestion != null)
    			{
    				answerField.setText("");
    				hideOrShowButton.setText("Show Answer");
    			}
    			break;
    	}
    	
    }
    
}
