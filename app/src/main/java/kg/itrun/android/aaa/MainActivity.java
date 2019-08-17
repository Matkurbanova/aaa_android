package kg.itrun.android.aaa;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import kg.itrun.android.aaa.data.Category;
import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.data.SubCategory;
import kg.itrun.android.aaa.view.fragments.BasketFragment;
import kg.itrun.android.aaa.view.fragments.CategoryFragment;
import kg.itrun.android.aaa.view.fragments.FavoriteFragment;
import kg.itrun.android.aaa.view.fragments.NewsFragment;
import kg.itrun.android.aaa.view.fragments.ProductFragment;
import kg.itrun.android.aaa.view.fragments.ProductsFragment;
import kg.itrun.android.aaa.view.fragments.PromoFragment;
import kg.itrun.android.aaa.view.fragments.SubCategoryFragment;

public class MainActivity extends AppCompatActivity
        implements
        NavigationView.OnNavigationItemSelectedListener,
        SubCategoryFragment.SubCategoryFragmentListener,
        View.OnClickListener,
        CategoryFragment.CategoryFragmentListener,
        ProductsFragment.ProductsFragmentListener {

    private Toolbar toolbar;
    private Fragment currentFragment;

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_categories:
                toolbar.setTitle(R.string.categories);
                showFragment(CategoryFragment.class);
                break;
            case R.id.nav_news:
                toolbar.setTitle(R.string.menu_news);
                showFragment(NewsFragment.class);
                break;
            case R.id.nav_stocks:
                toolbar.setTitle(R.string.menu_stocks);
                showFragment(PromoFragment.class);
                break;
            case R.id.nav_favorite:
                toolbar.setTitle(R.string.menu_favorite);
                showFragment(SubCategoryFragment.class);
                showFragment(FavoriteFragment.class);


                break;
            case R.id.nav_personal_cabinet:
                toolbar.setTitle(R.string.menu_personal_cabinet);
                System.out.println("PERSONAL CABINET");
                showFragment(ProductFragment.class);
                break;
            case R.id.nav_purchase_history:
                toolbar.setTitle(R.string.menu_purchase_history);
                System.out.println("PURCHASE HISTORY");
                break;
            case R.id.nav_chat:
                toolbar.setTitle(R.string.menu_chat);
                System.out.println("CHAT");

                showFragment(BasketFragment.class);
                break;

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(Class fragmentClass, String tag) {
        try {
            Fragment fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment);
            transaction.addToBackStack(tag);
            transaction.commit();

            currentFragment = fragment;
        } catch (IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    private void showFragment(Class fragmentClass) {
        showFragment(fragmentClass, null);
    }

    @Override
    public void onCategoryClick(Category category) {
        toolbar.setTitle(category.getName());
        if (currentFragment != null)
            showFragment(SubCategoryFragment.class, currentFragment.getTag());
        else
            showFragment(SubCategoryFragment.class);
    }

    @Override
    public void onSubCategorySelect(SubCategory subCategory) {
        toolbar.setTitle(subCategory.getName());
        if (currentFragment != null)
            showFragment(ProductsFragment.class, currentFragment.getTag());
        else
            showFragment(ProductsFragment.class);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onProductSelect(Product product) {
        showFragment(ProductFragment.class, currentFragment.getTag());
    }
}
