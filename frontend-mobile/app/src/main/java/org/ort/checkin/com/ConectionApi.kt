package org.ort.checkin.com

import android.preference.PreferenceManager
import com.google.gson.Gson

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.ort.checkin.SessionVariable.Companion.sessionVar
import java.sql.DriverManager.println

class ConectionApi {


    lateinit var service: ApiService
    var saveRes: Boolean = false

    constructor(){
        connect()
    }

    fun connect() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.22:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<ApiService>(ApiService::class.java)
    }

    fun validateUser(email: String, cod_reserva: Int) {
        var post: BodyValidator? = BodyValidator(email)
        var responses: Post?

        service.validarUsuarioByEmailYCod(0, cod_reserva, post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                responses = response?.body()
                sessionVar = responses != null
                println("gm****************************" + Gson().toJson(responses))
            }

            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                println("porerror******")
            }
        })
    }

    fun updateUser(foto: String, tipo: String, documento: String) {
        var post: BodyActualizar? = BodyActualizar(foto,tipo,documento)
        var responses: Post?

        service.actualizarReserva(0, 0,true , post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                responses = response?.body()
                sessionVar = responses != null
                println("gm****************************" + Gson().toJson(responses))
            }

            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                println("porerror******")
            }
        })
    }


}