package ch.getground.getground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Menu mMenu;
    private Options mOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOptions = new Options(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        mMenu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, mMenu);
        mMenu.getItem(0).setChecked(mOptions.isActive());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.active_menu_item:
                return activeToggle();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean activeToggle()
    {
        mOptions.setActive(!mOptions.isActive());
        mMenu.getItem(0).setChecked(mOptions.isActive());
        return true;
    }

}
