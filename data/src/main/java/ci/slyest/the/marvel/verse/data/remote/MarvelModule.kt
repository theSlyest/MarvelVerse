package ci.slyest.the.marvel.verse.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MarvelModule {

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .client(
            OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().also { it.setLevel(HttpLoggingInterceptor.Level.BODY) })
            .build())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    internal fun service() = retrofit.create(MarvelService::class.java)
}