package com.example.exercise2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Random;

public class SewaBukuAct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DatabaseReference database;

    private Button btselesai;
    private EditText eNama;
    private EditText eAlamat;
    private EditText nohp;
    private EditText judul;
    public static String kodesewa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sewa);

        btselesai = findViewById(R.id.selesaiHitung);
        eNama = findViewById(R.id.eTNama);
        eAlamat = findViewById(R.id.eTAlamat);
        nohp = findViewById(R.id.eTHP);
        judul = findViewById(R.id.eTgenre);

        database = FirebaseDatabase.getInstance().getReference();
        btselesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r =  new Random();
                int koderandom =  r.nextInt(999999);
                kodesewa = String.format("%06d",koderandom);
                if (!(eNama.getText().toString().isEmpty()) || (eAlamat.getText().toString().isEmpty()) || (nohp.getText().toString().isEmpty()) || (judul.getText().toString().isEmpty()))
                {
                    submitData(new Data(eNama.getText().toString(), eAlamat.getText().toString(), nohp.getText().toString(), judul.getText().toString(),kodesewa));
                    startActivity(new Intent(getApplicationContext(),KodeSewaTampil.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Data Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(judul.getWindowToken(),0);
            }
        });
    }
    public void submitData(Data data){
        //

        database.child("Data").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                eNama.setText("");
                eAlamat.setText("");
                nohp.setText("");
                judul.setText("");
                Toast.makeText(getApplicationContext(), "Pemesanan Telah Disampaikan", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static Intent getActIntent(Activity activity) {
        //kode pengambilan intent
        return new Intent(activity, SewaBukuAct.class);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //
    }
}
