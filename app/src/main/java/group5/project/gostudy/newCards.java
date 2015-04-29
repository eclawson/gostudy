
package group5.project.gostudy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class newCards extends Activity implements OnClickListener
{
	TextView question_input;
	TextView answer_input;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcards);
        

    	((Button)findViewById(R.id.add_card_button)).setOnClickListener(this);
    	((Button)findViewById(R.id.back_button)).setOnClickListener(this);
    	question_input = (TextView)findViewById(R.id.question_input);
    	answer_input = (TextView)findViewById(R.id.answer_input);
    }
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

        }
        return false;
    }

    public void onClick(View v)
    {
    	switch(v.getId())
    	{
    		case R.id.add_card_button:
    			if(!question_input.getText().toString().equals("") && !answer_input.getText().toString().equals(""))
    			{
    				flashcard.stackOfCards.addCard(new FrontAndBack(question_input.getText().toString(), answer_input.getText().toString()));
    				question_input.setText("");
    				answer_input.setText("");
    			}
    			break;
    		case R.id.back_button:
                finish();
                break;
    	}
    }

    private void viewset(){
        Intent intent = new Intent(this, flashcard.class);
        startActivity(intent);
        finish();
    }
}
