package no.shortcut.materialtest.main.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import no.shortcut.materialtest.R;
import no.shortcut.materialtest.main.model.User;
import no.shortcut.materialtest.main.model.userContainer;
import no.shortcut.materialtest.main.presenter.UserPresenter;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements IMainView, NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG="MainActivity";

    @Bind(R.id.textView1)
    TextView textView1;
    //Variables

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.drawer)
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private UserPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //toolbar.
        setSupportActionBar(toolbar);
        //navigationview..
        navigationView.setNavigationItemSelectedListener(this);
        //drawerlayout
        drawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.openDrawer(GravityCompat.START);

        presenter = new UserPresenter(this);
        presenter.loadUserData("testing");

    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.openDrawer,  R.string.closeDrawer);
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

        TextView txtName = (TextView)navigationView.findViewById(R.id.txtUsername);txtName.setText(currentUser.getName());
        TextView txtPlayCount = (TextView)navigationView.findViewById(R.id.txtPlayCount);txtPlayCount.setText("playcount: "+currentUser.getPlaycount());
        CircleImageView imgProfile = (CircleImageView) navigationView.findViewById(R.id.profile_image);
        List<User.ImageInfo> images = currentUser.getImages();
        String imageUrl= images.get(2).getImageUrl();
        Picasso.with(this).load(imageUrl).into(imgProfile);
    }

    @Override
    public void onUserLoadFailure(Throwable error) {
        Log.d(TAG, "onUserLoadFailure: "+error);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.isChecked()) item.setChecked(false);
        else item.setChecked(true);

        //drawerLayout.closeDrawers();

        switch (item.getItemId()) {
            case R.id.gallery:
                Toast.makeText(this.getApplicationContext(),"Showing Gallery",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.profile:
                Toast.makeText(this.getApplicationContext(),"Showing Profile",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(this.getApplicationContext(),"Showing About",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return true;
        }
    }
}
