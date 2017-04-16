package net.santhoshk.quotesappv2.utils;

import android.content.Context;

import com.android.volley.*;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by Sandy on 4/16/2017.
 */

public class HttpRequestQueue {

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    private RequestQueue requestQueue;

    public HttpRequestQueue(Context context) {
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024 * 10); // 1MB cap
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();
    }
}
