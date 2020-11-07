package com.example.revisao26102020_1

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout


class MaskWatcher(private var editText: EditText, private var mask: String) : TextWatcher {

    var isUpdating: Boolean = false
    var old = ""

    override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
        Log.i("TextWatcher - Before", charSequence.toString())
    }

    override fun afterTextChanged(editable: Editable) {
        Log.i("TextWatcher - After", editable.toString())

    }

    override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
        Log.i("TextWatcher - On", charSequence.toString())

        val string = charSequence.toString().unmask()
        var mask = ""
        if (isUpdating) {
            old = string
            isUpdating = false
            return
        }
        var index = 0
        for (item in this.mask.toCharArray()) {
            if (item != '#' && string.length > old.length) {
                mask += item
                continue
            }
            try {
                mask += string[index]
            } catch (exception: Exception) {
                break
            }

            index++
        }

        isUpdating = true
        editText.setText(mask)
        editText.setSelection(mask.length)
    }

//    public class CreditCardUtils {
//        val VISA_PREFIX = "4"
//        val MASTERCARD_PREFIX = "51,52,53,54,55,"
//        val DISCOVER_PREFIX = "6011"
//        val AMEX_PREFIX = "34,37,"
//        val VISA = 1
//        val MASTERCARD = 2
//        val AMEX = 3
//        val DISCOVER = 4
//        val NONE = 0
//
//        public fun getCardType(cardNumber: String): Int {
//
//            if (cardNumber.substring(0, 1).equals(VISA_PREFIX))
//                return VISA;
//            else if (MASTERCARD_PREFIX.contains(cardNumber.substring(0, 2) + ","))
//                return MASTERCARD;
//            else if (AMEX_PREFIX.contains(cardNumber.substring(0, 2) + ","))
//                return AMEX;
//            else if (cardNumber.substring(0, 4).equals(DISCOVER_PREFIX))
//                return DISCOVER;
//
//            return NONE;
//        }
//    }
}


