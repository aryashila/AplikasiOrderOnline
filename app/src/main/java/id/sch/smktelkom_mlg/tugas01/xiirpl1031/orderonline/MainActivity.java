package id.sch.smktelkom_mlg.tugas01.xiirpl1031.orderonline;

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
    EditText etNama, etNH, etAl, etCumi, etKepiting, etUdang, etKerang, etIkan;
    Button bOrder;
    TextView tvHasil;
    RadioGroup rgMetod;
    Spinner spCabang;
    CheckBox cbCumi, cbIkan, cbKepiting, cbKerang, cbUdang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNH = (EditText) findViewById(R.id.editTextNome);
        etAl = (EditText) findViewById(R.id.editTextAlam);
        bOrder = (Button) findViewById(R.id.buttonOrder);

        rgMetod = (RadioGroup) findViewById(R.id.radioGroupMtd);
        spCabang = (Spinner) findViewById(R.id.spinnerCab);
        cbCumi = (CheckBox) findViewById(R.id.checkBoxCumi);
        cbIkan = (CheckBox) findViewById(R.id.checkBoxIkan);
        cbKepiting = (CheckBox) findViewById(R.id.checkBoxKepiting);
        cbKerang = (CheckBox) findViewById(R.id.checkBoxKerang);
        cbUdang = (CheckBox) findViewById(R.id.checkBoxUdang);
        etCumi = (EditText) findViewById(R.id.editTextC);
        etUdang = (EditText) findViewById(R.id.editTextU);
        etIkan = (EditText) findViewById(R.id.editTextI);
        etKepiting = (EditText) findViewById(R.id.editTextKep);
        etKerang = (EditText) findViewById(R.id.editTextKer);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        etCumi.setText("0");
        etUdang.setText("0");
        etIkan.setText("0");
        etKepiting.setText("0");
        etKerang.setText("0");


        bOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();
            }
        });

        rgMetod.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonPU) {
                    findViewById(R.id.tiAL).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.tiAL).setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void doProcess() {

        if (isValid())
        {
            String nama = etNama.getText().toString();
            String alamat = etAl.getText().toString();
            String nomer = etNH.getText().toString();

            String hasil2 = "Menu yang anda pilih : \n";
            int startlen = hasil2.length();

            if (hasil2.length() == startlen) hasil2 += "Belum memilih menu ";
            tvHasil.setText(hasil2);

        }

        String hasil = null;
        if (rgMetod.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgMetod.getCheckedRadioButtonId());
            hasil = rb.getText().toString();

            if (rgMetod.getCheckedRadioButtonId() != R.id.radioButtonPU) {
                EditText etALM = (EditText) findViewById(R.id.editTextAlam);
                hasil += "\nPesanan akan dikirim pada alamat : " + etALM.getText();
            }
        }


        if (hasil == null) {
            String hasil2 = "Menu yang anda pilih : \n";
            int startlen = hasil2.length();

            if (hasil2.length() == startlen) hasil2 += "Belum memilih menu ";
            tvHasil.setText("Belum memilih metode pemesanan " + "\n" + hasil2);
        } else {
            String nama = etNama.getText().toString();
            String alamat = etAl.getText().toString();
            String nomer = etNH.getText().toString();
            String cabang = spCabang.getSelectedItem().toString();

            String hasil2 = "Menu yang anda pilih : \n";
            String awal = "Nama : " + nama + "\n" + "No. Hp : " + nomer + "\n" + "Metode pemesanan : " + hasil + "\n" + "Anda memesan pada cabang : " + cabang + "\n";
            int startlen = hasil2.length();
            if (cbCumi.isChecked())
                hasil2 += cbCumi.getText() + "\n";
            tvHasil.setText(awal + hasil2);
            if (cbUdang.isChecked())
                hasil2 += cbUdang.getText() + "\n";
            tvHasil.setText(awal + hasil2);
            if (cbKepiting.isChecked())
                hasil2 += cbKepiting.getText() + "\n";
            tvHasil.setText(awal + hasil2);
            if (cbIkan.isChecked())
                hasil2 += cbIkan.getText() + "\n";
            tvHasil.setText(awal + hasil2);
            if (cbKerang.isChecked())
                hasil2 += cbKerang.getText() + "\n";
            tvHasil.setText(awal + hasil2);

            boolean valid = true;


            String jumlah1 = etCumi.getText().toString().trim();
            int x = 0;
            if (jumlah1.isEmpty()) {
                etCumi.setError("Menu yang tidak dipilih");
                valid = false;
            } else {
                x = Integer.parseInt(jumlah1);
            }
            String jumlah2 = etUdang.getText().toString().trim();
            int y = 0;
            if (jumlah2.isEmpty()) {
                etUdang.setError("Menu yang tidak dipilih");
                valid = false;
            } else {
                y = Integer.parseInt(jumlah2);
            }

            String jumlah3 = etIkan.getText().toString().trim();
            int z = 0;
            if (jumlah3.isEmpty()) {
                etIkan.setError("Menu yang tidak dipilih");
                valid = false;
            } else {
                z = Integer.parseInt(jumlah3);
            }
            String jumlah4 = etKepiting.getText().toString().trim();
            int w = 0;
            if (jumlah4.isEmpty()) {
                etKepiting.setError("Menu yang tidak dipilih");
                valid = false;
            } else {
                w = Integer.parseInt(jumlah4);
            }
            String jumlah5 = etKerang.getText().toString().trim();
            int v = 0;
            if (jumlah5.isEmpty()) {
                etKerang.setError("Menu yang tidak dipilih");
                valid = false;
            } else {
                v = Integer.parseInt(jumlah5);
            }


            int total1 = x * 45000;
            int total2 = y * 70000;
            int total3 = z * 60000;
            int total4 = w * 30000;
            int total5 = v * 25000;

            int grandd = TotalSemua(total1, total2, total3, total4, total5);
            String output = String.valueOf(grandd);
            tvHasil.setText("Nama : " + nama + "\n" + "No. Hp : " + nomer + "\n" + "Metode pemesanan : " + hasil + "\n" + "Anda memesan makanan pada cabang : " + spCabang.getSelectedItem().toString() + "\n" + hasil2 + "Total pemesanan anda : Rp. " + output.toString());
        }


//        tvHasil.setText("Nama : "+nama+"\n"+ "No. Hp : " + nomer+"\n"+"Metode pemesanan : "+hasil+"\n"+"Anda memesan makanan pada cabang : "+spCabang.getSelectedItem().toString()+"\n"+hasil2);


    }

    private int TotalSemua(int total1, int total2, int total3, int total4, int total5) {
        return total1 + total2 + total3 + total4 + total5;
    }

    private boolean isValid() {

        boolean valid = true;

        String nama = etNama.getText().toString();
        String alamat = etAl.getText().toString();
        String nomer = etNH.getText().toString();
        String cumi = etCumi.getText().toString();
        String udang = etUdang.getText().toString();
        String kepiting = etKepiting.getText().toString();
        String kerang = etKerang.getText().toString();
        String ikan = etIkan.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama Belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (alamat.isEmpty()) {
            etAl.setError("Alamat belum diisi");

            valid = false;
        } else {
            etAl.setError(null);
        }

        if (nomer.isEmpty()) {
            etNH.setError("Masukan nomer telepon Anda");
            valid = false;
        } else if (nomer.length() < 12) {
            etNH.setError("Format nomer kurang dari 12 digit");
            valid = false;
        } else {
            etNH.setError(null);
        }


        return valid;
    }
}
