package com.example.conversordistancias;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    //Declaramos los campos del activity_main
    EditText etnombre;
    Spinner spinner1;
    Spinner spinner2;
    TextView tvMensaje;
    ArrayAdapter<String> adaptador1;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos Array para los dos Spinner
        String[] distancias = {" ","Metros cuadrados", "Kms cuadrados", "Pies", "Millas"};

        adaptador1 = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, distancias);
        spinner1 = findViewById(R.id.spinner_1);
        spinner1.setAdapter(adaptador1);

        spinner2 = findViewById(R.id.spinner_3);
        spinner2.setAdapter(adaptador1);



        Button miboton = findViewById(R.id.button);

        //Cuando apretamos el botón tendra en cuenta lo que hay en su interior

        miboton.setOnClickListener(v -> {

            //Recoge los valores introducidos en el campo etnombre y los spinner
            etnombre = findViewById(R.id.txt_num1);
            String valorOrigen = spinner1.getSelectedItem().toString();
            String valorDestino = spinner2.getSelectedItem().toString();

            //Da salida al valor de los anteriores campos
            tvMensaje = findViewById(R.id.txt_num2);

            //Recoge lectura del valor del campo etnombre

            if(etnombre.getText().toString().trim().isEmpty()){
                //Campo vacio sin contenido númerico

                Toast toast2 =
                        Toast.makeText(getApplicationContext(),
                                "Introduce valor númerico", Toast.LENGTH_LONG);

                toast2.show();


            }else {

                //Tiene valor númerico, ejecuta el resto del programa

                double num1, num2;
                double resultadoNumero;
                //Establece valor de dos decimales
                DecimalFormat formato = new DecimalFormat("0.00");


                /*Establece valor de dos decimales estadístico
                 a los campos que pueden mostrar numeros pequeños*/

                DecimalFormat formato2 = new DecimalFormat("0.00E00");

                //Si el valor de los spinner es el mismo se multiplicará por uno la salida
                if ((valorOrigen.equals(valorDestino))) {
                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = 1;
                    resultadoNumero = num1 * num2;
                    tvMensaje.setText(formato.format(resultadoNumero));

                } else if ((valorOrigen.equals("Metros cuadrados")) & (valorDestino.equals("Kms cuadrados"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 1000;
                    resultadoNumero = num1 / num2;
                    tvMensaje.setText((formato2.format(resultadoNumero)));

                } else if ((valorOrigen.equals("Metros cuadrados")) & (valorDestino.equals("Pies"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 3.28;
                    resultadoNumero = num1 * num2;
                    tvMensaje.setText(formato.format(resultadoNumero));
                } else if ((valorOrigen.equals("Metros cuadrados")) & (valorDestino.equals("Millas"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 1609;
                    resultadoNumero = num1 / num2;
                    tvMensaje.setText(formato2.format(resultadoNumero));
                } else if ((valorOrigen.equals("Kms cuadrados")) & (valorDestino.equals("Metros cuadrados"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 1000;
                    resultadoNumero = num1 * num2;
                    tvMensaje.setText(formato.format(resultadoNumero));
                } else if ((valorOrigen.equals("Kms cuadrados")) & (valorDestino.equals("Pies"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 3281;
                    resultadoNumero = num1 * num2;
                    tvMensaje.setText(formato.format(resultadoNumero));
                } else if ((valorOrigen.equals("Kms cuadrados")) & (valorDestino.equals("Millas"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 1.609;
                    resultadoNumero = num1 / num2;
                    tvMensaje.setText(formato.format(resultadoNumero));
                } else if ((valorOrigen.equals("Pies")) & (valorDestino.equals("Metros cuadrados"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 3.281;
                    resultadoNumero = num1 / num2;
                    tvMensaje.setText(formato.format(resultadoNumero));
                } else if ((valorOrigen.equals("Pies")) & (valorDestino.equals("Kms cuadrados"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 3281;
                    resultadoNumero = num1 / num2;
                    tvMensaje.setText(formato2.format(resultadoNumero));
                } else if ((valorOrigen.equals("Pies")) & (valorDestino.equals("Millas"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 5280;
                    resultadoNumero = num1 / num2;
                    tvMensaje.setText(formato2.format(resultadoNumero));
                } else if ((valorOrigen.equals("Millas")) & (valorDestino.equals("Metros cuadrados"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 1609;
                    resultadoNumero = num1 * num2;
                    tvMensaje.setText(formato.format(resultadoNumero));
                } else if ((valorOrigen.equals("Millas")) & (valorDestino.equals("Kms cuadrados"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 1.609;
                    resultadoNumero = num1 * num2;
                    tvMensaje.setText(formato.format(resultadoNumero));
                } else if ((valorOrigen.equals("Millas")) & (valorDestino.equals("Pies"))) {

                    num1 = Integer.parseInt(etnombre.getText().toString());
                    num2 = (float) 5280;
                    resultadoNumero = num1 * num2;
                    tvMensaje.setText(formato.format(resultadoNumero));
                } else if ((valorOrigen.equals(" ")) || (valorDestino.equals(" "))) {

                //Si alguno de los campos está vacío mostrará el siguiente mensaje
                    tvMensaje.setText("Corrige la conversión");
                }


            }

        });
    }


}

