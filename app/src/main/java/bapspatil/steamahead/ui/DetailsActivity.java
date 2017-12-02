package bapspatil.steamahead.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import bapspatil.steamahead.R;
import bapspatil.steamahead.adapters.ScreenshotsRecyclerViewAdapter;
import bapspatil.steamahead.model.GameData;
import bapspatil.steamahead.utils.GlideApp;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.background_iv) ImageView mBackgroundImageView;
    @BindView(R.id.game_title_tv) TextView mGameTitleTextView;
    @BindView(R.id.description_tv) TextView mDescriptionTextView;
    @BindView(R.id.score_tv) TextView mScoreTextView;
    @BindView(R.id.date_tv) TextView mDateTextView;
    @BindView(R.id.screenshots_rv) RecyclerView mScreenshotsRecyclerView;

    private Context mContext;
    private ScreenshotsRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        GameData gameData = intent.getParcelableExtra("GAME");

        GlideApp.with(mContext)
                .load(gameData.getHeader_image())
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .fallback(R.drawable.placeholder)
                .into(mBackgroundImageView);
        mGameTitleTextView.setText(gameData.getName());

        String htmlDescription = gameData.getDetailed_description();
        Document document = Jsoup.parse(htmlDescription);
        String description = document.body().text();
        mDescriptionTextView.setText(description);

        if (gameData.getMetacritic() != null)
            mScoreTextView.setText(String.valueOf(gameData.getMetacritic().getScore()));
        else
            mScoreTextView.setText("75");
        if (gameData.getRelease_date() != null)
            mDateTextView.setText(gameData.getRelease_date().getDate());

        mAdapter = new ScreenshotsRecyclerViewAdapter(mContext, gameData.getScreenshots());
        mScreenshotsRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mScreenshotsRecyclerView.setLayoutManager(layoutManager);
    }
}
