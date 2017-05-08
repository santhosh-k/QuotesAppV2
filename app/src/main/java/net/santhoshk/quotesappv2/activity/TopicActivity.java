package net.santhoshk.quotesappv2.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import net.santhoshk.quotesappv2.R;
import net.santhoshk.quotesappv2.fragment.TopicFragment;
import net.santhoshk.quotesappv2.model.PictureQuote;
import net.santhoshk.quotesappv2.model.Topic;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends FragmentActivity {

    PagerAdapter mPagerAdapter = null;

    ViewPager mViewPager = null;

    Topic topic = null;

    List<PictureQuote> pictureQuotes = new ArrayList<PictureQuote>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mPagerAdapter);
        Toast.makeText(this,"Test",Toast.LENGTH_SHORT).show();
        Bundle extras = getIntent().getExtras();
        Toast.makeText(this,extras.getString("topic"),Toast.LENGTH_SHORT).show();
        try {
            this.topic = new ObjectMapper().readValue(extras.getString("topic"), Topic.class);
            Toast.makeText(this,topic.getFullTitle(),Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TopicFragment.getInstance(pictureQuotes.get(position));
        }


        @Override
        public int getCount() {
            return 0;
        }
    }
}
