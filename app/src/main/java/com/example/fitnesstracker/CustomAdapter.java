package com.example.fitnesstracker;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnesstracker.model.Fortschritt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class CustomAdapter implements ListAdapter {
    List<Fortschritt> arrayList;
    Context context;
    public CustomAdapter(Context context, List<Fortschritt> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Fortschritt subjectData=arrayList.get(position);
      if(convertView==null){
          LayoutInflater layoutInflater = LayoutInflater.from(context);
          convertView=layoutInflater.inflate(R.layout.list_row, null);

          TextView tittle=convertView.findViewById(R.id.title);
          ImageView imag=convertView.findViewById(R.id.list_image);
          tittle.setText(""+subjectData.getDate());
          File imgFile = new  File(subjectData.getPathToPicture());

          if(imgFile.exists()){

              Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

              imag.setImageBitmap(myBitmap);
          }
      }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }


    @Override
    public boolean isEmpty() {
        return false;
    }
}
