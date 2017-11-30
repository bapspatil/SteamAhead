package bapspatil.steamahead.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bapspatil.steamahead.R;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
    }
}
