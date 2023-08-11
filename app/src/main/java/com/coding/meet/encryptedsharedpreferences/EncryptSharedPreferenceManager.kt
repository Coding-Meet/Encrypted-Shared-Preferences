package com.coding.meet.encryptedsharedpreferences

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class EncryptSharedPreferenceManager(context: Context) {

    private val mainKeyAlies = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val encryptedSharedPreferences = EncryptedSharedPreferences.create(
        "preferences",
        mainKeyAlies,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    private val encryptedEditor = encryptedSharedPreferences.edit()


    private val keyName = "name"
    private val keyAge = "age"

    var name
        get() = encryptedSharedPreferences.getString(keyName,"").toString()
        set(value) {
            encryptedEditor.putString(keyName,value)
            encryptedEditor.commit()
        }

    var age
        get() = encryptedSharedPreferences.getInt(keyAge,0)
        set(value) {
            encryptedEditor.putInt(keyAge,value)
            encryptedEditor.commit()
        }

}