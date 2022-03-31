package uz.context.intentservicejava.servises;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class ExampleJobIntentService extends JobIntentService {

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context,ExampleJobIntentService.class,123,work);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        log("onHandleWork");

        String input = intent.getStringExtra("inputExtra");

        for (int i = 0; i < 10; i++) {
            log(input + " - " + i);

            if (isStopped()) {
                return;
            }

            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onStopCurrentWork() {
        log("onStopCurrentWork");
        return super.onStopCurrentWork();
    }

    private void log(String msg) {
        Log.d("@@@@@", msg);
    }
}
