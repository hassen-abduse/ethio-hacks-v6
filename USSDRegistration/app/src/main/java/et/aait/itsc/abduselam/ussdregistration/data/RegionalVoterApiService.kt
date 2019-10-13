package et.aait.itsc.abduselam.ussdregistration.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RegionalVoterApiService {



    @GET("voters/regional/{phone}")
    fun getRegionalVoterByPhoneNumber(@Path("phone") phone: String): Deferred<Response<RegionalVoter>>


    @POST("voters/regional")
    fun insertRegionalVoter(@Body regionalVoter: RegionalVoter): Deferred<Response<RegionalVoter>>

    companion object {

        private val baseUrl = "http://192.168.43.11:8080/"

        fun getInstance(): RegionalVoterApiService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(RegionalVoterApiService::class.java)
        }
}
}