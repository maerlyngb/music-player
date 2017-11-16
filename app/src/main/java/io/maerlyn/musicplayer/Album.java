package io.maerlyn.musicplayer;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to store information about an album including a list of it's songs.
 * Serializable is implemented so we can pass an instance as an extra in an intent.
 *
 * @author Maerlyn Broadbent
 * @see Song
 */
class Album implements Serializable {
    private String name;
    private String artist;
    private int artResourceId;
    private List<Song> songs;

    public Album(String name, String artist, List<Song> songs, int artResourceId) {
        this.name = name;
        this.artist = artist;
        this.songs = songs;
        this.artResourceId = artResourceId;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getArtResourceId() {
        return artResourceId;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void shuffleSongs() {
        Collections.shuffle(songs);
    }
}
