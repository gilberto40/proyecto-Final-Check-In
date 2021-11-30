package org.ort.checkin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.File

class IddleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iddle)

        val btn_des = findViewById<Button>(R.id.btn_desloguear)
        btn_des.setOnClickListener{
            SessionVariable.sessionVar = false;
            SessionVariable.finalizado = false;
            val layout = Intent(this, MainActivity::class.java )
            startActivity(layout)
        }
        SessionVariable.finalizado = true
    }
}