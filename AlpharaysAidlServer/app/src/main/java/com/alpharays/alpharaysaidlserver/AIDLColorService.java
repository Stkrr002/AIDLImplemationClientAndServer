package com.alpharays.alpharaysaidlserver;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.Random;

public class AIDLColorService extends Service {
    public AIDLColorService() {
        Log.d("hiiiiiiiiiiiiiiiiiiiii","mil gya");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }
    private final IAIDLColorInterface.Stub binder = new IAIDLColorInterface.Stub() {
        @Override
        public int getCustomColor() throws RemoteException {
            Random rand = new Random();
            int color = Color.argb(255,rand.nextInt(256),
                    rand.nextInt(256),rand.nextInt(256));
            Log.d("ColorService", String.valueOf(color));
            return color;
        }
    };
}
