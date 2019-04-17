package com.example.group_11_mad3125_project.Controller.NeedHelp;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.group_11_mad3125_project.R;

import java.io.IOException;
import java.io.InputStream;

public class NeedHelp extends AppCompatActivity {
private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nedd_help);
        wv1=findViewById(R.id.wv_help);

        AssetManager mAssetManager = this.getAssets();
        try
        {
            InputStream mInputStream = mAssetManager.open("help.html");
            int size = mInputStream.available();
            byte[] buffer = new byte[size];
            mInputStream.read(buffer);
            mInputStream.close();
            String content = new String(buffer, "UTF-8");

            //Log.d("DATA", content);
            wv1.loadData(content, "text/html", "utf-8");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
