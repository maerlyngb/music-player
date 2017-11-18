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
        elSongs.add(new Song(1, getString(R.string.el_jh_t1_name), getString(R.string.el_jh_t1_length)));
        elSongs.add(new Song(2, getString(R.string.el_jh_t2_name), getString(R.string.el_jh_t2_length)));
        elSongs.add(new Song(3, getString(R.string.el_jh_t3_name), getString(R.string.el_jh_t3_length)));
        elSongs.add(new Song(4, getString(R.string.el_jh_t4_name), getString(R.string.el_jh_t4_length)));
        elSongs.add(new Song(5, getString(R.string.el_jh_t5_name), getString(R.string.el_jh_t5_length)));
        elSongs.add(new Song(6, getString(R.string.el_jh_t6_name), getString(R.string.el_jh_t6_length)));
        elSongs.add(new Song(7, getString(R.string.el_jh_t7_name), getString(R.string.el_jh_t7_length)));
        elSongs.add(new Song(8, getString(R.string.el_jh_t8_name), getString(R.string.el_jh_t8_length)));
        elSongs.add(new Song(9, getString(R.string.el_jh_t9_name), getString(R.string.el_jh_t9_length)));
        elSongs.add(new Song(10, getString(R.string.el_jh_t10_name), getString(R.string.el_jh_t10_length)));
        elSongs.add(new Song(11, getString(R.string.el_jh_t11_name), getString(R.string.el_jh_t11_length)));
        elSongs.add(new Song(12, getString(R.string.el_jh_t12_name), getString(R.string.el_jh_t12_length)));
        elSongs.add(new Song(13, getString(R.string.el_jh_t13_name), getString(R.string.el_jh_t13_length)));
        elSongs.add(new Song(14, getString(R.string.el_jh_t14_name), getString(R.string.el_jh_t14_length)));
        elSongs.add(new Song(15, getString(R.string.el_jh_t15_name), getString(R.string.el_jh_t15_length)));
        elSongs.add(new Song(16, getString(R.string.el_jh_t16_name), getString(R.string.el_jh_t16_length)));
        albumList.add(new Album(getString(R.string.el_jh_title), getString(R.string.el_jh_artist), elSongs, R.drawable.el_jh));


        List<Song> nevSongs = new ArrayList<>();
        nevSongs.add(new Song(1, getString(R.string.n_n_t1_title), getString(R.string.n_n_t1_length)));
        nevSongs.add(new Song(2, getString(R.string.n_n_t2_title), getString(R.string.n_n_t2_length)));
        nevSongs.add(new Song(3, getString(R.string.n_n_t3_title), getString(R.string.n_n_t3_length)));
        nevSongs.add(new Song(4, getString(R.string.n_n_t4_title), getString(R.string.n_n_t4_length)));
        nevSongs.add(new Song(5, getString(R.string.n_n_t5_title), getString(R.string.n_n_t5_length)));
        nevSongs.add(new Song(6, getString(R.string.n_n_t6_title), getString(R.string.n_n_t6_length)));
        nevSongs.add(new Song(7, getString(R.string.n_n_t7_title), getString(R.string.n_n_t7_length)));
        nevSongs.add(new Song(8, getString(R.string.n_n_t8_title), getString(R.string.n_n_t8_length)));
        nevSongs.add(new Song(9, getString(R.string.n_n_t9_title), getString(R.string.n_n_t9_length)));
        nevSongs.add(new Song(10, getString(R.string.n_n_t10_title), getString(R.string.n_n_t10_length)));
        nevSongs.add(new Song(11, getString(R.string.n_n_t11_title), getString(R.string.n_n_t11_length)));
        nevSongs.add(new Song(12, getString(R.string.n_n_t12_title), getString(R.string.n_n_t12_length)));
        nevSongs.add(new Song(13, getString(R.string.n_n_t13_title), getString(R.string.n_n_t13_length)));
        albumList.add(new Album(getString(R.string.n_n_title), getString(R.string.n_n_artist), nevSongs, R.drawable.n_n));

        List<Song> paraSongs = new ArrayList<>();
        paraSongs.add(new Song(1, getString(R.string.p_bs_t1_name), getString(R.string.p_bs_t1_length)));
        paraSongs.add(new Song(2, getString(R.string.p_bs_t2_name), getString(R.string.p_bs_t2_length)));
        paraSongs.add(new Song(3, getString(R.string.p_bs_t3_name), getString(R.string.p_bs_t3_length)));
        paraSongs.add(new Song(4, getString(R.string.p_bs_t4_name), getString(R.string.p_bs_t4_length)));
        paraSongs.add(new Song(5, getString(R.string.p_bs_t5_name), getString(R.string.p_bs_t5_length)));
        paraSongs.add(new Song(6, getString(R.string.p_bs_t6_name), getString(R.string.p_bs_t6_length)));
        paraSongs.add(new Song(7, getString(R.string.p_bs_t7_name), getString(R.string.p_bs_t7_length)));
        paraSongs.add(new Song(8, getString(R.string.p_bs_t8_name), getString(R.string.p_bs_t8_length)));
        albumList.add(new Album(getString(R.string.p_bs_title), getString(R.string.p_bs_artist), paraSongs, R.drawable.p_bs));

        List<Song> catSongs = new ArrayList<>();
        catSongs.add(new Song(1, getString(R.string.cf_bm_t1_name), getString(R.string.cf_bm_t1_length)));
        catSongs.add(new Song(2, getString(R.string.cf_bm_t2_name), getString(R.string.cf_bm_t2_length)));
        catSongs.add(new Song(3, getString(R.string.cf_bm_t3_name), getString(R.string.cf_bm_t3_length)));
        catSongs.add(new Song(4, getString(R.string.cf_bm_t4_name), getString(R.string.cf_bm_t4_length)));
        catSongs.add(new Song(5, getString(R.string.cf_bm_t5_name), getString(R.string.cf_bm_t5_length)));
        catSongs.add(new Song(6, getString(R.string.cf_bm_t6_name), getString(R.string.cf_bm_t6_length)));
        catSongs.add(new Song(7, getString(R.string.cf_bm_t7_name), getString(R.string.cf_bm_t7_length)));
        catSongs.add(new Song(8, getString(R.string.cf_bm_t8_name), getString(R.string.cf_bm_t8_length)));
        catSongs.add(new Song(9, getString(R.string.cf_bm_t9_name), getString(R.string.cf_bm_t9_length)));
        albumList.add(new Album(getString(R.string.cf_bm_title), getString(R.string.cf_bm_artist), catSongs, R.drawable.cf_bm));

        List<Song> metSongs = new ArrayList<>();
        metSongs.add(new Song(1, getString(R.string.m_m_t1_name), getString(R.string.m_m_t1_length)));
        metSongs.add(new Song(2, getString(R.string.m_m_t2_name), getString(R.string.m_m_t2_length)));
        metSongs.add(new Song(3, getString(R.string.m_m_t3_name), getString(R.string.m_m_t3_length)));
        metSongs.add(new Song(4, getString(R.string.m_m_t4_name), getString(R.string.m_m_t4_length)));
        metSongs.add(new Song(5, getString(R.string.m_m_t5_name), getString(R.string.m_m_t5_length)));
        metSongs.add(new Song(6, getString(R.string.m_m_t6_name), getString(R.string.m_m_t6_length)));
        metSongs.add(new Song(7, getString(R.string.m_m_t7_name), getString(R.string.m_m_t7_length)));
        metSongs.add(new Song(8, getString(R.string.m_m_t8_name), getString(R.string.m_m_t8_length)));
        metSongs.add(new Song(9, getString(R.string.m_m_t9_name), getString(R.string.m_m_t9_length)));
        metSongs.add(new Song(10, getString(R.string.m_m_t10_name), getString(R.string.m_m_t10_length)));
        metSongs.add(new Song(11, getString(R.string.m_m_t11_name), getString(R.string.m_m_t11_length)));
        metSongs.add(new Song(12, getString(R.string.m_m_t12_name), getString(R.string.m_m_t12_length)));
        albumList.add(new Album(getString(R.string.m_m_title), getString(R.string.m_m_Artist), metSongs, R.drawable.m_m));

        List<Song> numSongs = new ArrayList<>();
        numSongs.add(new Song(1, getString(R.string.nb_im_t1_name), getString(R.string.nb_im_t1_title)));
        numSongs.add(new Song(2, getString(R.string.nb_im_t2_name), getString(R.string.nb_im_t2_title)));
        numSongs.add(new Song(3, getString(R.string.nb_im_t3_name), getString(R.string.nb_im_t3_title)));
        numSongs.add(new Song(4, getString(R.string.nb_im_t4_name), getString(R.string.nb_im_t4_title)));
        numSongs.add(new Song(1, getString(R.string.nb_im_t5_name), getString(R.string.nb_im_t5_title)));
        numSongs.add(new Song(2, getString(R.string.nb_im_t6_name), getString(R.string.nb_im_t6_title)));
        numSongs.add(new Song(3, getString(R.string.nb_im_t7_name), getString(R.string.nb_im_t7_title)));
        numSongs.add(new Song(4, getString(R.string.nb_im_t8_name), getString(R.string.nb_im_t8_title)));
        albumList.add(new Album(getString(R.string.nb_im_title), getString(R.string.nb_im_artist), numSongs, R.drawable.nb_im));

        return albumList;
    }
}
