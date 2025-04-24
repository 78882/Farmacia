package farmacia;

import com.example.farmacia.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditMedActivity extends AppCompatActivity {

    private EditText editMedName;
    private EditText editDescription;
    private TimePicker timePicker;
    private Button btnSaveMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_med);


        editMedName     = findViewById(R.id.editTextMedName);
        editDescription = findViewById(R.id.editTextDescription);
        timePicker      = findViewById(R.id.timePicker);
        btnSaveMed      = findViewById(R.id.btnSaveMed);


        timePicker.setIs24HourView(true);


        btnSaveMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editMedName.getText().toString().trim();
                String desc = editDescription.getText().toString().trim();
                int hour   = timePicker.getHour();
                int minute = timePicker.getMinute();

                if (name.isEmpty()) {
                    editMedName.setError("Nome obrigatório");
                    return;
                }

                String time = String.format("%02d:%02d", hour, minute);

                Intent result = new Intent();
                result.putExtra("medName", name);
                result.putExtra("medDesc", desc);
                result.putExtra("medTime", time);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}