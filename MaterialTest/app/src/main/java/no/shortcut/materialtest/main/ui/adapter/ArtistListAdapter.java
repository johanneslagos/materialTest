package no.shortcut.materialtest.main.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import no.shortcut.materialtest.R;
import no.shortcut.materialtest.main.model.Artist;

/**
 * Created by Sijan Gurung on 19/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ViewHolder> {
    private ArrayList<Artist> mDataset;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtArtistName;
        public ImageView imgArtist;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            txtArtistName = (TextView) itemView.findViewById(R.id.txtArtistName);
            imgArtist =(ImageView) itemView.findViewById(R.id.artistImg);
            this.view = itemView;
        }
    }

    public ArtistListAdapter() { mDataset = new ArrayList<Artist>();}
    public ArtistListAdapter(ArrayList<Artist> mDataset) { this.mDataset = mDataset;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View modelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.artistplaceholder,parent,false);
        return new ViewHolder(modelView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist artist = mDataset.get(position);
        holder.txtArtistName.setText(artist.getName());
        Picasso.with(holder.view.getContext())
                .load(artist.getImages().get(3).getImageUrl())
                .into(holder.imgArtist);
    }

    @Override
    public int getItemCount() {return mDataset.size(); }

}
