package com.example.networkdemo.kotlinlearn

import com.example.networkdemo.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun main() {
    val users= ArrayList<User>()
    users.add(User("zhangsan","123456"))
    users.add(User("lisi","123456"))
    //val users=listOf(User("zhangsan","123456"),User("lisi","123456"))
    val json=Gson().toJson(users)
    //println(json)
    val user2=Gson().fromJson<List<User>>(json,object:TypeToken<List<User>>(){}.type)
    for(u in user2){
        println(u.username+","+u.password)
    }

}