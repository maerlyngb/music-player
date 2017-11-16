package io.maerlyn.musicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // load the song data that was passed as an intent extra.
        Intent intent = getIntent();

        // load the album data that was passed as an intent extra.
        Album album = (Album) intent.getSerializableExtra("album");

        // load the song index
        int songIndex = (int) intent.getSerializableExtra("songIndex");

        // song tha the user requested to play
        Song song = album.getSongs().get(songIndex);

        // Album Art
        ImageView albumArt = findViewById(R.id.album_art);
        albumArt.setImageResource(album.getArtResourceId());

        // Song Artist
        TextView artist = findViewById(R.id.song_artist);
        artist.setText(album.getArtist());

        // Song Name
        TextView songName = findViewById(R.id.song_name);
        songName.setText(song.getTitle());

        // Song Start Time
        TextView songStartTime = findViewById(R.id.song_start_time);
        songStartTime.setText(song.getStartTime());

        // Song End Time
        TextView songEndTime = findViewById(R.id.song_end_time);
        songEndTime.setText(song.getEndTime());

        SongAdapter songAdapter = new SongAdapter(this, album, songIndex);
        ListView listView = findViewById(R.id.song_list);
        listView.setAdapter(songAdapter);

        // create an onclick listener for each song to play that song
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Song songToPlay = album.getSongs().get(i);

            // set title to title of the song just pressed
            songName.setText(songToPlay.getTitle());

            // reset all background colours to white
            for (int itemIndex = 0; itemIndex < adapterView.getChildCount(); itemIndex++){
                View songView = adapterView.getChildAt(itemIndex);
                songView.setBackgroundColor(getResources().getColor(R.color.white));
            }

            // generate a highlight colour based on the album art
            Palette.PaletteAsyncListener paletteListener = palette -> {
                int defaultColour = getResources().getColor(R.color.colorPrimaryLight);
                view.setBackgroundColor(palette.getLightMutedColor(defaultColour));
            };

            Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), album.getArtResourceId());
            if (myBitmap != null && !myBitmap.isRecycled()) {
                Palette.from(myBitmap).generate(paletteListener);
            }
        });

        // select the playing song from the list
        listView.setSelection(songIndex);
    }
}
