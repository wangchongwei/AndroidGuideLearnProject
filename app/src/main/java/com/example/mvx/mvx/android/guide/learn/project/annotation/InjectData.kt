package com.example.mvx.mvx.android.guide.learn.project.annotation

import android.app.Activity
import android.text.TextUtils

object InjectData {
    @JvmStatic
    @Throws(IllegalAccessException::class)
    fun inject(activity: Activity) {
        val cls: Class<out Activity> = activity.javaClass
        // 获取Activity中所有的成员属性
        val declaredFields = cls.declaredFields
        for (filed in declaredFields) {
            // 判断是否该成员属性是否有 @InjectIntent 注解
            if (filed.isAnnotationPresent(InjectIntent::class.java)) {
                val intent = filed.getAnnotation(InjectIntent::class.java)
                // 获取注解中传入的value
                val dataName: String = intent.value
                println("dataName: $dataName")
                val typeName = filed.type.simpleName
                println("typeName: $typeName")
                if (!TextUtils.isEmpty(dataName)) {
                    // 设置权限，防止private不能修改
                    filed.isAccessible = true
                    when (typeName) {
                        "int" -> {
                            println("int:" + activity.intent.getIntExtra(dataName, 0))
                            filed[activity] = activity.intent.getIntExtra(dataName, 0)
                        }

                        "String" -> {
                            println("String: " + activity.intent.getStringExtra(dataName))
                            filed[activity] = activity.intent.getStringExtra(dataName)
                        }

                        "boolean" -> {
                            println("boolean: " + activity.intent.getBooleanExtra(dataName, false))
                            filed[activity] = activity.intent.getBooleanExtra(dataName, false)
                        }

                        else -> {}
                    }
                }
            }
        }
    }
}