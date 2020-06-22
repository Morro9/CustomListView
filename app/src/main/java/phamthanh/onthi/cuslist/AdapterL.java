package phamthanh.onthi.cuslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.List;

class AdapterL extends ArrayAdapter<NV> {
    int layout;
    List<NV> list;
    Context context;

    public AdapterL(@NonNull Context context, int layout, @NonNull List<NV> list) {
        super(context, layout, list);
        this.list = list;
        this.layout = layout;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        TextView tvten = convertView.findViewById(R.id.tv1);
        TextView tvtuoi = convertView.findViewById(R.id.tv2);

        tvten.setText(list.get(position).getTen());
        tvtuoi.setText(String.valueOf(list.get(position).getTuoi()));
        return convertView;
    }
}