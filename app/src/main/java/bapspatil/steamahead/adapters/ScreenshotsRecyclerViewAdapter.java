package bapspatil.steamahead.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

import bapspatil.steamahead.R;
import bapspatil.steamahead.model.Screenshots;
import bapspatil.steamahead.utils.GlideApp;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bapspatil
 */

public class ScreenshotsRecyclerViewAdapter extends RecyclerView.Adapter<ScreenshotsRecyclerViewAdapter.ScreenshotViewHolder> {
    List<Screenshots> mScreenshots;
    Context mContext;

    public ScreenshotsRecyclerViewAdapter(Context context, List<Screenshots> screenshots) {
        this.mContext = context;
        this.mScreenshots = screenshots;
    }

    @Override
    public ScreenshotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_screenshot_item, parent, false);
        return new ScreenshotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScreenshotViewHolder holder, int position) {
        Screenshots screenshot = mScreenshots.get(position);
        GlideApp.with(mContext)
                .load(screenshot.getPath_thumbnail())
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .fallback(R.drawable.placeholder)
                .transition(new DrawableTransitionOptions().crossFade())
                .into(holder.mScreenshotImageView);
    }

    @Override
    public int getItemCount() {
        return mScreenshots.size();
    }

    public class ScreenshotViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.screenshot_iv) ImageView mScreenshotImageView;

        public ScreenshotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
