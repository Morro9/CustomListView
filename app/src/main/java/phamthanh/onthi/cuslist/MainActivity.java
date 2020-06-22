package phamthanh.onthi.cuslist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<NV> listnv = new ArrayList<NV>();
    AdapterL adapter;
    ListView listView;
    EditText edtTen, edtTuoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);

        adapter = new AdapterL(this, R.layout.item,listnv);
        listView.setAdapter(adapter);
        listnv.add(new NV("tra",12));
        adapter.notifyDataSetChanged();
        anhxa();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ten1 = listnv.get(position).getTen();
                Integer tuoi1= listnv.get(position).getTuoi();
                Intent intent = new Intent(MainActivity.this, ChiTiet.class);
                intent.putExtra("ten",ten1);
                intent.putExtra("tuoi",tuoi1);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận xóa?");
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listnv.remove(position);
                        Toast.makeText(MainActivity.this,"Xoa thành công",Toast.LENGTH_LONG).show();
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog al = builder.create();
                al.show();
                return false;
            }
        });

    }
    private void anhxa() {

        edtTen = findViewById(R.id.edt1);
        edtTuoi = findViewById(R.id.edt2);
        (findViewById(R.id.them)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themNV();
            }
        });
        (findViewById(R.id.nhaplai)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTen.setText("");;
                edtTuoi.setText("");;
            }
        });
    }

    private void themNV() {
        NV n = new NV();
        String t1 = edtTen.getText().toString();
        Integer t2 = Integer.parseInt(edtTuoi.getText().toString());
        n.setTen(t1);
//        Log.e("ten",t1);
//        Log.e("tuoi",t2.toString());
        try{
            n.setTuoi(t2);}
        catch(NumberFormatException e){n.setTuoi(0);}
        if(n!=null){
            listnv.add(n);
            Toast.makeText(this,"Thêm thành công",Toast.LENGTH_LONG).show();
        }
        listView.deferNotifyDataSetChanged();
//        adapter.clear();
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}