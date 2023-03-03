import builder.SrvBuilder
import dto.*
import retrofit2.Call
import retrofit2. Response
import retrofit2.Callback

fun main() {

    getUser()

    getUsers()

    postUserApi()

}

fun getUser() {
    val userCall = SrvBuilder.instance.getUser(1)

    userCall.enqueue(object: Callback<User> {
        override fun onResponse(call: Call<User>, response: Response<User>) {
            val user = response.body()!!
            println("============================")
            println("       HASIL GET")
            println("----------------------------")
            println("userSingle: ${user.data}")
        }

        override fun onFailure(call: Call<User>, t: Throwable) {
            println("ERROR: $t")
        }
    })
}

fun postUserApi() {
    var userReq = UserRequest()
    userReq.name = "Tes Nama 1"
    userReq.job = "Tes Job 1"

    val postUserCall = SrvBuilder.instance.createUser(userReq)
    postUserCall.enqueue(object: Callback<UserResponse> {
        override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
            if (response.isSuccessful) {
                val userPost = response.body()!!
                println("============================")
                println("       HASIL POST")
                println("----------------------------")
                println("name: ${userPost!!.name}")
                println("job: ${userPost!!.job}")
                println("id: ${userPost!!.id}")
                println("createdAt : ${userPost!!.createdAt}")
            } else {
                println("reason: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            println("ERROR: $t")
        }
    })
}

fun getUsers() {
//    val retrofitBuilder = retrofit2.Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create())
//        .baseUrl(BASE_URL)
//        .build()
//        .create(Api::class.java)

    val usersCall = SrvBuilder.instance.getUsers()

    usersCall.enqueue(object: Callback<Users> {
        override fun onResponse(call: Call<Users>, response: Response<Users>) {
            if (response.isSuccessful) {
                val userArr = response.body()!!
                userArr.data.forEach {
                    println("user: $it")
                }
            } else {
                println("reason: ${response.message()}")
            }
        }

        override fun onFailure(call: Call<Users>, t: Throwable) {
            println("ERROR: $t")
        }


    })
}
