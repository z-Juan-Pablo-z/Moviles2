package com.example.juanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton jrbcartagena,jrbamazonas,jrbcancun;
    CheckBox jcbguia,jcbtransporte;
    TextView jtvciudad,jtvguia,jtvtransporte,jtvtotal,jtvmensaje1,jtvmensaje2;
    EditText jetcantidad;
    Button jbtncalcular,jbtnlimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        jrbcartagena = findViewById(R.id.rbcartagena);
        jrbamazonas = findViewById(R.id.rbamazonas);
        jrbcancun = findViewById(R.id.rbcancun);

        jtvciudad=findViewById(R.id.tvciudad);
        jtvguia=findViewById(R.id.tvGuia);
        jtvtransporte=findViewById(R.id.tvtransporte);
        jtvtotal=findViewById(R.id.tvtotal);
        jtvmensaje1=findViewById(R.id.tvmensaje1);
        jtvmensaje2=findViewById(R.id.tvmensaje2);

        jcbguia=findViewById(R.id.cbguia);
        jcbtransporte=findViewById(R.id.cbtransporte);


        jetcantidad=findViewById(R.id.etcantidad);

        jbtncalcular=findViewById(R.id.btncalcular);
        jbtnlimpiar=findViewById(R.id.btnlimpiar);



    }
    public void calcularTotal (View view) {
        String cantidad;
        cantidad = jetcantidad.getText().toString();
        if (cantidad.isEmpty()) {
            jetcantidad.requestFocus();
            Toast.makeText(this, " La cantidad de personas es requerida", Toast.LENGTH_SHORT).show();
        } else {
            int cant, ciudad, guia, transporte, subtotal;
            float iva, total_viaje;

            cant = Integer.parseInt(cantidad);
            if (cant < 1) {
                Toast.makeText(this, "cantidad de personas mayor de 0 ", Toast.LENGTH_SHORT).show();
                jetcantidad.requestFocus();
            } else {
                if (jrbcartagena.isChecked()) {
                    jtvciudad.setText("600000");
                    ciudad = 600000;
                } else {
                    if (jrbamazonas.isChecked()) {
                        jtvciudad.setText("200000");
                        ciudad = 200000;
                    } else {
                        jtvciudad.setText("3200000");
                        ciudad = 3200000;
                    }
                }
                if (jcbguia.isChecked()){
                    jtvguia.setText("120000");
                    guia=120000;
                }else{
                    jtvguia.setText("0");
                    guia=0;
                }
                if (jcbtransporte.isChecked()){
                    jtvtransporte.setText("50000");
                    transporte=50000;
                }else{
                    jtvtransporte.setText("0");
                    transporte=0;
                }
                subtotal=(ciudad*cant)+(cant*transporte)+guia;
                iva=((float)(subtotal*19)/100);
                total_viaje=subtotal+iva+guia+(cant*transporte);
                jtvtotal.setText(String.valueOf(total_viaje));
            }
        }
    }
    public void Limpiar(View view){
        jtvtotal.setText("0");
        jtvguia.setText("0");
        jtvtransporte.setText("0");
        jtvciudad.setText("0");
        jetcantidad.setText("");
        jetcantidad.requestFocus();
        jrbcartagena.setChecked(true);
        jcbtransporte.setChecked(false);
        jcbguia.setChecked(false);
    }
}
