package farmacia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditMedActivity extends AppCompatActivity {

    private EditText editTextMedName;
    private EditText editTextDescription;
    private TimePicker timePicker;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_med);

        editTextMedName = findViewById(R.id.editTextMedName);
        editTextDescription = findViewById(R.id.editTextDescription);
        timePicker = findViewById(R.id.timePicker);
        btnSave = findViewById(R.id.btnSaveMed);

        if (getIntent() != null && getIntent().hasExtra("name")) {
            editTextMedName.setText(getIntent().getStringExtra("name"));
            editTextDescription.setText(getIntent().getStringExtra("description"));
        }

        btnSave.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", editTextMedName.getText().toString());
            resultIntent.putExtra("description", editTextDescription.getText().toString());
            resultIntent.putExtra("time", getTimeFromPicker());
            resultIntent.putExtra("taken", false);

            int position = getIntent().getIntExtra("position", -1);
            if (position != -1) {
                resultIntent.putExtra("position", position);
            }

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    private String getTimeFromPicker() {
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        return String.format("%02d:%02d", hour, minute);
    }
}
