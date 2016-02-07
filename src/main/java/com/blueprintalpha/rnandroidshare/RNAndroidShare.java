package com.blueprintalpha.rnandroidshare;

import android.app.Activity;
import android.content.Intent;

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
    return "AndroidShare";
  }

  @ReactMethod
  public void openChooserWithOptions(ReadableMap options, String title) {
    
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setTypeAndNormalize("text/plain");
    if(options.hasKey("subject")) {
      intent.putExtra(Intent.EXTRA_SUBJECT, options.getString("subject"));
    }
    if(options.hasKey("text")) {
      intent.putExtra(Intent.EXTRA_TEXT, options.getString("text"));
    }
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    mActivity.startActivity(Intent.createChooser(intent, title));
  }
}
