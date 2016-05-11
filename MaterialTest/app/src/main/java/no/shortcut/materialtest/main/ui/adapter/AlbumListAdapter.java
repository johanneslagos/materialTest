package no.shortcut.materialtest.main.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import no.shortcut.materialtest.R;
import no.shortcut.materialtest.main.model.Album.Album;

/**
 * Created by Sijan Gurung on 19/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Album> mDataset;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAlbumName;
        public ImageView imgAlbum;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            txtAlbumName = (TextView) itemView.findViewById(R.id.text_album_name);
            imgAlbum = (ImageView) itemView.findViewById(R.id.image_album);
            this.view = itemView;
        }

        public void render(final ViewHolder holder, Album album) {
            holder.txtAlbumName.setText((TextUtils.isEmpty(album.getName()) ? "" : album.getName()));
            if(album.getImages() != null && album.getImages().size() == 4 && !TextUtils.isEmpty(album.getImages().get(3).getImageUrl())) {
                Picasso.with(holder.view.getContext())
                        .load(album.getImages().get(3).getImageUrl())
                        .placeholder(R.drawable.album_placeholder)
                        .error(R.drawable.album_placeholder)
                        .into(holder.imgAlbum);

                Palette.from(((BitmapDrawable)holder.imgAlbum.getDrawable()).getBitmap()).generate(
                new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch vibrantSwatch =
                                palette.getVibrantSwatch();
                        if (vibrantSwatch != null) {
                            holder.txtAlbumName.setBackgroundColor(
                                    vibrantSwatch.getRgb());
                            holder.txtAlbumName.setTextColor(
                                    vibrantSwatch.getTitleTextColor());
                        }
                    }
                });
            }else{
                holder.imgAlbum.setImageResource(R.drawable.album_placeholder);
            }
        }
    }

    public AlbumListAdapter(Context context, List<Album> mDataset) {
        this.context = context;
        this.mDataset = (ArrayList<Album>) mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album album = mDataset.get(position);
        holder.render(holder, album);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
