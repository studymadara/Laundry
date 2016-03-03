package com.example.wagh.laundry;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by wagh on 6/2/16.
 */
public class placeorder extends AppCompatActivity {


    int a=0;
    int getShirtssave,getSareessave,getJeanssave;
    String getContactsave;
    String getAddressSave;
    String getTimesavehour,getTimesaveminute,getTimesavemode,getTimesave;


    EditText getAddress,getSarees,getJeans,getShirts,getContact,getTimehour,getTimeminute,getTimemode;
    Button washing,dryCleaning,next;
    RadioGroup rg1;
    RadioButton rb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placeorder);

        Toast.makeText(getBaseContext(),"Please turn on the GPS",Toast.LENGTH_LONG).show();

        try
        {
            LocationManager locationManager= (LocationManager)getSystemService(LOCATION_SERVICE);
            LocationListener locationListener=new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    Double z=location.getLatitude();
                    Double z1=location.getLongitude();
                    String zz="Latitude=";
                    zz+=z.toString();
                    zz+=" ";
                    zz+="Longitude=";
                    zz+=z1.toString();
                    Toast.makeText(getBaseContext(),zz,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);

        }

        catch (SecurityException ee)
        {
            Log.e("ERRORSECURITY","GPSUNKNOWN",ee);
        }


        getAddress=(EditText)findViewById(R.id.etaddressget);
        getTimehour=(EditText)findViewById(R.id.ettimegetHour);
        getTimeminute=(EditText)findViewById(R.id.ettimegetMin);

        getContact=(EditText)findViewById(R.id.etnumberget);
        getShirts=(EditText)findViewById(R.id.shirtvalue);
        getJeans=(EditText)findViewById(R.id.jeansvalue);
        getSarees=(EditText)findViewById(R.id.sareesvalue);
        washing=(Button)findViewById(R.id.washing);
        dryCleaning=(Button)findViewById(R.id.drycleaning);
        next = (Button)findViewById(R.id.next);
        rg1=(RadioGroup)findViewById(R.id.rg22);
        rb1=(RadioButton)rg1.findViewById(rg1.getCheckedRadioButtonId());


        final Intent i3= new Intent(getBaseContext(),placeorderfinal.class);


        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb1=(RadioButton)rg1.findViewById(rg1.getCheckedRadioButtonId());
                boolean rb1check= rb1.isChecked();
            }
        });


        washing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               if(a==2)
               {
                   dryCleaning.setBackgroundColor(Color.GRAY);
               }
                a=1;
                washing.setBackgroundColor(Color.GREEN);

            }
        });


        dryCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a==1)
                {
                    washing.setBackgroundColor(Color.GRAY);
                }

                a=2;
                dryCleaning.setBackgroundColor(Color.GREEN);
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    getAddressSave = getAddress.getText().toString();
                    getTimesavehour = getTimehour.getText().toString();
                    getTimesaveminute=getTimeminute.getText().toString();
                    getTimesavemode=rb1.getText().toString();

                    getTimesave="";
                    getTimesave +=getTimesavehour;
                    getTimesave +=":";
                    getTimesave +=getTimesaveminute;
                    getTimesave +=".";
                    getTimesave +=getTimesavemode;

                    getContactsave = getContact.getText().toString();
                    getShirtssave = Integer.parseInt(getShirts.getText().toString());
                    getJeanssave = Integer.parseInt(getJeans.getText().toString());
                    getSareessave = Integer.parseInt(getSarees.getText().toString());


                    Bundle bb = new Bundle();
                    bb.putString("getAddress", getAddressSave);
                    bb.putString("getTime", getTimesave);
                    bb.putString("getContact", getContactsave);
                    bb.putInt("getShirt", getShirtssave);
                    bb.putInt("getJeans", getJeanssave);
                    bb.putInt("getSarees", getSareessave);
                    bb.putInt("getService", a);
                    i3.putExtras(bb);

                    startActivity(i3);
                }
                catch (Exception e)
                {
                    Log.e("ERROR","error", e);
                }
            }
        });

}}


