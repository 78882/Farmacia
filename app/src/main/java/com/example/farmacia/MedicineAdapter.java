package farmacia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.List;

public class MedicineAdapter extends ArrayAdapter<Medicine> {

    public MedicineAdapter(Context context, List<Medicine> medicines) {
        super(context, 0, medicines);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Medicine med = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        TextView title    = convertView.findViewById(android.R.id.text1);
        TextView subtitle = convertView.findViewById(android.R.id.text2);


        title.setText(med.getName() + " às " + med.getTime());


        subtitle.setText(med.getDescription());


        int color = med.isTaken()
                ? ContextCompat.getColor(getContext(), android.R.color.holo_green_light)
                : ContextCompat.getColor(getContext(), android.R.color.transparent);
        convertView.setBackgroundColor(color);

        return convertView;
    }
}