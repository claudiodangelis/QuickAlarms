package com.claudiodangelis.quickalarms;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class Hidden extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden);

        PackageManager packageManager = getApplicationContext().getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER);

        try {
            // Replace pkg name and class name according to Android version you're running
            ComponentName componentName = new ComponentName("com.google.android.deskclock",
                    "com.android.deskclock.AlarmClock");

            packageManager.getActivityInfo(componentName, PackageManager.GET_META_DATA);
            intent.setComponent(componentName);
            startActivity(intent);

        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("debug", "Not found");
        }

        finish();
    }
}
