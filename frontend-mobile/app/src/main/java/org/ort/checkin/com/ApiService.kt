package org.ort.checkin.com

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.POST

import retrofit2.http.Multipart
import okhttp3.RequestBody

import android.R.id








interface ApiService {

//    @GET("posts/")
//    fun getAllPosts(): Call<List<Post>>
//
//    @GET("posts/{id}")
//    fun getPostById(@Path("id") id: Int): Call<Post>

    @POST("{idHotel}/{codReserva}/validar")
    fun validarUsuarioByEmailYCod(@Path("idHotel") id: Int, @Path("codReserva") codReserva: Int, @Body post: BodyValidator?): Call<Post>

    @PUT("{idHotel}/{codReserva}/actualizar/{isWeb}")
    fun actualizarReserva(
        @Path("idHotel") id: Int,
        @Path("codReserva") codReserva: Int,
        @Path("isWeb")  isWeb: Boolean,
        @Body post: BodyActualizar?
        ):Call<Post>

}