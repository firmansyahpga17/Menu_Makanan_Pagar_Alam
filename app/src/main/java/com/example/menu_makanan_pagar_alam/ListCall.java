package com.example.menu_makanan_pagar_alam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListCall extends BaseAdapter {
    Context nContext;
    LayoutInflater inflater;
    private List<ListMenu> viewadafterlist  = null;
    private ArrayList<ListMenu> arrayList;

    public ListCall(Context context, List<ListMenu> viewadafterlist){
        nContext        = context;
        this.viewadafterlist    = viewadafterlist;
        inflater        = LayoutInflater.from(nContext);
        this.arrayList  = new ArrayList<ListMenu>();
        this.arrayList.addAll(viewadafterlist);
    }

    public class ViewHolder{
        TextView nama;
        TextView harga;
        ImageView foto;
    }

    @Override
    public int getCount(){ return viewadafterlist.size();}

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @SuppressLint("WrongViewCast")
    public View getView(final int position, View view, ViewGroup parent){
        final ViewHolder holder;
        if (view == null){
            holder      = new ViewHolder();
            view        = inflater.inflate(R.layout.list_icon, null);
            holder.nama = (TextView) view.findViewById(R.id.textView1);
            holder.harga= (TextView) view.findViewById(R.id.textView2);
            holder.foto = (ImageView)view.findViewById(R.id.imageView1);
            view.setTag(holder);
        }else {
            holder  = (ViewHolder) view.getTag();
        }

        holder.nama.setText(viewadafterlist.get(position).getNama());
        holder.harga.setText(viewadafterlist.get(position).getHarga());
        holder.foto.setImageResource(viewadafterlist.get(position).getFoto());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent   = new Intent(nContext, Detail_Makanan.class);
                intent.putExtra("Nama", (viewadafterlist.get(position).getNama()));
                intent.putExtra("Harga", (viewadafterlist.get(position).getHarga()));
                intent.putExtra("Deskripsi", (viewadafterlist.get(position).getDeskripsi()));
                intent.putExtra("Foto", (viewadafterlist.get(position).getFoto()));
                intent.putExtra("No_HP", (viewadafterlist.get(position).getNo_hp()));
                intent.putExtra("Latitude", (viewadafterlist.get(position).getLatitude()));
                intent.putExtra("Longitude", (viewadafterlist.get(position).getLongitude()));

                nContext.startActivity(intent);
            }
        });
        return view;
    }

    public void filter(String chrText){
        chrText = chrText.toLowerCase(Locale.getDefault());
        viewadafterlist.clear();
        if (chrText.length() == 0){
            viewadafterlist.addAll(arrayList);
        }else {
            for (ListMenu wp : arrayList){
                if (wp.getNama().toLowerCase(Locale.getDefault()).contains(chrText)){
                    viewadafterlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}