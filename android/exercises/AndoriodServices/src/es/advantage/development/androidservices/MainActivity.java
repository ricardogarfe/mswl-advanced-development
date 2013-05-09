package es.advantage.development.androidservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button buttonStartService;
    private Button buttonStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartService = (Button) this
                .findViewById(R.id.buttonStartService);

        buttonStartService.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startService(new Intent(getApplicationContext(),
                        AndroidService.class));
            }
        });

        buttonStopService = (Button) this.findViewById(R.id.buttonStopService);

        buttonStopService.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(),
                        AndroidService.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
