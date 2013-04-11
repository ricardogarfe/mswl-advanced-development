package es.advanced.development.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    private int requestCodeActividad2 = 2;
    private int requestCodeActividad3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStack = (Button) this.findViewById(R.id.buttonStack);

        if (buttonStack != null) {
            buttonStack.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(MainActivity.this,
                            StackActivity.class);
                    startActivity(intent);
                }
            });
        }

        Button buttonActividad2 = (Button) this.findViewById(R.id.buttonActividad2);

        if (buttonActividad2 != null) {
            buttonActividad2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(MainActivity.this,
                            Actividad2.class);
                    startActivityForResult(intent, requestCodeActividad2);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
