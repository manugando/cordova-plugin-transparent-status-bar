package it.tangodev.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Transparentstatusbar extends CordovaPlugin {

    @Override
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Window window = cordova.getActivity().getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            }
        });
    }

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("enable")) {
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        Transparentstatusbar.this.cordova
                                .getActivity()
                                .getWindow()
                                .getDecorView()
                                .setSystemUiVisibility(
                                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                );
                        Transparentstatusbar.this.cordova
                                .getActivity()
                                .getWindow()
                                .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

                        callbackContext.success();
                    } else {
                        callbackContext.error("Transparentstatusbar not supported on Android version lower than 19 (current is: " + Build.VERSION.SDK_INT + ")");
                    }
                }
            });
            return true;
        } else {
            return false;
        }
    }
}