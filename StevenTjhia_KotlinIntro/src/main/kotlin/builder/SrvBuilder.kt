package builder

import retrofit2.converter.gson.GsonConverterFactory
import srv.UserAPI

object SrvBuilder {
    private const val BASE_URL = "https://reqres.in/api/"

    val instance: UserAPI by lazy{
        val retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(UserAPI::class.java)
    }
}