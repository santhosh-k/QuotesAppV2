package net.santhoshk.quotesappv2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.santhoshk.quotesappv2.R;
import net.santhoshk.quotesappv2.model.Topic;

import java.util.List;

/**
 * Created by Sandy on 4/16/2017.
 */

public class MainListViewAdapter extends RecyclerView.Adapter<MainListViewAdapter.ListHolder> {

    LayoutInflater layoutInflater;
    Context mContext;
    List<Topic> topics;

    public MainListViewAdapter(List<Topic> topics, Context context) {
        this.mContext = context;
        this.topics = topics;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_view_item, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.getTitle().setText("Sample");
        holder.getSubTitle().setText("Subs");
    }

    @Override
    public int getItemCount() {
        return 35;
    }

    class ListHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;
        TextView subTitle;


        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(TextView subTitle) {
            this.subTitle = subTitle;
        }

        public ImageView getIcon() {
            return icon;
        }

        public void setIcon(ImageView icon) {
            this.icon = icon;
        }

        public ListHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.list_item_icon);

            title = (TextView) itemView.findViewById(R.id.list_item_title);
        }
    }

}
