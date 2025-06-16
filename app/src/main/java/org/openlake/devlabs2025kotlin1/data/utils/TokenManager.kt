package org.openlake.devlabs2025kotlin1.data.utils
// Now, let's create a SharedPreferences manager to store the token

// SessionManager.kt
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class TokenManager(context: Context) {
    private val sharedPreferences: SharedPreferences = 
        context.getSharedPreferences("TaskifyPrefs", Context.MODE_PRIVATE)
    
    companion object {
        private const val KEY_TOKEN = "key_token"
    }
    
    fun saveToken(token: String) {
        sharedPreferences.edit { putString(KEY_TOKEN, token) }
    }
    
    fun getToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }
    
    fun clearToken() {
        sharedPreferences.edit { remove(KEY_TOKEN) }
    }
    
    fun isLoggedIn(): Boolean {
        return getToken() != null
    }
}