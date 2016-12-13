package com.example.kryguu.accelerometer;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    DrawView drawView;

    @BindView(R.id.textViewX)
    TextView textViewX;
    @BindView(R.id.textViewY)
    TextView textViewY;
    @BindView(R.id.textViewZ)
    TextView textViewZ;

    private final int COEFFICIENT = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = (DrawView) findViewById(R.id.view);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        drawView.setBackgroundColor(Color.WHITE);
        ButterKnife.bind(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float ax = sensorEvent.values[0];
            float ay = sensorEvent.values[1];
            float az = sensorEvent.values[2];

            drawView.invalidate();
            drawView.setX(ax*COEFFICIENT);
            drawView.setY(-ay*COEFFICIENT);

            textViewX.setText("X: " + String.valueOf(ax));
            textViewY.setText("Y: " + String.valueOf(ay));
            textViewZ.setText("Z: " + String.valueOf(az));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
