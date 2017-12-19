package com.example.juan.testtrackingsadform;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.adform.adformtrackingsdk.AdformTrackingSdk;
import com.adform.adformtrackingsdk.TrackPoint;
import com.adform.adformtrackingsdk.entities.Order;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button siguiente;
    Button siguiente2;
    Button siguiente3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TRACK", "Inicio");
        //AdformTrackingSdk.setAppName("AppSuraAfore");
        AdformTrackingSdk.setAppName("AppSuraAfore_Android");
        AdformTrackingSdk.startTracking(getApplicationContext(), 873271);
        Log.i("TRACK", "Fin de ejecucion inicial");

        //Adsmovil.trackApplication(79991, getApplicationContext());
        Button myBtn2  = (Button) findViewById(R.id.button2);
        myBtn2.setOnClickListener(this);

        Button myBtn3  = (Button) findViewById(R.id.button3);
        myBtn3.setOnClickListener(this);

        Button myBtn4  = (Button) findViewById(R.id.button4);
        myBtn4.setOnClickListener(this);


        TrackPoint trackPoint = new TrackPoint(873271);
        trackPoint.setSectionName("SURA_APP_Android_Pantalla_Inicio");
        trackPoint.setAppName("AppSuraAfore_Android");
        AdformTrackingSdk.sendTrackPoint(trackPoint);

        //AppsFlyerLib.getInstance().startTracking(this.getApplication(), "rgRgssepBPq9NzwJxCNAt8");

        siguiente = (Button)findViewById(R.id.button);
        siguiente.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(MainActivity.this, PantallaDos.class);
                startActivity(siguiente);
            }
        });

        siguiente2 = (Button)findViewById(R.id.button3);
        siguiente2.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente2 = new Intent(MainActivity.this, PantallaTres.class);
                startActivity(siguiente2);
            }
        });

        siguiente3 = (Button)findViewById(R.id.button4);
        siguiente3.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente3 = new Intent(MainActivity.this, PantallaCuatro.class);
                startActivity(siguiente3);
            }
        });
    }

    public void onResume() {
        super.onResume();
        AdformTrackingSdk.onResume(this);
    }

    public void onPause() {
        super.onPause();
        AdformTrackingSdk.onPause();
    }

    @Override
    /*Boton inutilizable por el moneto*/
    public void onClick(View v) {
        System.out.print("Click en botoncito");

        TrackPoint trackPoint = new TrackPoint(873271);
        trackPoint.setSectionName("Sura_App_Afore_Pantalla_1");
        trackPoint.setAppName("AppSuraAfore");

        Order order = new Order();
        order.addSystemValue(17, "jhon@gmail.com");
        order.addSystemValue(16, "52");
        order.addSystemValue(15, "5511239023");
        trackPoint.setOrder(order);

        AdformTrackingSdk.sendTrackPoint(trackPoint);

        /*Map<String, Object> eventValue = new HashMap<String, Object>();
        eventValue.put(AFInAppEventParameterName.PARAM_1, "Sura_App_Afore_Registro");
        eventValue.put(AFInAppEventParameterName.PARAM_2, "juan purata");
        eventValue.put(AFInAppEventParameterName.PARAM_3, "jhonfx85@gmail.com");
        AppsFlyerLib.getInstance().trackEvent(this.getApplicationContext(), AFInAppEventType.COMPLETE_REGISTRATION, eventValue);*/
    }
}
