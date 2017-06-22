package com.mutationapps.ansh.fcmsample.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by hp on 6/22/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{

    private static final String TAG = "Debugging";

    @Override
    public void onTokenRefresh() {
        String refresedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, " Token for this device is: "+ refresedToken);
    }

    private void sendRegistrationTokenToServer(String token){
        //implement this method in case you want to save this token to the server
    }
}
