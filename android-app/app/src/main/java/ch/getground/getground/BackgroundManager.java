package ch.getground.getground;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by nicolosingerbfh on 12.11.16.
 */

public class BackgroundManager
{

    private Context mContext;

    public BackgroundManager(Context context)
    {
        mContext = context;
    }

    public void set(String uri) throws IOException
    {
        WallpaperManager wpManager = WallpaperManager.getInstance(mContext);
        InputStream is = (InputStream) new URL(uri).getContent();
        Bitmap bpScaled = getScaledBitmap(BitmapFactory.decodeStream(is));
        wpManager.setBitmap(bpScaled);
    }

    private Bitmap getScaledBitmap(Bitmap bitmap) {
        float screenWidth, screenHeight;
        float bitmap_width = bitmap.getWidth(), bitmap_height = bitmap.getHeight();
        Display display = ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        screenWidth = display.getWidth();
        screenHeight = display.getHeight();

        float bitmap_ratio = (bitmap_width / bitmap_height);
        float screen_ratio = (screenWidth / screenHeight);

        int bitmapNewWidth, bitmapNewHeight;
        if (screen_ratio > bitmap_ratio)
        {
            bitmapNewWidth = (int) screenWidth;
            bitmapNewHeight = (int) (bitmapNewWidth / bitmap_ratio);
        }
        else
        {
            bitmapNewHeight = (int) screenHeight;
            bitmapNewWidth = (int) (bitmapNewHeight * bitmap_ratio);
        }
        bitmap = Bitmap.createScaledBitmap(bitmap, bitmapNewWidth, bitmapNewHeight, true);
        return bitmap;
    }

}
