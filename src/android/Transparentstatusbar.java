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
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("isTransparent")) {
            boolean result = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
            callbackContext.success(result ? 1 : 0);
            return true;
        } else {
            return false;
        }
    }
}