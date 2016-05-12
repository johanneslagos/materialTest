package no.shortcut.materialtest.main.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import no.shortcut.materialtest.R;
import no.shortcut.materialtest.main.app.BaseActivity;

public class AlbumDetailActivity extends BaseActivity {

    public static final String EXTRA_IMAGE = "image_album";
    public static final String ALBUM_IMAGE_URL = "album_image_url";
    public static final String ALBUM_MBID = "album_mbid";
    public static final String ALBUM_NAME = "album_name";

    Activity activity;
    String imageUrl;
    String albumMbid;
    String albumName;

    @Bind(R.id.image_album)
    ImageView imgAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);
        ButterKnife.bind(this);

        activity = this;

        imageUrl = getIntent().getExtras().getString(ALBUM_IMAGE_URL);
        albumMbid = getIntent().getExtras().getString(ALBUM_MBID);
        albumName = getIntent().getExtras().getString(ALBUM_NAME);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        ViewCompat.setTransitionName(imgAlbum, EXTRA_IMAGE);
//        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE);

        if (!TextUtils.isEmpty(imageUrl)){
            Picasso.with(this)
                    .load(imageUrl)
                    .error(R.drawable.album_placeholder)
                    .into(imgAlbum);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(albumName);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorPrimary));

    }

}
