package com.blueprintalpha.rnandroidshare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

class RNAndroidShare extends ReactContextBaseJavaModule {

  Activity mActivity;

  public RNAndroidShare(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  public RNAndroidShare setActivity(Activity activity) {
    mActivity = activity;
    return this;
  }

  @Override
  public String getName() {
    return "RNAndroidShare";
  }

  @ReactMethod
  public void openChooserWithOptions(ReadableMap options, String title) {
    
    Intent intent = new Intent(Intent.ACTION_SEND);

    if(options.hasKey("subject")) {
      intent.putExtra(Intent.EXTRA_SUBJECT, options.getString("subject"));
    }

    if(options.hasKey("text")) {
      intent.putExtra(Intent.EXTRA_TEXT, options.getString("text"));
    }

    if(options.hasKey("imageUrl")) {
      Uri uri = Uri.parse(options.getString("imageUrl"));
      intent.putExtra(Intent.EXTRA_STREAM, uri);
      intent.setType("image/*");
    } else {
      intent.setType("plain/text");
    }
    
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    mActivity.startActivity(Intent.createChooser(intent, title));
  }
}
