package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTaille, editAge, editPoids;
    TextView txtResultat, txtInterpretation;
    RadioButton rdbFemme,rdbHomme;
    Button btnCalcule;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAge = (EditText) findViewById(R.id.editAge);
        editPoids = (EditText) findViewById(R.id.editPoids);
        editTaille = (EditText) findViewById(R.id.editTaille);
        txtResultat = (TextView) findViewById(R.id.txtResultat);
        txtInterpretation = (TextView) findViewById(R.id.txtInterpretation);
        rdbFemme = (RadioButton) findViewById(R.id.rdbFemme);
        rdbHomme = (RadioButton) findViewById(R.id.rdbHomme);
        btnCalcule = (Button) findViewById(R.id.btnCalcule);


        btnCalcule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float poids;
                Float taille;
                int age;
                Float img;
                Float imc;
                int sexe;

                poids = Float.parseFloat(editPoids.getText().toString());
                taille = Float.parseFloat(editTaille.getText().toString());
                age = Integer.parseInt(editAge.getText().toString());


                if (rdbFemme.isChecked())
                    sexe = 0;
                else
                    sexe = 1;
                //Conversion taille en mètres
                taille = taille / 100;
                imc = poids / (taille * taille);

                if (age >= 16)
                    img = (float) ((1.20 * imc) + (0.23 * age) - (10.8 * sexe) - 5.4);
                else
                    img = (float) ((1.51 * imc) + (0.70 * age) - (3.6 * sexe) - 1.4);

                txtResultat.setText("Votre IMG est " + img + " %");
                if (sexe == 0) {
                    if (img < 25)
                        txtInterpretation.setText("Interprétation : Trop maigre");
                    else if ((img >= 25) && (img <= 30))
                        txtInterpretation.setText("Interprétation : Pourcentage normal");
                    else
                        txtInterpretation.setText("Interprétation : Trop de graisse");
                } else {
                    if (img < 15)
                        txtInterpretation.setText("Interprétation : Trop maigre");
                    else if ((img >= 15) && (img <= 20))
                        txtInterpretation.setText("Interprétation : Pourcentage normal");
                    else
                        txtInterpretation.setText("Interprétation : Trop de graisse");
                }
            }
        });


    }
}