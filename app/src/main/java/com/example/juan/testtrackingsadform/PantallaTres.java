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

public class PantallaTres extends Activity {

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_tres);

        TrackPoint trackPoint = new TrackPoint(873271);
        trackPoint.setSectionName("SURA_APP_Android_Pantalla_Ingresa_Curp");
        trackPoint.setAppName("AppSuraAfore_Android");

        Order order = new Order();
        order.addSystemValue(23, "MIKE851023HMCRRN02");
        trackPoint.setOrder(order);

        AdformTrackingSdk.sendTrackPoint(trackPoint);

        siguiente = (Button)findViewById(R.id.button6);
        siguiente.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(PantallaTres.this, PantallaCuatro.class);
                startActivity(siguiente);
            }
        });
    }
}
