package kg.itrun.android.aaa;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import kg.itrun.android.aaa.data.Category;
import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.data.SubCategory;
import kg.itrun.android.aaa.view.fragments.BasketFragment;
import kg.itrun.android.aaa.view.fragments.CategoryFragment;
import kg.itrun.android.aaa.view.fragments.FavoriteFragment;
import kg.itrun.android.aaa.view.fragments.HistoryFragment;
import kg.itrun.android.aaa.view.fragments.MoreNewsFragment;
import kg.itrun.android.aaa.view.fragments.NewsFragment;
import kg.itrun.android.aaa.view.fragments.PersonalFragment;
import kg.itrun.android.aaa.view.fragments.ProductFragment;
import kg.itrun.android.aaa.view.fragments.ProductsFragment;
import kg.itrun.android.aaa.view.fragments.PromoFragment;
import kg.itrun.android.aaa.view.fragments.SubCategoryFragment;
import kg.itrun.android.aaa.view.fragments.SupportFragment;

public class MainActivity extends AppActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    private Toolbar toolbar;
    private FloatingActionButton fabShoppingCart;

    public MainActivity() {
        super(R.id.frame_layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabShoppingCart = findViewById(R.id.fabShoppingCart);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        showFragment(ProductsFragment.class);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            showFragment(ProductsFragment.class);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return getCurrentFragment().onSearch(query);
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    getCurrentFragment().onSearch("");
                }
                return false;
            }
        });
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
                showFragment(FavoriteFragment.class);
                break;
            case R.id.nav_personal_cabinet:
                toolbar.setTitle(R.string.menu_personal_cabinet);
                System.out.println("PERSONAL CABINET");
                showFragment(PersonalFragment.class);
                break;
            case R.id.nav_purchase_history:
                toolbar.setTitle(R.string.menu_purchase_history);
                System.out.println("PURCHASE HISTORY");
                showFragment(HistoryFragment.class);
                break;
            case R.id.nav_chat:
                toolbar.setTitle(R.string.menu_chat);
                System.out.println("CHAT");
                showFragment(SupportFragment.class);
                break;

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onCategorySelected(Category category) {
        toolbar.setTitle(category.getName());
        Bundle bundle = new Bundle();
        bundle.putInt(AppStatics.CATEGORY_ID, category.getId());
        if (getCurrentFragment() != null) {
            showFragment(SubCategoryFragment.class, getCurrentFragment().getTag(), bundle);
        } else
            showFragment(SubCategoryFragment.class, null, bundle);
    }

    public void onSubCategorySelected(SubCategory subCategory) {
        toolbar.setTitle(subCategory.getName());
        if (getCurrentFragment() != null)
            showFragment(ProductsFragment.class, getCurrentFragment().getTag());
        else
            showFragment(ProductsFragment.class);
    }


    private void startAuthorization(int action) {
        Intent intent = new Intent(this, AuthorizationActivity.class);
        intent.putExtra(AppStatics.ACTION, action);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabShoppingCart:
                if (getCurrentFragment() != null)
                    showFragment(BasketFragment.class, getCurrentFragment().getTag());
                else
                    showFragment(BasketFragment.class);
                toolbar.setTitle(getString(R.string.basket));
                break;
        }
    }

    public void onProductSelect(Product product) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppStatics.PRODUCT, product);
        showFragment(ProductFragment.class, getCurrentFragment().getTag(), bundle);
    }


    @Override
    public void onAction(Bundle bundle) {
        int action = bundle.getInt(AppStatics.ACTION);
        switch (action) {
            case AppStatics.CATEGORY_SELECTED:
                Category category = (Category) bundle.get(AppStatics.CATEGORY);
                onCategorySelected(category);
                break;
            case AppStatics.SUBCATEGORY_SELECTED:
                SubCategory subCategory = (SubCategory) bundle.get(AppStatics.CATEGORY);
                onSubCategorySelected(subCategory);
                break;
            case AppStatics.PRODUCT_SELECTED:
                Product product = (Product) bundle.get(AppStatics.PRODUCT);
                onProductSelect(product);
                break;
            case AppStatics.PAY_CLICKED:
                startAuthorization(AppStatics.LOGIN);
                break;
            case AppStatics.NEWS_CLICKED:
                showFragment(MoreNewsFragment.class, getCurrentFragment().getTag(), bundle);
                break;
        }
    }
}
