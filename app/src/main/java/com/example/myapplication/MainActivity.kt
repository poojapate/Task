package com.example.myapplication

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Api.RetrofitClient
import com.example.myapplication.Model.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    lateinit var Email: EditText
    lateinit var password: EditText
    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Email=findViewById(R.id.Email)
        password=findViewById(R.id.password)
        login=findViewById(R.id.login)

        login.setOnClickListener{

            LoginApi(Email.text.toString(),password.text.toString())
        }
    }

    private fun LoginApi(email: String, password: String) {

        val progressDialog = ProgressDialog(this@MainActivity)

        progressDialog.show()

        RetrofitClient.api.login(email,password)
            .enqueue(object : Callback<LoginModel?> {
                override fun onResponse(call: Call<LoginModel?>, response: Response<LoginModel?>) {

                    progressDialog.dismiss()

                    if (response.code()==200) {

                        if (response.body() != null) {

                            val loginModel: LoginModel? = response.body()

                            val Firstname: String = loginModel?.record?.firstName ?: "null"
                            val Lastname: String? =loginModel?.record?.lastName
                            val Email: String? =loginModel?.record?.email
                            val Phone: String = loginModel?.record?.phoneNo ?: "null"
                            val authtoken: String? =loginModel?.record?.authtoken


                            val intent = Intent(this@MainActivity, HomeActivity::class.java)
                            intent.putExtra("Firstname",Firstname)
                            intent.putExtra("lastname", Lastname)
                            intent.putExtra("email", Email)
                            intent.putExtra("phone", Phone)
                            intent.putExtra("token", authtoken)
                            startActivity(intent)
                        }

                    }
                }

                override fun onFailure(call: Call<LoginModel?>, t: Throwable) {
                    Log.d("failed", "failed", t)
                }
            })

    }
}