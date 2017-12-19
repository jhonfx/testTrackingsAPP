package com.example.juan.testtrackingsadform;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adform.adformtrackingsdk.AdformTrackingSdk;
import com.adform.adformtrackingsdk.TrackPoint;
import com.adform.adformtrackingsdk.entities.Order;

public class PantallaCuatro extends Activity {

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_cuatro);

        TrackPoint trackPoint = new TrackPoint(873271);
        trackPoint.setSectionName("SURA_APP_Android_Pantalla_Envio_Codigo_Seguridad");
        trackPoint.setAppName("AppSuraAfore_Android");
        AdformTrackingSdk.sendTrackPoint(trackPoint);

        siguiente = (Button)findViewById(R.id.button7);
        siguiente.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(PantallaCuatro.this, PantallaCinco.class);
                startActivity(siguiente);
            }
        });
    }
}
