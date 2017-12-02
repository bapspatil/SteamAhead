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
import bapspatil.steamahead.utils.GlideApp;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bapspatil
 */

public class GamesRecyclerViewAdapter extends RecyclerView.Adapter<GamesRecyclerViewAdapter.GamesViewHolder> {
    private List<String> mGameTitles;
    private List<String> mGameHeaderImages;
    private List<String> mGameIds;
    private List<Integer> mPlayers;
    private Context mContext;
    private OnGameClickListener mClickListener;

    public GamesRecyclerViewAdapter(Context context, List<String> gameTitles, List<String> gameHeaderImages, List<String> gameIds, List<Integer> players, OnGameClickListener clickListener) {
        this.mContext = context;
        this.mGameTitles = gameTitles;
        this.mGameHeaderImages = gameHeaderImages;
        this.mGameIds = gameIds;
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
        holder.mGameTitleTextView.setText(mGameTitles.get(position));
        holder.mPlayersTextView.setText(String.valueOf(mPlayers.get(position)));
        GlideApp.with(mContext)
                .load(mGameHeaderImages.get(position))
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .fallback(R.drawable.placeholder)
                .transition(new DrawableTransitionOptions().crossFade())
                .into(holder.mGameThumbnailImageView);
    }

    @Override
    public int getItemCount() {
        if(mGameTitles == null) return 0;
        else return mGameTitles.size();
    }

    public void setGames(List<String> gameTitles, List<String> gameHeaderImages, List<String> gameIds, List<Integer> players) {
        mGameTitles = gameTitles;
        mGameHeaderImages = gameHeaderImages;
        mGameIds = gameIds;
        mPlayers = players;
        if(gameTitles != null) {
            notifyItemRangeChanged(0, gameTitles.size());
            notifyDataSetChanged();
        }
    }

    public void setNumberOfPlayers(List<Integer> players) {
        mPlayers = players;
        if(players != null) {
            notifyItemRangeChanged(0, players.size());
            notifyDataSetChanged();
        }
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
            mClickListener.onGameClicked(mGameIds.get(getAdapterPosition()));
        }
    }

    public interface OnGameClickListener {
        void onGameClicked(String gameId);
    }
}
