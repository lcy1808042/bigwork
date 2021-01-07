package com.example.networkdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.networkdemo.model.Student
import com.example.networkdemo.service.StudentService
import com.example.networkdemo.util.ServerCreator
import kotlinx.android.synthetic.main.activity_fifth.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        button.setOnClickListener {
            //1. 获取Service实例对象
            val studentService= ServerCreator.create<StudentService>();
//2. 调用实例对象方法，由于需要网络请求，需要继续调用enqueue方法
            studentService.getStudentData().enqueue(object: Callback<List<Student>> {
                override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                    t.printStackTrace()
                }
                //3. 请求成功！
                override fun onResponse(
                    call: Call<List<Student>>,
                    response: Response<List<Student>>
                ) {
                    var students = response.body()
                    if(students!=null){
                        for(s in students){
                            Log.w("FourthActivity",s.toString() )
                        }
                    }
                }

            })
        }
    }
}