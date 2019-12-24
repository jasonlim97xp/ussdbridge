package com.ussd;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import javax.annotation.Nonnull;

public class UssdModule extends ReactContextBaseJavaModule {
    public UssdModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "UssdModule";
    }

    @ReactMethod
    public void dialNumber(@Nonnull String number) {
        Activity activity = getCurrentActivity();
        if (activity != null) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number + Uri.encode("#")));
            activity.startActivity(intent);
        }
    }
}