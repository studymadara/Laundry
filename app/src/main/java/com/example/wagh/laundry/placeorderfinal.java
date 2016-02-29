package com.example.wagh.laundry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wagh on 6/2/16.
 */
public class placeorderfinal extends AppCompatActivity {

    String getAddressSave="";
    int a,total=0;
    String getTimesave="";
    int getShirtssave,getSareessave,getJeanssave=0;
    String getContactsave,z="";
    int mul=0;
    RadioGroup radioGroup;
    RadioButton rb1;
    Button pay;
    TextView tvJeans,tvSarees,tvShirt,tvTax,tvTotal,tvAddress,tvContact,tvPickupTime;
    Intent iii = new Intent(getBaseContext(),MainActivity.class);
    Bundle bb= getIntent().getExtras();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placeorderfinal);

        pay =(Button)findViewById(R.id.pay);
        tvJeans=(TextView)findViewById(R.id.tvjeans);
        tvSarees=(TextView)findViewById(R.id.tvsarees);
        tvShirt=(TextView)findViewById(R.id.tvshirt);
        tvTax=(TextView)findViewById(R.id.tvtax);
        tvTotal=(TextView)findViewById(R.id.tvtotal);
        tvAddress=(TextView)findViewById(R.id.tvaddress);
        tvContact=(TextView)findViewById(R.id.tvcontact);
        radioGroup=(RadioGroup)findViewById(R.id.rg);
        rb1=(RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        tvPickupTime=(TextView) findViewById(R.id.tvpickupTime);



        getShirtssave=bb.getInt("getShirt");
        getJeanssave=bb.getInt("getJeans");
        getSareessave=bb.getInt("getSarees");
        getAddressSave=bb.getString("getAddress");
        getContactsave=bb.getString("getContact");
        getTimesave=bb.getString("getTime");
        a=bb.getInt("getService");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb1=(RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

            }
        });



        /** Calculations **/

        total=0;

        if(a==1)
        {

            z="";
            mul = getShirtssave * 10;
            total=mul+total;
            z += String.valueOf(getShirtssave);
            z += "X";
            z += "10";
            z+="=";
            z += String.valueOf(mul);
            tvShirt.setText(z);
            z = "";
            mul = 0;


            mul = getJeanssave * 8;
            total=mul+total;
            z += String.valueOf(getJeanssave);
            z += "X";
            z += "8";
            z+="=";
            z += String.valueOf(mul);
            tvJeans.setText(z);
            z = "";
            mul = 0;

            mul = getSareessave * 20;
            total=mul+total;
            z += String.valueOf(getSareessave);
            z += "X";
            z += "20";
            z+="=";
            z += String.valueOf(mul);
            tvSarees.setText(z);
            z = "";
            mul = 0;

            z = "50";
            total=50+total;
            tvTax.setText(z);
            z = "";

            z=String.valueOf(total);
            tvTotal.setText(z);
            z="";

            tvAddress.setText(getAddressSave);
            tvContact.setText(getContactsave);
            tvPickupTime.setText(getTimesave);


        }
        else if (a==2)
        {

            z="";
            mul = getShirtssave * 20;
            total=mul+total;
            z += String.valueOf(getShirtssave);
            z += "X";
            z += "20";
            z+="=";
            z += String.valueOf(mul);
            tvShirt.setText(z);
            z = "";
            mul = 0;


            mul = getJeanssave * 18;
            total=mul+total;
            z += String.valueOf(getJeanssave);
            z += "X";
            z += "18";
            z+="=";
            z += String.valueOf(mul);
            tvJeans.setText(z);
            z = "";
            mul = 0;

            mul = getSareessave * 30;
            total=mul+total;
            z += String.valueOf(getSareessave);
            z += "X";
            z += "30";
            z+="=";
            z += String.valueOf(mul);
            tvSarees.setText(z);
            z = "";
            mul = 0;

            z = "50";
            total=50+total;
            tvTax.setText(z);
            z = "";

            z=String.valueOf(total);
            tvTotal.setText(z);
            z="";

            tvAddress.setText(getAddressSave);
            tvContact.setText(getContactsave);
            tvPickupTime.setText(getTimesave);


        }




        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Make something which will text the number 9888871762 OR email admin@thewashhub.com
                 * pickup message in short details about the order**/
                /**Toast.makeText(placeorderfinal.this,"Thank you",Toast.LENGTH_LONG).show();
                String phoneNumber="9768948065";
                String message="";

                message+="Order::Address";
                message+=getAddressSave;
                message+="Contact Number";
                message+=getContactsave;
                message+="PickUp Time";
                message+=tvPickupTime;
                message+="Payment Method:";
                message+=rb1.getText();

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phoneNumber,null,message,null,null);
                startActivity(iii);
**/

            }
        });




    }
}
