package net.santhoshk.quotesappv2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.santhoshk.quotesappv2.R;
import net.santhoshk.quotesappv2.activity.MainActivity;
import net.santhoshk.quotesappv2.activity.TopicActivity;
import net.santhoshk.quotesappv2.model.Topic;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sandy on 4/16/2017.
 */

public class MainGridViewAdapter extends RecyclerView.Adapter<MainGridViewAdapter.ListHolder> implements AdapterView.OnItemClickListener {

    LayoutInflater layoutInflater;
    Context mContext;
    List<Topic> topics;

    public MainGridViewAdapter(List<Topic> topics, Context context) {
        this.mContext = context;
        this.topics = topics;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.grid_view_item, parent, false);
        return new MainGridViewAdapter.ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.getTitle().setText(topics.get(position).getFullTitle());
        Picasso.with(mContext).load(topics.get(position).getFullImg()).into(holder.getIcon());
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext,"Clicked "+position,Toast.LENGTH_SHORT).show();
    }

    class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView icon;
        TextView title;


        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
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

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext,"Clicked "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
            Intent i = new Intent(mContext, TopicActivity.class);
            ObjectMapper ob = new ObjectMapper();
            String topicsAsString = null;
            try {
                topicsAsString = ob.writeValueAsString(topics.get(getAdapterPosition()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            i.putExtra("topic",topicsAsString);
            mContext.startActivity(i);
        }
    }
}
