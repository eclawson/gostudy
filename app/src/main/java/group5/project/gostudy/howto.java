package group5.project.gostudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import group5.project.gostudy.R;

/**
 * Created by chadlawson on 4/19/15.
 */


public class howto extends Activity implements View.OnClickListener
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.howto);


        ((Button)findViewById(R.id.back1)).setOnClickListener(this);

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
            case R.id.back1:
                finish();
                break;
        }
    }


}
