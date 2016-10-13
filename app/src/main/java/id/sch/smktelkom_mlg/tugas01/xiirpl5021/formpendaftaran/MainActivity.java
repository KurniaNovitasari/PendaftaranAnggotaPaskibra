package id.sch.smktelkom_mlg.tugas01.xiirpl5021.formpendaftaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    RadioGroup rgJK;
    CheckBox cbPbb, cbPp, cbLk, cbSb;
    Spinner spKelas;
    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bOk = (Button) findViewById(R.id.buttonOk);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        cbPbb = (CheckBox) findViewById(R.id.checkBoxPbb);
        cbPp = (CheckBox) findViewById(R.id.checkBoxPpaskib);
        cbLk = (CheckBox) findViewById(R.id.checkBoxLK);
        cbSb = (CheckBox) findViewById(R.id.checkBoxSbendera);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                tvHasil.setText("nama : " + nama);
            }

        });

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
        }

        String JK = null;
        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton RB = (RadioButton) findViewById(rgJK.getCheckedRadioButtonId());
            JK = RB.getText().toString();
        }

    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama anda belum diisi");
            valid = true;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = true;
        } else {
            etNama.setError(null);
        }
        return valid;
    }

}


