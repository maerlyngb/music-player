package io.maerlyn.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This adapter is responsible for drawing each item in the album grid
 *
 * @author Maerlyn Broadbent
 */
public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Activity context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Context context = getContext();

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.album_list, parent, false);
        }

        // get the current album
        Album album = getItem(position);

        LinearLayout albumContainer = listItemView.findViewById(R.id.library_item_container);

        // Create an onClickListener to allow the user to go to the album detail page
        albumContainer.setOnClickListener(view -> {

            // Explicit intent to display the album activity
            Intent albumIntent = new Intent(context, AlbumActivity.class);

            // pass the album data to the activity.
            // this means we can have more generic classes and cleaner code.
            albumIntent.putExtra("album", album);

            // go the album detail screen
            context.startActivity(albumIntent);
        });

        // Album Art
        ImageView albumArt = listItemView.findViewById(R.id.album_art);
        albumArt.setImageResource(album.getArtResourceId());

        // Album Name
        TextView albumName = listItemView.findViewById(R.id.album_name);
        albumName.setText(album.getName());

        // Album Artist
        TextView albumArtist = listItemView.findViewById(R.id.album_artist);
        albumArtist.setText(album.getArtist());

        return listItemView;
    }
}