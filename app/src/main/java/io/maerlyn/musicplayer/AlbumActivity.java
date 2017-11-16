package io.maerlyn.musicplayer;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Display a song list for a given album to allow the user to choose which song to play
 *
 * @author Maerlyn Broadbent
 */
public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        // load the album data that was passed as an intent extra.
        Intent intent = getIntent();
        Album album = (Album) intent.getSerializableExtra("album");

        // Album Art
        ImageView albumArt = findViewById(R.id.album_art);
        albumArt.setImageResource(album.getArtResourceId());

        // Album Name
        TextView albumName = findViewById(R.id.album_name);
        albumName.setText(album.getName());

        // Artist Name
        TextView artistName = findViewById(R.id.artist_name);
        artistName.setText(album.getArtist());

        // Adapter to display the details for each song
        SongAdapter songAdapter = new SongAdapter(this, album, -1);

        ListView listView = findViewById(R.id.song_list);
        listView.setAdapter(songAdapter);

        FloatingActionButton shuffle = findViewById(R.id.shuffle_album);
        shuffle.setOnClickListener(view -> {

            // explicit intent to open the player activity
            Intent playSongIntent = new Intent(this, PlayerActivity.class);

            // radomise song order
            album.shuffleSongs();

            // start at random song index
            int songIndex = ThreadLocalRandom.current().nextInt(0, album.getSongs().size());


            // pass the album and song index with the intent
            playSongIntent.putExtra("album", album);
            playSongIntent.putExtra("songIndex", songIndex);

            this.startActivity(playSongIntent);
        });

        // create an onclick listener for each song to play that song
        listView.setOnItemClickListener((adapterView, view, i, l) -> {

            // explicit intent to open the player activity
            Intent playSongIntent = new Intent(this, PlayerActivity.class);

            // pass the album and song index with the intent
            playSongIntent.putExtra("album", album);
            playSongIntent.putExtra("songIndex", i);

            this.startActivity(playSongIntent);
        });

        // generate a colour based on album art and use it as a background for the titles
        Palette.PaletteAsyncListener paletteListener = palette -> {
            int defaultColour = getResources().getColor(R.color.colorPrimaryDark);
            int defaultVibrantColour = getResources().getColor(R.color.colorAccent);
            albumName.setBackgroundColor(palette.getMutedColor(defaultColour));
            artistName.setBackgroundColor(palette.getMutedColor(defaultColour));
            shuffle.setBackgroundTintList(ColorStateList.valueOf(palette.getLightVibrantColor(defaultVibrantColour)));
        };

        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), album.getArtResourceId());
        if (myBitmap != null && !myBitmap.isRecycled()) {
            Palette.from(myBitmap).generate(paletteListener);
        }
    }
}
