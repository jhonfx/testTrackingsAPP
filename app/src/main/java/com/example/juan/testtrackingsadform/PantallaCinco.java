package com.example.juan.testtrackingsadform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adform.adformtrackingsdk.AdformTrackingSdk;
import com.adform.adformtrackingsdk.TrackPoint;
import com.adform.adformtrackingsdk.entities.Order;

import static com.google.android.gms.internal.a.R;

/**
 * Created by Juan on 12/13/17.
 */

public class PantallaCinco extends Activity {

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_cinco);

        TrackPoint trackPoint = new TrackPoint(873271);
        trackPoint.setSectionName("SURA_APP_Android_Pantalla_Ingresa_Codigo_Seguridad");
        trackPoint.setAppName("AppSuraAfore_Android");
        AdformTrackingSdk.sendTrackPoint(trackPoint);

        Order order = new Order();
        order.addSystemValue(24, "1234");
        trackPoint.setOrder(order);

        AdformTrackingSdk.sendTrackPoint(trackPoint);

        siguiente = (Button)findViewById(R.id.button6);
        siguiente.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(PantallaCinco.this, PantallaCinco.class);
                startActivity(siguiente);
            }
        });
    }
}
