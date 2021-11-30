package org.ort.checkin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoPhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_photo)

        val siguiente      = findViewById<Button>(R.id.btn_next_register_three)

        val tipo = getIntent().getExtras()?.getString("tipo");
        val numero = getIntent().getExtras()?.getString("numero");

        siguiente.setOnClickListener{
            val layout = Intent(this, TakePhotoActivity::class.java )
            layout.putExtra("tipo", tipo);
            layout.putExtra("numero", numero);
            startActivity(layout)
        }

        val btn_des = findViewById<Button>(R.id.btn_desloguear)

        btn_des.setOnClickListener{
            SessionVariable.sessionVar = false;
            val layout = Intent(this, MainActivity::class.java )
            startActivity(layout)
        }
    }

    override fun onStart() {
        super.onStart()
        if(SessionVariable.Companion.finalizado){
            val layout = Intent(this, IddleActivity::class.java )
            startActivity(layout)
        }
    }
}