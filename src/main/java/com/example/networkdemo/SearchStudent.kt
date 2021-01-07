package com.example.networkdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.networkdemo.model.ResultOV
import com.example.networkdemo.model.Student
import com.example.networkdemo.util.HttpUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_search_student.*
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import kotlin.concurrent.thread

class SearchStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_student)
        var students:List<Student>?=null
        button4.setOnClickListener {
            val requestData=HashMap<String,String>()
            requestData.put("userName",editTextTextPersonName.text.toString())


           // sendRequestWithOkHttp("http://39.108.112.201:8080/searchStudentServlet","post",requestData)
            HttpUtil.sendOkHttpRequest("http://39.108.112.201:8080/searchStudentServlet",requestData,object:
                Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("MainActivity","发生错误")
                }

                override fun onResponse(call: Call, response: Response) {
                    val resultData=response.body?.string()
                    val type=object: TypeToken<List<Student>>(){}.type
                    students = Gson().fromJson<List<Student>>(resultData, type)


//                    Looper.prepare();
//                        Toast.makeText(this@SearchStudent,students?.get(0)!!.stuName,Toast.LENGTH_LONG).show()
//                    Looper.loop();

                    val intent = Intent(this@SearchStudent, StudentInfo::class.java)
                    val bundle = Bundle()

                    if(students!=null) {
                        bundle.putString("stuNo", students?.get(0)!!.stuNo)
                        bundle.putString("stuName", students?.get(0)!!.stuName)
                        bundle.putString("classes", students?.get(0)!!.classes)
                        bundle.putString("gender", students?.get(0)!!.gender)
                        bundle.putString("department", students?.get(0)!!.department)
                        bundle.putString("tel", students?.get(0)!!.tel)
                        bundle.putString("dormNo", students?.get(0)!!.dormNo)
                        bundle.putString("photoPath",students?.get(0)!!.photoPath)
                        intent.putExtra("Student", bundle);
                    }
                    startActivity(intent)

                }

            })

//            val intent = Intent(this@SearchStudent, StudentInfo::class.java)
//            val bundle = Bundle()
//
//            if(students!=null) {
//                bundle.putString("stuNo", students?.get(0)!!.stuNo)
//                bundle.putString("stuName", students?.get(0)!!.stuName)
//                bundle.putString("classes", students?.get(0)!!.classes)
//                bundle.putString("gender", students?.get(0)!!.gender)
//                bundle.putString("department", students?.get(0)!!.department)
//                bundle.putString("tel", students?.get(0)!!.tel)
//                bundle.putString("dormNo", students?.get(0)!!.dormNo)
//                intent.putExtra("Student", bundle);
//            }
//                startActivity(intent)

        }
    }

    private fun sendRequestWithOkHttp(url:String,method:String,data:Map<String,String>){
        thread {
            try {
                val client= OkHttpClient()
                val userName=data.get("userName").toString()

                val requestBody= FormBody.Builder()
                    .add("userName",userName)
                    .build()
                val request= Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build()
                val response=client.newCall(request).execute()
                val responseData=response.body?.string()
                if(responseData!=null){
                    dealResponse(responseData)
                }


            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun dealResponse(responseData:String){
        Log.d("MainActivity",responseData)
        Toast.makeText(this,responseData, Toast.LENGTH_LONG).show()
        var result = Gson().fromJson(responseData, ResultOV::class.java)
        if(result.result=="ok"){
            val intentOK: Intent = Intent(this,SecondActivity::class.java)

            startActivity(intentOK)
        }else if(result.result=="false"){
            //跳转到main2
            val intentError: Intent = Intent(this,MainActivity2::class.java)

            startActivity(intentError)
        }
    }
}