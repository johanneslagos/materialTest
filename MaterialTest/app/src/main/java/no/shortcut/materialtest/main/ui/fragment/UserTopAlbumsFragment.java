package no.shortcut.materialtest.main.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import no.shortcut.materialtest.R;
import no.shortcut.materialtest.main.app.BaseFragment;
import no.shortcut.materialtest.main.model.Album.Album;
import no.shortcut.materialtest.main.model.Album.TopAlbumsWrapper;
import no.shortcut.materialtest.main.presenter.AlbumPresenter;
import no.shortcut.materialtest.main.ui.activity.AlbumDetailActivity;
import no.shortcut.materialtest.main.ui.adapter.AlbumListAdapter;
import no.shortcut.materialtest.main.ui.view.IAlbumView;
import retrofit2.Response;

/**
 * Created by Waqas Moazzam on 10/05/16.
 * Shortcut AS
 * waqas.moazzam@shortcut.no
 */
public class UserTopAlbumsFragment extends BaseFragment implements IAlbumView, AlbumListAdapter.RecyclerViewClickListener {


    @Bind(R.id.topAlbumsList)
    RecyclerView albumRecyclerView;

    @Bind(R.id.progress)
    ProgressBar progressBar;

    AlbumPresenter presenter;

    public UserTopAlbumsFragment() {
    }
    public static Fragment newInstance(Context context){
        UserTopAlbumsFragment artistPlaylistFragment = new UserTopAlbumsFragment();
        return artistPlaylistFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.album_list,null);
        ButterKnife.bind(root);

        presenter = new AlbumPresenter(this);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        albumRecyclerView.setLayoutManager(layoutManager);
        presenter.loadUserTopAlbums("johannesla");

    }

    @Override
    public void onUserTopAlbumsSuccess(TopAlbumsWrapper topAlbums, Response response) {
        if(!this.isResumed()) return;
        progressBar.setVisibility(View.GONE);
        AlbumListAdapter adapter = new AlbumListAdapter(topAlbums.getAlbums().getUserTopAlbums(), this);
        albumRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onUserTopAlbumsFailure(Throwable error) {
        if(!this.isResumed()) return;
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Try again later", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(View v, Album album) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(), v.findViewById(R.id.image_album), AlbumDetailActivity.EXTRA_IMAGE);

        Intent intent = new Intent(getActivity(), AlbumDetailActivity.class);
        intent.putExtra(AlbumDetailActivity.ALBUM_IMAGE_URL, album.getImages().get(3).getImageUrl());
        intent.putExtra(AlbumDetailActivity.ALBUM_MBID, album.getMbid());
        intent.putExtra(AlbumDetailActivity.ALBUM_NAME, album.getName());

        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
    }
}
