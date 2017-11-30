package bapspatil.steamahead.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by bapspatil
 */

public class GamesRecyclerViewAdapter extends RecyclerView.Adapter<GamesRecyclerViewAdapter.GamesViewHolder> {
    private List<String> mGamesList;
    private Context mContext;
    private OnGameClickListener mClickListener;

    public GamesRecyclerViewAdapter(Context context, List<String> gamesList, OnGameClickListener clickListener) {
        this.mContext = context;
        this.mGamesList = gamesList;
        this.mClickListener = clickListener;
    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mGamesList.size();
    }

    public class GamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public GamesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View view) {
            mClickListener.onGameClicked(mGamesList.get(getAdapterPosition()));
        }
    }

    public interface OnGameClickListener {
        void onGameClicked(String gameId);
    }
}
