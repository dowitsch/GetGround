package ch.getground.getground;

import android.app.Application;
import com.onesignal.OneSignal;

/**
 * Created by nicolosingerbfh on 12.11.16.
 */
public class GetGroundApplication extends Application
{

        @Override
        public void onCreate()
        {
            super.onCreate();
            OneSignal.startInit(this).init();

            // Sync hashed email if you have a login system or collect it.
            //   Will be used to reach the user at the most optimal time of day.
            // OneSignal.syncHashedEmail(userEmail);
        }
}
