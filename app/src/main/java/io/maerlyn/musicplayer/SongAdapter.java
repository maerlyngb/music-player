package io.maerlyn.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by maerlyn on 14/11/17.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    int playingSong;
    private Album album;

    public SongAdapter(Activity context, Album album, int playingSong) {
        super(context, 0, album.getSongs());
        this.album = album;
        this.playingSong = playingSong;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Context context = getContext();

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.song_list, parent, false);
        }

        // Current Song
        Song song = getItem(position);

        // Song Number
        TextView songNumber = listItemView.findViewById(R.id.song_number);
        songNumber.setText(String.valueOf(song.getTrackNum()));

        // Song Name
        TextView songTitle = listItemView.findViewById(R.id.song_name);
        songTitle.setText(song.getTitle());

        // Song Length
        TextView songEndTime = listItemView.findViewById(R.id.song_length);
        songEndTime.setText(song.getEndTime());

        // is this song currently being played?
        if (position == playingSong) {
            View finalListItemView = listItemView;

            // generate a highlight colour based on the album art
            Palette.PaletteAsyncListener paletteListener = palette -> {
                int defaultColour = context.getResources().getColor(R.color.colorPrimaryLight);
                finalListItemView.setBackgroundColor(palette.getLightMutedColor(defaultColour));
            };

            Bitmap myBitmap = BitmapFactory.decodeResource(context.getResources(), album.getArtResourceId());
            if (myBitmap != null && !myBitmap.isRecycled()) {
                Palette.from(myBitmap).generate(paletteListener);
            }

        } else {
            listItemView.setBackgroundColor(context.getResources().getColor(R.color.white));
        }

        return listItemView;
    }
}