package com.example.menu_makanan_pagar_alam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail_Makanan extends Activity {

    String nama, harga, deskripsi, no_hp, latitude, longitude;
    int foto, position;
    TextView tvnama, tvharga, tvdeskripsi, tvno_hp;
    ImageView imgfoto;
    Button btnOrder, btnPeta;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_makanan);

        tvharga     =(TextView)findViewById(R.id.textView1);
        tvnama      =(TextView)findViewById(R.id.textView2);
        tvdeskripsi =(TextView)findViewById(R.id.textView3);
        imgfoto     =(ImageView) findViewById(R.id.imageView1);
        tvno_hp     =(TextView)findViewById(R.id.textView);
        btnOrder    =(Button) findViewById(R.id.button);
        btnPeta     =(Button) findViewById(R.id.button2);

        Intent i    =getIntent();
        position    =i.getExtras().getInt("position");
        harga       =i.getStringExtra("Harga");
        nama        =i.getStringExtra("Nama");
        deskripsi   =i.getStringExtra("Deskripsi");
        no_hp       =i.getStringExtra("No_HP");
        foto        =i.getIntExtra("Foto", foto);
        latitude    =i.getStringExtra("Latitude");
        longitude   =i.getStringExtra("Longitude");

        tvharga.setText(harga);
        tvnama.setText(nama);
        tvdeskripsi.setText(deskripsi);
        tvno_hp.setText(no_hp);
        imgfoto.setImageResource(foto);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i   = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://api.whatsapp.com/send?phone="+no_hp+"&text=Saya Order Makanan Via WA Dengan Nama Makanan: "+nama+"\n\nBerjumlah : "));
                startActivity(i);
            }
        });

        btnPeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri petaIntentUri   = Uri.parse("google.navigation:q="+latitude+","+longitude);
                Intent petaIntent   = new Intent(Intent.ACTION_VIEW, petaIntentUri);
                petaIntent.setPackage("com.google.android.apps.maps");
                if (petaIntent.resolveActivity(getPackageManager()) !=null);{
                    startActivity(petaIntent);
                }
            }
        });
    }
}
