package net.santhoshk.quotesappv2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.santhoshk.quotesappv2.R;
import net.santhoshk.quotesappv2.model.PictureQuote;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {


    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topic, container, false);
    }

    public static Fragment getInstance(PictureQuote pictureQuote) {
        TopicFragment topicFragment = new TopicFragment();
        return topicFragment;
    }
}
