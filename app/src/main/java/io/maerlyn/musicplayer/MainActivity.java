package io.maerlyn.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * This activity is the initial view for the user and displays a grid of albums
 *
 * @author Maerlyn Broadbent
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get our album data and display it on screen
        displayAlbumGrid(getAlbums());
    }

    /**
     * display a grid of albums
     *
     * @param albumList to be displayed to the user
     */
    private void displayAlbumGrid(ArrayList<Album> albumList) {
        GridView gridView = findViewById(R.id.library_grid);
        gridView.setAdapter(new AlbumAdapter(this, albumList));

    }

    /**
     * Load and return album data.
     *
     * @return an ArrayList of Albums
     */
    private ArrayList<Album> getAlbums() {
        ArrayList<Album> albumList = new ArrayList<>();

        List<Song> elSongs = new ArrayList<>();
        elSongs.add(new Song(1, "And the Gods Made Love", "1:21"));
        elSongs.add(new Song(2, "Have You Ever Been (To Electric Ladyland)", "2:11"));
        elSongs.add(new Song(3, "Crosstown Traffic", "2:25"));
        elSongs.add(new Song(4, "Voodoo Chile", "15:00"));
        elSongs.add(new Song(5, "Little Miss Strange", "2:25"));
        elSongs.add(new Song(6, "Long Hot Summer Night", "3:27"));
        elSongs.add(new Song(7, "Come On (Part I)", "4:09"));
        elSongs.add(new Song(8, "Gypsy Eyes", "3:43"));
        elSongs.add(new Song(9, "Burning of the Midnight Lamp", "3:39"));
        elSongs.add(new Song(10, "Rainy Day, Dream Away", "3:42"));
        elSongs.add(new Song(11, "1983... (A Merman I Should Turn to Be)", "13:39"));
        elSongs.add(new Song(12, "Moon, Turn the Tides...Gently Gently Away", "1:02"));
        elSongs.add(new Song(13, "Still Raining, Still Dreaming", "4:25"));
        elSongs.add(new Song(14, "House Burning Down", "4:33"));
        elSongs.add(new Song(15, "All Along the Watchtower", "4:01"));
        elSongs.add(new Song(16, "Voodoo Child (Slight Return)", "5:12"));
        albumList.add(new Album("Electric Ladyland", "The Jimi Hendrix Experience", elSongs, R.drawable.electric_ladyland));


        List<Song> nevSongs = new ArrayList<>();
        nevSongs.add(new Song(1, "Smells Like Teen Spirit", "5:01"));
        nevSongs.add(new Song(2, "In Bloom", "4:15"));
        nevSongs.add(new Song(3, "Come as You Are", "3:38"));
        nevSongs.add(new Song(4, "Breed", "3:04"));
        nevSongs.add(new Song(5, "Lithium", "4:17"));
        nevSongs.add(new Song(6, "Polly", "2:53"));
        nevSongs.add(new Song(7, "Territorial Pissings", "2:22"));
        nevSongs.add(new Song(8, "Drain You", "3:43"));
        nevSongs.add(new Song(9, "Lounge Act", "2:36"));
        nevSongs.add(new Song(10, "Stay Away", "3:31"));
        nevSongs.add(new Song(11, "On a Plain", "3:14"));
        nevSongs.add(new Song(12, "Something in the Way", "3:52"));
        nevSongs.add(new Song(13, "Endless, Nameless", "6:43"));
        albumList.add(new Album("Nevermind", "Nirvana", nevSongs, R.drawable.nervermind));

        List<Song> paraSongs = new ArrayList<>();
        paraSongs.add(new Song(1, "War Pigs", "7:57"));
        paraSongs.add(new Song(2, "Paranoid", "2:48"));
        paraSongs.add(new Song(3, "Planet Caravan", "4:32"));
        paraSongs.add(new Song(4, "Iron Man", "5:56"));
        paraSongs.add(new Song(5, "Electric Funeral", "4:53"));
        paraSongs.add(new Song(6, "Hand of Doom", "7:08"));
        paraSongs.add(new Song(7, "Rat Salad", "2:30"));
        paraSongs.add(new Song(8, "Fairies Wear Boots", "6:15"));
        albumList.add(new Album("Paranoid", "Black Sabbath", paraSongs, R.drawable.paranoid));

        List<Song> catSongs = new ArrayList<>();
        catSongs.add(new Song(1, "Concrete Jungle", "4:13"));
        catSongs.add(new Song(2, "Slave Driver", "2:54"));
        catSongs.add(new Song(3, "400 Years", "2:45"));
        catSongs.add(new Song(4, "Stop That Train", "3:54"));
        catSongs.add(new Song(5, "Baby We've Got a Date (Rock It Baby)", "3:55"));
        catSongs.add(new Song(6, "Stir It Up", "5:32"));
        catSongs.add(new Song(7, "Kinky Reggae", "3:37"));
        catSongs.add(new Song(8, "No More Trouble", "3:58"));
        catSongs.add(new Song(9, "Midnight Ravers", "5:08"));
        albumList.add(new Album("Catch a Fire", "Bob Marley and The Wailers", catSongs, R.drawable.catch_a_fire));

        List<Song> metSongs = new ArrayList<>();
        metSongs.add(new Song(1, "Enter Sandman", "5:29"));
        metSongs.add(new Song(2, "Sad but True", "5:24"));
        metSongs.add(new Song(3, "Holier Than Thou", "3:47"));
        metSongs.add(new Song(4, "The Unforgiven", "6:26"));
        metSongs.add(new Song(5, "Wherever I May Roam", "6:42"));
        metSongs.add(new Song(6, "Don't Tread on Me", "3:59"));
        metSongs.add(new Song(7, "Through the Never", "4:01"));
        metSongs.add(new Song(8, "Nothing Else Matters", "6:29"));
        metSongs.add(new Song(9, "Of Wolf and Man", "4:16"));
        metSongs.add(new Song(10, "The God That Failed", "5:05"));
        metSongs.add(new Song(11, "My Friend of Misery", "6:47"));
        metSongs.add(new Song(12, "The Struggle Within", "3:51"));
        albumList.add(new Album("Metallica", "Metallica", metSongs, R.drawable.metallica));

        List<Song> numSongs = new ArrayList<>();
        numSongs.add(new Song(1, "Invaders", "3:20"));
        numSongs.add(new Song(2, "Children of the Damned", "4:34"));
        numSongs.add(new Song(3, "The Prisoner", "5:34"));
        numSongs.add(new Song(4, "22 Acacia Avenue", "6:34"));
        numSongs.add(new Song(1, "The Number of the Beast", "4:25"));
        numSongs.add(new Song(2, "Run to the Hills", "3:50"));
        numSongs.add(new Song(3, "Gangland", "3:46"));
        numSongs.add(new Song(4, "Hallowed Be Thy Name", "7:08"));
        albumList.add(new Album("The Number of the Beast", "Iron Maiden", numSongs, R.drawable.number_of_the_beast));

        return albumList;
    }
}
