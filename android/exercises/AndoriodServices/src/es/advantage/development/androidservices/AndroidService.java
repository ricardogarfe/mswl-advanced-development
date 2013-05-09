/**
 * 
 */
package es.advantage.development.androidservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * @author ricardo
 * 
 */
public class AndroidService extends Service {

    @Override
    public void onCreate() {

        super.onCreate();

        Toast.makeText(this, "Start Service", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {

        Toast.makeText(this, "Stop Service", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}
