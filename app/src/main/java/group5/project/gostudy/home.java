package group5.project.gostudy;

/**
 * Created by chadlawson on 4/18/15.
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;

public class home extends Activity {

     private ImageButton viewset;
   //  private Button newset;
     //public static deck stackOfCards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
       // stackOfCards = new deck();
        //Intent loader;

        viewset = (ImageButton) findViewById(R.id.sets);
        viewset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewset();
            }
        });

       // newset = (Button) findViewById(R.id.createset);


    }

    private void viewset(){
        Intent intent = new Intent(this, flashcard.class);
        startActivity(intent);
        finish();
    }

    private void newset(){
        Intent intent = new Intent(this, newCards.class);
        startActivity(intent);
        finish();
    }

}
