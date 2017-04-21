# cordova-plugin-transparent-status-bar
Cordova plugin to enable transparent status bar on Android devices

## How it Works
Just install the plugin and insert into your code:
```
Transparentstatusbar.init(function(result) {
  // ....
});
```
The **result** variable will be:
* 1 if the status bar is transparent
* 0 if the status bar is not transparent (Android version < KITKAT)
* -1 if there was an error

If the status bar is transparent, in your body tag there will be a new class: *has-transparent-statusbar*. You can use it to apply specific styles to your app only when the status bar is transparent.

## Compatibility with cordova-plugin-statusbar plugin
To use this plugin with **cordova-plugin-statusbar** (for instance, if your app runs also on iOS and you want to style the iOS status bar with cordova-plugin-statusbar plugin) you have to add this row to your **config.xml** file:
```
<preference name="StatusBarBackgroundColor" value=""/>
```
