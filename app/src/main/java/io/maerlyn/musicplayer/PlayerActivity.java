package io.maerlyn.musicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

    private Album album;
    private Song song;
    private int songIndex;
    private boolean isPlaying = true;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.bringToFront();

        // Get a support ActionBar corresponding to this toolbar
        ActionBar actionBar = getSupportActionBar();

        // Enable the Up button
        actionBar.setDisplayHomeAsUpEnabled(true);

        // load the song data that was passed as an intent extra.
        Intent intent = getIntent();

        // load the album data that was passed as an intent extra.
        this.album = (Album) intent.getSerializableExtra("album");

        // load the song index
        this.songIndex = (int) intent.getSerializableExtra("songIndex");

        // song tha the user requested to play
        this.song = album.getSongs().get(songIndex);

        // display album data to the user
        loadViewContent();
    }

    /**
     * Display album data to the user
     */
    private void loadViewContent() {
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

        ImageView playPauseBtn = findViewById(R.id.play_pause_icon);
        playPauseBtn.setOnClickListener(view -> {
            playPauseSong(playPauseBtn);
        });

        // create an onclick listener for each song to play that song
        listView.setOnItemClickListener((adapterView, view, i, l) ->
                songClicked(adapterView, view, i, songName));

        // select the playing song from the list
        listView.setSelection(songIndex);
    }

    /**
     * Pause a song if playing, play if paused
     *
     * @param playPauseBtn button to change icon depending on play state
     */
    private void playPauseSong(ImageView playPauseBtn) {
        int icon;
        isPlaying = !isPlaying;

        if (isPlaying){
            icon = R.drawable.ic_pause_circle_outline;
            showToast("playing");
        } else {
            icon = R.drawable.ic_play_circle_outline;
            showToast("paused");
        }

        playPauseBtn.setImageResource(icon);
    }

    /**
     * Display song as playing
     *
     * @param adapterView parent view
     * @param view        song that was clicked
     * @param i           index of the clicked view
     * @param songName    TextView to update with current playing song
     */
    private void songClicked(AdapterView<?> adapterView, View view, int i, TextView songName) {

        Song songToPlay = album.getSongs().get(i);

        // set title to title of the song just pressed
        songName.setText(songToPlay.getTitle());

        // reset all background colours to white
        for (int itemIndex = 0; itemIndex < adapterView.getChildCount(); itemIndex++) {
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
    }

    /**
     * Display a toast message
     * <p>
     * If a toast is already being displayed, cancel it and display a new one.
     *
     * @param msg to display in the toast
     */
    private void showToast(String msg) {
        if (toast != null) {
            toast.cancel();
        }

        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}
