package io.maerlyn.musicplayer;

import java.io.Serializable;

/**
 * This class is used to store information about a song.
 * Serializable is implemented so we can pass an object as an extra in an intent.
 *
 * @author Maerlyn Broadbent
 * @see Album
 */
class Song implements Serializable {
    private int trackNum;
    private String title;
    private final String startTime = "00:00";
    private String endTime;

    public Song(int trackNum, String title, String length) {
        this.trackNum = trackNum;
        this.title = title;
        this.endTime = length;
    }

    public int getTrackNum() {
        return trackNum;
    }

    public String getTitle() {
        return title;
    }

    public String getStartTime() { return startTime; }

    public String getEndTime() {
        return endTime;
    }
}
