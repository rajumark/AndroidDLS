# AndroidDSL

## [AdapterLite.kt ⬇️](https://github.com/rajumark/AndroidDLS/blob/main/AdapterLite.kt)
replace **adapter** to **adapterLite** 


```kotlin
    recyclerview.adapterLite(ItemUsersBinding::class.java,list,{ mBinding, name, i ->
                mBinding.textviewName.text=name
            })
```
**must use**
```kotlin 
 buildFeatures {
        viewBinding = true
    }
```



## [RootUtil.kt ⬇️](https://github.com/rajumark/AndroidDLS/blob/main/RootUtil.kt)
check is android device **rooted** ?


```kotlin
    var isrooted=RootUtil.isDeviceRooted
```


## [UserDefault.kt ⬇️](https://github.com/rajumark/AndroidDLS/blob/main/UserDefault.kt)
* *shared preferences now more handy ways (less code less worry)* *
 
#### Application Class
 ```kotlin 
        UserDefault.context=this
 ``` 

#### How to use this ?
 create object class and create varible
```kotlin 
     object UDConst {
         var userid by UserDefault(String::class.java)
     }
 ``` 
#### Call Site
```kotlin 
      set value->  UDConst.userid = "android"
      get value->  UDConst.userid
 ``` 

======================================
* *More DSL coming soon... keep in touch❤️* *


buildFeatures {
        viewBinding true
    }
#line

// activity and lifecyclelifecycle
    implementation 'androidx.activity:activity-ktx:1.5.1'
    implementation 'androidx.fragment:fragment-ktx:1.5.2'
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
    implementation 'androidx.lifecycle:lifecycle-common-java8:2.5.1'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.1'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    
    
   
   
   buildscript {
    dependencies {
        classpath "com.google.dagger:hilt-android-gradle-plugin:2.40.5"
    }
   }
   
     id 'org.jetbrains.kotlin.android' version '1.6.10' apply false
   
   //plugin
    id 'dagger.hilt.android.plugin'
    id 'kotlin-kapt'
   
   //Dagger - Hilt
    implementation "com.google.dagger:hilt-android:2.40.5"
    kapt "com.google.dagger:hilt-android-compiler:2.40.5"
    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    kapt "androidx.hilt:hilt-compiler:1.0.0"
    
    
    
     //network
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'com.squareup.okhttp3:okhttp:4.10.0'
    

