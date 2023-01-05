package com.example.differentuitest;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.widget.TextView;

import static android.Manifest.permission.READ_PHONE_NUMBERS;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;

public class DeviceActivity extends AppCompatActivity {
    TextView displayInfo;
    private static final int PERMISSION_REQUEST_CODE = 100;
    TextView textView;
    TelephonyManager telephonyManager;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        displayInfo = findViewById(R.id.displayInfoTvId);
        textView = findViewById(R.id.tvId);
        displayInfo.setText(getSystemDetail());


//        telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
//        if (ActivityCompat.checkSelfPermission(this, READ_SMS) != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this, READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this, READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{READ_SMS, READ_PHONE_NUMBERS, READ_PHONE_STATE}, PERMISSION_REQUEST_CODE);
//        } else {
////            textView.setText(""+telephonyManager.getSimSerialNumber());
//            textView.setText(telephonyManager.getImei());
//            String phn = (""+telephonyManager.getSimSerialNumber());
//        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("MissingPermission")
    private String getSystemDetail() {

//        Context context = requireContext().getApplicationContext();
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        String android_device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);


//        // device Id
//        deviceId_str = telephonyManager.getDeviceId();
//        // software version
//        softwareVersion_str = telephonyManager.getDeviceSoftwareVersion();
//        // serial number
//        simSerialNo = telephonyManager.getSimSerialNumber();
//        //voice mail number
//        voicemailNumer_str = telephonyManager.getVoiceMailNumber();
//        // sim operator name
//        sim_operator_Name= telephonyManager.getSimOperatorName();

        return  "Brand: "+Build.BRAND+"\n"
                +"Model: "+Build.MODEL+"\n"
//                +"DeviceId: "+ Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)+"\n"
                +"Version Code: "+Build.VERSION.RELEASE+"\n"
                +"ID: "+Build.ID+"\n"
                +"SDK: "+Build.VERSION.SDK_INT+"\n"
                +"Manufacture: "+Build.MANUFACTURER+"\n"
                +"User: "+Build.USER+"\n"
                +"Type: "+Build.TYPE+"\n"
                +"Base: "+Build.VERSION_CODES.BASE+"\n"
                +"Incremental(MIUI version): "+Build.VERSION.INCREMENTAL+"\n"
                +"Board: "+Build.BOARD+"\n"
                +"Host: "+Build.HOST+"\n"
                +"Serial: "+Build.SERIAL+"\n"
                +"Ip Address: "+ Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress())+"\n"
                +"Unique Id: "+ android_device_id+"\n"
                +"\n";

    }

    @SuppressLint("MissingPermission")
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) !=
                        PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) !=
                                PackageManager.PERMISSION_GRANTED) {
                    return;
                } else {
//                    textView.setText(""+telephonyManager.getSimSerialNumber());
                    textView.setText(telephonyManager.getImei());
                }
        }
    }

}