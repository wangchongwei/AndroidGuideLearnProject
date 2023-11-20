package com.example.mvx.mvx.android.guide.learn.project.annotation;

import android.app.Activity;
import android.text.TextUtils;

import java.lang.reflect.Field;

public class InjectData {

    public static void inject(Activity activity) throws IllegalAccessException {
        Class<? extends Activity> cls = activity.getClass();
        // 获取Activity中所有的成员属性
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field filed: declaredFields) {
            // 判断是否该成员属性是否有 @InjectIntent 注解
            if (filed.isAnnotationPresent(InjectIntent.class)) {
                InjectIntent intent = filed.getAnnotation(InjectIntent.class);
                // 获取注解中传入的value
                String dataName = intent.value();
                System.out.println("dataName: " + dataName);
                String typeName = filed.getType().getSimpleName();
                System.out.println("typeName: " + typeName);
                if (!TextUtils.isEmpty(dataName)) {
                    // 设置权限，防止private不能修改
                    filed.setAccessible(true);
                    switch (typeName) {

                        case "int":
                            System.out.println("int:" + activity.getIntent().getIntExtra(dataName, 0));
                            filed.set(activity, activity.getIntent().getIntExtra(dataName, 0));
                            break;

                        case "String":
                            System.out.println("String: " + activity.getIntent().getStringExtra(dataName));
                            filed.set(activity, activity.getIntent().getStringExtra(dataName));
                            break;

                        case "boolean":
                            System.out.println("boolean: " + activity.getIntent().getBooleanExtra(dataName, false));
                            filed.set(activity, activity.getIntent().getBooleanExtra(dataName, false));
                            break;

                        default:
                            break;
                    }
                }
            }
        }
    }
}
