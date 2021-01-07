package com.example.networkdemo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_picture_test_activiy.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class PictureTestActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val downloadImage=1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_test_activiy)
        //网络图片

        val girl="girl.jpeg"
        val url="http://39.108.112.201:8080/images/"+girl

        //创建handler
        val handler=object :Handler(){
            override fun handleMessage(msg: Message) {
                //更新imageView
                when(msg.what){
                    downloadImage->{
                        val image=msg.obj as Bitmap
                        imageView3.setImageBitmap(image)
                    }
                }
            }
        }
        //btn单击事件
        button5.setOnClickListener {
            //创建一个新线程
            thread {
                val urlConnection= URL(url)
                var connection = urlConnection.openConnection() as HttpURLConnection
                connection.connectTimeout=5000

                //响应
                if(connection.responseCode==HttpURLConnection.HTTP_OK){
                    //获取输入流，就是读取图片
                    var inputStream = connection.inputStream
                    //把流转换为图片文件
                    val image=BitmapFactory.decodeStream(inputStream)
                    //创建消息
                    val msg=Message()
                    //设置参数
                    msg.what=downloadImage
                    msg.obj=image
                    handler.sendMessage(msg)
                }
            }
        }
    }
}