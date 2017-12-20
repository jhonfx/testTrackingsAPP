package com.example.juan.testtrackingsadform;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.adform.adformtrackingsdk.AdformTrackingSdk;
import com.adform.adformtrackingsdk.TrackPoint;
import com.adform.adformtrackingsdk.entities.Order;

public class PantallaDos extends AppCompatActivity implements OnClickListener{

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

        TrackPoint trackPoint = new TrackPoint(873271);
        trackPoint.setSectionName("Eventos_Generados|SURA_APP_Android_Ingreso_Datos");
        trackPoint.setAppName("AppSuraAfore_ANDROID_V2");

        Order order = new Order();
        order.addSystemValue(19, "miguel@twinkey.cool");
        order.addSystemValue(20, "miguel@twinkey.cool");
        order.addSystemValue(21, "52");
        order.addSystemValue(22, "5540302055");
        trackPoint.setOrder(order);

        Button myBtn2  = (Button) findViewById(R.id.button5);
        myBtn2.setOnClickListener(this);

        AdformTrackingSdk.sendTrackPoint(trackPoint);

        siguiente = (Button)findViewById(R.id.button5);
        siguiente.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(PantallaDos.this, PantallaTres.class);
                startActivity(siguiente);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
