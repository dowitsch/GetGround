package ch.getground.getground;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nicolosingerbfh on 12.11.16.
 */

public class Options
{

    private static final String PREFS_NAME = "getGroundPrefsFile";
    private static final String OPT_ACTIVE = "active";

    private Context mContext;

    public Options(Context context)
    {
        mContext = context;
    }

    public boolean isActive()
    {
        SharedPreferences settings = getPrefs();
        return settings.getBoolean(OPT_ACTIVE, true);
    }

    public void setActive(boolean active)
    {
        SharedPreferences settings = getPrefs();
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(OPT_ACTIVE, active);
        editor.commit();
    }

    private SharedPreferences getPrefs()
    {
        return mContext.getSharedPreferences(PREFS_NAME, 0);
    }

}
