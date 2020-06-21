package com.example.otlistview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class BHAdapter extends BaseAdapter {
    //private BHDatabase database;
    private Context context;

    public BHAdapter(Context context, ArrayList<BHModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    private ArrayList<BHModel> arrayList;

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.listview_custom, parent, false);
        ImageView anh = convertView.findViewById(R.id.anh);
        TextView ten = convertView.findViewById(R.id.tenbh);
        TextView casi = convertView.findViewById(R.id.tencs);
        TextView like = convertView.findViewById(R.id.like);
        anh.setImageResource(R.drawable.icecream);
        ten.setText(arrayList.get(position).getTen());
        casi.setText(arrayList.get(position).getCasi());
        like.setText(arrayList.get(position).getLike());
        anh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setMessage("Delete?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        database.queryData("delete from BH where ...");
//                        GetDL();
                        arrayList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_custom);
                final EditText anh = dialog.findViewById(R.id.anh);
                final EditText ten = dialog.findViewById(R.id.tenbh);
                final EditText casi = dialog.findViewById(R.id.casi);
                final EditText like = dialog.findViewById(R.id.like);
                anh.setText(arrayList.get(position).getAnh());
                ten.setText(arrayList.get(position).getTen());
                casi.setText(arrayList.get(position).getCasi());
                like.setText(arrayList.get(position).getLike());
                Button sua = dialog.findViewById(R.id.nhaplieu);
                sua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        arrayList.get(position).setAnh(Integer.valueOf(anh.getText().toString()));
                        arrayList.get(position).setLike(Integer.valueOf(like.getText().toString()));
                        arrayList.get(position).setCasi(casi.getText().toString());
                        arrayList.get(position).setTen(ten.getText().toString());
//                        database.queryData("update BH set ... = where ...");
//                        GetDL();
                        notifyDataSetChanged();
                    }
                });
                return false;
            }
        });
        return convertView;
    }
//    void GetDL() {
//        Cursor data = database.getData("select * from bh");
//        arrayList.clear();
//        while(data.moveToNext()) {
//            arrayList.add(new BHModel(data.getInt(0), data.getInt(1), data.getInt(2), data.getString(3), data.getString(4)));
//        }
//        notifyDataSetChanged();
//    }
}
