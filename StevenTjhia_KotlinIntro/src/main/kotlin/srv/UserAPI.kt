package srv

//import dto.CreateUserReq
//import dto.CreateUserResp
import dto.User
import dto.UserRequest
import dto.UserResponse
import dto.Users
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
//import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
//import retrofit2.http.POST
import retrofit2.http.Path

interface UserAPI {

    // GET users
    @GET("users")
    fun getUsers(): Call<Users>

    // GET user by id
    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Call<User>

    @POST("users")
    fun createUser(@Body req : UserRequest) : Call<UserResponse>
}