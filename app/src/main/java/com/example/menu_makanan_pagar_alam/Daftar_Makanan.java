package com.example.menu_makanan_pagar_alam;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class Daftar_Makanan extends AppCompatActivity {

    ListView lvitem;
    EditText Edtcari;
    ListCall adapter;
    ArrayList<ListMenu> arrayList   = new ArrayList<ListMenu>();

    String[] nama;
    String[] harga;
    String[] deskripsi;
    int[] foto;
    String[] no_hp;
    String[] latitude;
    String[] longitude;

    @Override
    public void onCreate (Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.daftar_makanan);

        lvitem  =(ListView)findViewById(R.id.listView1);
        Edtcari =(EditText)findViewById(R.id.editText1);

        foto    =new int[]{
                R.mipmap.a_kelicok,
                R.mipmap.b_ikansemah,
                R.mipmap.c_nasisamin,
                R.mipmap.d_nasiibat1,
                R.mipmap.e_gulaipindang
        };
        nama    =new String[]{
                "Kelicok",
                "Ikan Lempeng",
                "Nasi Samin",
                "Nasi Ibat",
                "Ikan Semah"
        };
        harga   = new String[]{
                "Rp. 5.000",
                "Rp. 20.000",
                "Rp. 10.000",
                "Rp. 15.000",
                "Rp. 25.000"
        };
        deskripsi   = new String[]{
                "Berbahan dasar pisang dan ketan yang dibungkus dengan daun pisang dan dimasak dengan cara dikukus. Kelicok memiliki tekstur yang khas yaitu legit dan lengket.",

                "Bumbu dasar yang digunakan pada masakan ini terdiri dari bawang putih,laos,cabai merah,kunyit,jahe,kemiri,dan sereh yang ditumbuk halus. Bumbu dioles secara merata pada ikan dan kemudian ikan  dibungkus dengan daun pisang.",

                "Nasi samin sebenarnya adalah nasi dengan rempah-rempah yang terdiri dari cengkeh, kapulaga, dan kayu manis. Yang unik yaitu penambahan nanas untuk menambah cita rasa dari olahan nasi ini.",

                "Nasi Ibat. Pada dasarnya nasi ibat adalah jenis beras yang dimasak dan dibungkus dengan daun pisang, tujuannya untuk menambah aroma dan agar teksturnya lebih lembut",

                "Lauk khas dengan bahan dasar ikan sungai seperti ikan patin,gabus, dan baung. Mempunyai kuah yang berwarna kuning karena menggunakan bahan kunyit,jahe,laos dan serai."
        };

        no_hp   = new String[]{
                "+6282375150902",
                "+6282375150902",
                "+6282375150902",
                "+6282375150902",
                "+6282375150903"
        };

        latitude = new String[]{
                "-4.0302293",
                "-4.0419617",
                "-4.0261125",
                "-4.0237193",
                "-4.0207822"
        };

        longitude = new String[]{
                "103.2572719",
                "103.2278845",
                "103.2549497",
                "103.2551524",
                "103.2534228"
        };

        for (int i =0; i<nama.length; i++){
            ListMenu wp = new ListMenu(nama[i], harga[i], deskripsi[i], foto[i], no_hp[i], latitude[i], longitude[i]);
            arrayList.add(wp);
        }

        adapter = new ListCall(this, arrayList);
        lvitem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian Berhasil");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }
        });
    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
