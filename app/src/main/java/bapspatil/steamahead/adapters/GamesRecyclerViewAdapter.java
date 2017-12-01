package bapspatil.steamahead.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

import bapspatil.steamahead.R;
import bapspatil.steamahead.model.Game;
import bapspatil.steamahead.utils.GlideApp;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bapspatil
 */

public class GamesRecyclerViewAdapter extends RecyclerView.Adapter<GamesRecyclerViewAdapter.GamesViewHolder> {
    private List<Game> mGamesList;
    private List<Integer> mPlayers;
    private Context mContext;
    private OnGameClickListener mClickListener;

    public GamesRecyclerViewAdapter(Context context, List<Game> gamesList, List<Integer> players, OnGameClickListener clickListener) {
        this.mContext = context;
        this.mGamesList = gamesList;
        this.mPlayers = players;
        this.mClickListener = clickListener;
    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_game_item, parent, false);
        return new GamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {
        holder.mGameTitleTextView.setText(mGamesList.get(position).getData().getName());
        holder.mPlayersTextView.setText(String.valueOf(mPlayers.get(position)));
        GlideApp.with(mContext)
                .load(mGamesList.get(position).getData().getBackground())
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .fallback(R.drawable.placeholder)
                .transition(new DrawableTransitionOptions().crossFade())
                .into(holder.mGameThumbnailImageView);
    }

    @Override
    public int getItemCount() {
        return mGamesList.size();
    }

    public class GamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.game_thumbnail_iv) ImageView mGameThumbnailImageView;
        @BindView(R.id.game_tv) TextView mGameTitleTextView;
        @BindView(R.id.players_tv) TextView mPlayersTextView;

        public GamesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mClickListener.onGameClicked(mGamesList.get(getAdapterPosition()));
        }
    }

    public interface OnGameClickListener {
        void onGameClicked(Game game);
    }
}
