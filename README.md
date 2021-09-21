# AndroidDLS

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

