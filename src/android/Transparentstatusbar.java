package it.tangodev.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
public class Transparentstatusbar extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
       if (action.equals("customaction")) {
            String message = args.getString(0);
            callbackContext.success("YES! " . message);
            Log.i("Gando", "Plugin called! " . message);
            return true;
        } else {
            return false;
        }
    }
}