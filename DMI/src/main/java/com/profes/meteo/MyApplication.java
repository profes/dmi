package com.profes.meteo;

import android.app.Application;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;

@EApplication
public class MyApplication extends Application {

    private ImageLoader mImageLoader;

    private final LruCache<String, Bitmap> mImageCache = new LruCache<String, Bitmap>(20);

    public void onCreate() {
        super.onCreate();
        initSomeStuff();
    }

    @Background
    void initSomeStuff() {

        RequestQueue queue = Volley.newRequestQueue(this);

        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public void putBitmap(String key, Bitmap value) {
                mImageCache.put(key, value);
            }

            @Override
            public Bitmap getBitmap(String key) {
                return mImageCache.get(key);
            }
        };

        mImageLoader = new ImageLoader(queue, imageCache);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}