package net.santhoshk.quotesappv2.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import net.santhoshk.quotesappv2.R;
import net.santhoshk.quotesappv2.adapter.MainGridViewAdapter;
import net.santhoshk.quotesappv2.adapter.MainListViewAdapter;
import net.santhoshk.quotesappv2.model.Topic;
import net.santhoshk.quotesappv2.utils.HttpRequestQueue;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sandy on 4/16/2017.
 */

public class RVListViewFragment extends Fragment {

    private RecyclerView recyclerView;

    private GridLayoutManager gridLayoutManager;

    private MainListViewAdapter mainListViewAdapter;

    private MainGridViewAdapter mainGridViewAdapter;

    private ProgressBar progressBar;

    private List<Topic> topics;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rv_list_view_layout, container, false);
        progressBar = (ProgressBar) view.findViewById(R.id.loadingProgressBarLarge);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_view_main_list);
        recyclerView.setHasFixedSize(true);

        setHasOptionsMenu(true);
        updateAdapterData();
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            gridLayoutManager = new GridLayoutManager(getContext(), 3);
        }
        else{
            gridLayoutManager = new GridLayoutManager(getContext(), 5);
        }
        gridLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        return view;
    }

    public void updateAdapterData() {
        final ObjectMapper objectMapper = new ObjectMapper();
        int socketTimeout = 15000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        String url = "http://trquotesapp.herokuapp.com/getAllTopics";
        JsonArrayRequest jsObjRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response", response.toString());
                        try {
                            topics = objectMapper.readValue(response.toString(), TypeFactory.defaultInstance().constructCollectionType(List.class, Topic.class));
                            Log.d("Response", response.toString());
                            progressBar.setVisibility(View.INVISIBLE);
                            mainGridViewAdapter = new MainGridViewAdapter(topics, getContext());
                            recyclerView.setAdapter(mainGridViewAdapter);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.toString());
                    }
                });
        jsObjRequest.setRetryPolicy(policy);
        RequestQueue mRequestQueue = new HttpRequestQueue(getContext()).getRequestQueue();
        mRequestQueue.add(jsObjRequest);
    }
}
