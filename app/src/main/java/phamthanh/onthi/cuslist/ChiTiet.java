package phamthanh.onthi.cuslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ChiTiet extends AppCompatActivity {
    ImageView imnhan;
    TextView tennhan, tuoinhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        tennhan = findViewById(R.id.tennhan);
        tuoinhan = findViewById(R.id.tuoinhan);
        Intent intent = this.getIntent();
        tennhan.setText(intent.getStringExtra("ten"));
        tuoinhan.setText(String.valueOf(intent.getIntExtra("tuoi",0)));
    }
}