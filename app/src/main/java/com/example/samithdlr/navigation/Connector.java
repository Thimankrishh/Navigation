package com.example.samithdlr.navigation;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by SAMITH D.L.R on 3/4/2017.
 */

public class Connector extends Application {
    private static Connector mInstance;
    private RequestQueue mRequestQueue;

    private static Context mCtx;

    private Connector(Context context){
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }


    public static synchronized Connector getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Connector(context);
        }
        return mInstance;
    }



    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
