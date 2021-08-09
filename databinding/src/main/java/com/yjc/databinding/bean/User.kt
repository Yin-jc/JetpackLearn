package com.yjc.databinding.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.yjc.databinding.BR

/**
 * author: yinjiacheng
 * date: 7/20/21 9:31 AM
 * description:
 */
class User : BaseObservable() {

    @get:Bindable
    var firstName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }

    @get: Bindable
    var isCheck: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.check)
        }

}
