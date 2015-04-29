package group5.project.gostudy;
import java.io.*;
import android.os.Bundle;
import android.widget.*;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.*;

public class flashcard extends Activity implements OnClickListener 
{
	TextView flashcard;
//	TextView backcard;
	Button nextButton;
	Button hideOrShowButton;
    Button howtobut;

	public static deck card_Deck;
	private FrontAndBack cardStatus;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	
    	card_Deck = new deck();
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
        flashcard = (TextView)findViewById(R.id.questionView);
      //  backcard = (TextView)findViewById(R.id.answerView);
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
        
    }
    private void helppage(){
        Intent intent = new Intent(this, howto.class);
        startActivity(intent);
        finish();
    }


    
    public void onClick(View v)
    {
    	switch(v.getId())

    	{
    		case R.id.nextButton: 
    			cardStatus = card_Deck.getCard(true);
    			if(cardStatus !=null)
    			{
    				flashcard.setText(cardStatus.getFrontCard());

    				hideOrShowButton.setText("Flip to Back");
    			}
    			break;
    		case R.id.hideButton: 
    			if(cardStatus != null && flashcard.getText().equals(cardStatus.getFrontCard()))
    			{
    				flashcard.setText(cardStatus.getBackCard());
    				hideOrShowButton.setText("Flip to Front");
    			}
    			else if (cardStatus != null )
    			{

                    flashcard.setText(cardStatus.getFrontCard());
    				hideOrShowButton.setText("Flip to Back");
    			}
    			break;
    	}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.flashmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu)
    {
        Intent intent;
        switch(menu.getItemId())
        {
            case R.id.menu_create:
                intent = new Intent(getBaseContext(), newCards.class);
                startActivity(intent);
                break;
            case R.id.menu_import:
                intent = new Intent(getBaseContext(), viewDecks.class);
                startActivity(intent);
                break;
            case R.id.menu_save:
                intent = new Intent(getBaseContext(), saveDeck.class);
                startActivity(intent);
                break;
            case R.id.menu_clear_stack:
                card_Deck.clearStack();
                flashcard.setText("");
                //backcard.setText("");
                cardStatus = null;
                break;
        }
        return false;
    }
}
