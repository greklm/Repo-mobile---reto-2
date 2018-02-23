package dscont.com.dscont.pe.app_enviocorreo;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView im_Imagen;
    Button btn_Pasar_Datos;
    EditText tb_Nombre, tb_Apellidos, tb_Edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im_Imagen = (ImageView)findViewById(R.id.iv_Imagen);
       //Cargar una imagen con picasso
        Picasso.with(MainActivity.this)
                .load("http://2.bp.blogspot.com/_XWHZbS7ASrQ/TRPciuFyb0I/AAAAAAAAAJ4/5Thi03jKjf0/s320/Carita_feliz_alegre_amarilla.png")
                .fit().centerInside()
                .into(im_Imagen);

        tb_Nombre = (EditText)findViewById(R.id.tb_Nombre);
        tb_Apellidos = (EditText)findViewById(R.id.tb_Apellidos);
        tb_Edad = (EditText)findViewById(R.id.tb_Edad);

        btn_Pasar_Datos = (Button)findViewById(R.id.btn_Pasar_Datos);
        btn_Pasar_Datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Envio_Informacion.class);
                intent.putExtra("Nombre",tb_Nombre.getText().toString());
                intent.putExtra("Apellidos",tb_Apellidos.getText().toString());
                intent.putExtra("Edad",tb_Edad.getText().toString());
                startActivity(intent);
            }
        });

    }
}
