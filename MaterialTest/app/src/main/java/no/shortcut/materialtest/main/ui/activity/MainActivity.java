package no.shortcut.materialtest.main.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import no.shortcut.materialtest.R;
import no.shortcut.materialtest.main.app.BaseActivity;
import no.shortcut.materialtest.main.model.ImageInfo;
import no.shortcut.materialtest.main.model.User;
import no.shortcut.materialtest.main.model.userContainer;
import no.shortcut.materialtest.main.presenter.UserPresenter;
import no.shortcut.materialtest.main.ui.adapter.ViewPagerAdapter;
import no.shortcut.materialtest.main.ui.fragment.ArtistPlaylistFragment;
import no.shortcut.materialtest.main.ui.fragment.ArtistProfileFragment;
import no.shortcut.materialtest.main.ui.fragment.UserTopAlbumsFragment;
import no.shortcut.materialtest.main.ui.view.IMainView;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements IMainView, NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    //Variables

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.drawer)
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Bind(R.id.tabs)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        setContentView(view);
        ButterKnife.bind(this);

        //setContentView(R.layout.activity_main);

        //toolbar.
        setSupportActionBar(toolbar);
        //navigationview..
        navigationView.setNavigationItemSelectedListener(this);
        //drawerlayout
        drawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.openDrawer(GravityCompat.START);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        presenter = new UserPresenter(this);
        presenter.loadUserData("johannesla");

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ArtistPlaylistFragment(), "Playlist");
        adapter.addFragment(new UserTopAlbumsFragment(), "Top Albums");
        viewPager.setAdapter(adapter);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onUserLoadSuccess(userContainer user, Response response) {

        User currentUser = user.getUser();

        TextView txtName = (TextView) navigationView.findViewById(R.id.txtUsername);
        TextView txtPlayCount = (TextView) navigationView.findViewById(R.id.txtPlayCount);
        CircleImageView imgProfile = (CircleImageView) navigationView.findViewById(R.id.profile_image);

        if (user.getUser() != null) {
            txtName.setText(currentUser.getName());
            txtPlayCount.setText("playcount: " + currentUser.getPlaycount());
            List<ImageInfo> images = currentUser.getImages();
            String imageUrl = images.get(2).getImageUrl();
            Picasso.with(this).load(imageUrl).into(imgProfile);
        }
    }

    @Override
    public void onUserLoadFailure(Throwable error) {
        Log.d(TAG, "onUserLoadFailure: " + error);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.isChecked()) item.setChecked(false);
        else item.setChecked(true);
        Fragment fragment = null;
        Class fragmentClass;

        //drawerLayout.closeDrawers();
        switch (item.getItemId()) {
            case R.id.profile:
                fragmentClass = ArtistProfileFragment.class;
                break;
            case R.id.about:
                Toast.makeText(this.getApplicationContext(), "Showing About", Toast.LENGTH_SHORT).show();
                return true;
            default:
                fragmentClass = ArtistPlaylistFragment.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //Inserting fragments...
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();

//        menuItem.setChecked(true);
//        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
        return true;
    }
}
