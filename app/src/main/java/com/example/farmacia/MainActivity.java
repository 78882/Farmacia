package farmacia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAddMed;
    private ListView listViewMeds;
    private MedicineAdapter adapter;
    private ArrayList<Medicine> medList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddMed = findViewById(R.id.btnAddMed);
        listViewMeds = findViewById(R.id.listViewMeds);
        medList = new ArrayList<>();

        adapter = new MedicineAdapter(this, medList);
        listViewMeds.setAdapter(adapter);


        btnAddMed.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEditMedActivity.class);
            startActivityForResult(intent, 1);
        });


        listViewMeds.setOnItemLongClickListener((parent, view, position, id) -> {
            medList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String nome = data.getStringExtra("nome");
            String descricao = data.getStringExtra("descricao");
            String horario = data.getStringExtra("horario");

            Medicine newMed = new Medicine(nome, descricao, horario);
            medList.add(newMed);
            adapter.notifyDataSetChanged();
        }
    }
}