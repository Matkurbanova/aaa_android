package kg.itrun.android.aaa;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_categories:
                toolbar.setTitle(R.string.categories);
                System.out.println("Categories");
                break;
            case R.id.nav_news:
                toolbar.setTitle(R.string.menu_news);
                System.out.println("NEWS");
                break;
            case R.id.nav_stocks:
                toolbar.setTitle(R.string.menu_stocks);
                System.out.println("STOCKS");
                break;
            case R.id.nav_favorite:
                toolbar.setTitle(R.string.menu_favorite);
                System.out.println("FAVORITE");
                break;
            case R.id.nav_personal_cabinet:
                toolbar.setTitle(R.string.menu_personal_cabinet);
                System.out.println("PERSONAL CABINET");
                break;
            case R.id.nav_purchase_history:
                toolbar.setTitle(R.string.menu_purchase_history);
                System.out.println("PURCHASE HISTORY");
                break;
            case R.id.nav_chat:
                toolbar.setTitle(R.string.menu_chat);
                System.out.println("CHAT");
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
