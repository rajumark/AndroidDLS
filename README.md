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

