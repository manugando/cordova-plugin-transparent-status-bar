package it.tangodev.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.graphics.Color;
import android.view.View;

public class Transparentstatusbar extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("enable")) {
			this.cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Transparentstatusbar.this.cordova.getActivity().getWindow().getDecorView().setSystemUiVisibility(
						View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
					Transparentstatusbar.this.cordova.getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
				}
			});
			
            callbackContext.success(1);
            return true;
        } else {
            return false;
        }
    }
}