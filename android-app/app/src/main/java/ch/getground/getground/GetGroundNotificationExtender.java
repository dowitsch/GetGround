package ch.getground.getground;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by nicolosingerbfh on 12.11.16.
 */
public class GetGroundNotificationExtender extends NotificationExtenderService
{

    private static final String KEY_IMG_URI = "img_uri";

    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult notification)
    {
        try
        {
            process(notification);
        }
        catch (JSONException | IOException e)
        {
            Log.e(getClass().toString(), e.getMessage());
        }
        // Return true to stop the notification from displaying.
        return true;
    }

    private void process(OSNotificationReceivedResult notification) throws JSONException, IOException
    {
        JSONObject data = notification.payload.additionalData;
        Options options = new Options(getApplicationContext());
        if (data != null && options.isActive())
        {
            String imgUri = data.getString(KEY_IMG_URI);
            new BackgroundManager(getApplicationContext()).set(imgUri);
        }
    }



}
