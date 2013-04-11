package es.advanced.development.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final int REQUEST_CODE_ACTIVIDAD_2 = 2;
    private final int REQUEST_CODE_ACTIVIDAD_3 = 3;

    private final String PARAM = "PARAM";

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

        Button buttonActividad2 = (Button) this
                .findViewById(R.id.buttonActividad2);

        if (buttonActividad2 != null) {
            buttonActividad2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(MainActivity.this,
                            Actividad2.class);
                    intent.putExtra("TITLE", "Activity2 from Main Activity");
                    // intent.putExtra("TEMP", 80.2);
                    startActivityForResult(intent, REQUEST_CODE_ACTIVIDAD_2);
                }
            });
        }

        Button buttonActividad3 = (Button) this
                .findViewById(R.id.buttonActividad3);

        if (buttonActividad3 != null) {
            buttonActividad3.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(MainActivity.this,
                            Actividad3.class);
                    intent.putExtra("TITLE", "Activity3 from Main Activity");
                    // intent.putExtra("TEMP", 80.2);
                    startActivityForResult(intent, REQUEST_CODE_ACTIVIDAD_3);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == REQUEST_CODE_ACTIVIDAD_2) {

                Integer value = data.getIntExtra(this.PARAM, -1);

                Toast.makeText(this,
                        "Come back from activity 2:\t" + String.valueOf(value),
                        Toast.LENGTH_SHORT).show();

            } else if (requestCode == REQUEST_CODE_ACTIVIDAD_3) {

                Integer value = data.getIntExtra(this.PARAM, -1);

                Toast.makeText(this,
                        "Come back from activity 3:\t" + String.valueOf(value),
                        Toast.LENGTH_SHORT).show();
            }

        }
    }
}
