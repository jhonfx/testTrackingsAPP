package com.example.juan.testtrackingsadform;

import android.app.Application;

import com.adform.adformtrackingsdk.AdformTrackingSdk;
import com.adform.adformtrackingsdk.TrackPoint;
import com.adform.adformtrackingsdk.entities.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Juan on 6/6/17.
 */

public class DemoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //AdformTrackingSdk.startTracking(getApplicationContext(), 583303);

        TrackPoint trackPoint = new TrackPoint(873271);
        trackPoint.setSectionName("SURA_APP_Android_Pantalla_Datos_Iniciales");
        trackPoint.setAppName("AppSuraAfore_Android");
        AdformTrackingSdk.sendTrackPoint(trackPoint);

        Order order = new Order();
        order.addSystemValue(19, "miguel@twinkey.cool");
        order.addSystemValue(20, "miguel@twinkey.cool");
        order.addSystemValue(21, "52");
        order.addSystemValue(22, "5540302055");
        trackPoint.setOrder(order);

        AdformTrackingSdk.sendTrackPoint(trackPoint);
    }
}
