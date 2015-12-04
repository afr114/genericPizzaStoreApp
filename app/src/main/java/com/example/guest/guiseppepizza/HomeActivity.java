package com.example.guest.guiseppepizza;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final TextView phoneText = (TextView) findViewById(R.id.phoneTextView);
        final TextView mapText = (TextView) findViewById(R.id.mapTextView);
        final TextView friendText = (TextView) findViewById(R.id.friendTextView);
        final TextView photoText = (TextView) findViewById(R.id.photoTextView);
        phoneText.setOnClickListener(phoneListener);
        mapText.setOnClickListener(mapListener);
        friendText.setOnClickListener(friendListener);
        photoText.setOnClickListener(photoListener);
    }
    public static final String TAG = HomeActivity.class.getSimpleName();
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private View.OnClickListener phoneListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri number = Uri.parse("tel:555-7777");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        }
    };

    private View.OnClickListener mapListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri location = Uri.parse("geo:0,0?q=Giuseppes+Pizza+and+Pasta+Restaurant");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(mapIntent);
        }
    };

    private View.OnClickListener friendListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("smsto:");
            Intent friendIntent = new Intent(Intent.ACTION_SENDTO, uri);
            friendIntent.putExtra("sms_body", "I love Guiseppe's Pizza! ;)");
            startActivity(friendIntent);
        }
    };


    private View.OnClickListener photoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (photoIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(photoIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    };
}
