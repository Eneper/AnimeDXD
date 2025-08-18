package com.example.lab_ux_animedxd;

// SessionManager.java
import android.content.Context;
import android.content.SharedPreferences;

public class Session {

    private static final String PREF_NAME = "AppSession";
    private static final String KEY_USERNAME = "username";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Context context;

    public Session(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    // Metode untuk menyimpan username saat login
    public void saveUsername(String username) {
        editor.putString(KEY_USERNAME, username);
        editor.apply(); // Gunakan apply() untuk menyimpan secara asynchronous
    }

    // Metode untuk mengambil username di halaman mana pun
    public String getUsername() {
        return prefs.getString(KEY_USERNAME, null); // Kembalikan null jika tidak ada
    }

    // Metode untuk menghapus sesi saat logout
    public void clearSession() {
        editor.clear();
        editor.apply();
    }
}
