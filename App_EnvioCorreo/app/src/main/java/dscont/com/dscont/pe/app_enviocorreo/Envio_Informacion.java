package dscont.com.dscont.pe.app_enviocorreo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Envio_Informacion extends AppCompatActivity {

    Button btn_Compartir_Informacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_informacion);

        //Obtener los datos enviados desde la actiavidad anterior
        Bundle bundle = getIntent().getExtras();
        String Nombre = bundle.getString("Nombre");
        String Apellidos = bundle.getString("Apellidos");
        String Edad = bundle.getString("Edad");

        final String Texto_Enviar = "Nombres: " + Nombre + "\n"+ "Apellidos: " + Apellidos + "\n" + "Edad: " + Edad;
        btn_Compartir_Informacion =(Button)findViewById(R.id.btn_Compartir_Informacion);
        btn_Compartir_Informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, Texto_Enviar);
                shareIntent.setType("text/plain");
                startActivity(shareIntent);

            }
        });
    }
}
