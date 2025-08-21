package com.example.lab_ux_animedxd;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity implements loginFragment.OnLoginSuccessListener, homePage.OnLogoutListener , about.OnLogoutRequestListener, listPage.OnLogoutRequestListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cek status login (disimpan di SharedPreferences atau cara lain)
        // Untuk contoh ini, kita anggap pengguna belum login
        if (savedInstanceState == null) {
            // Jika belum login, tampilkan LoginFragment
            loadFragment(new loginFragment());
        }
    }

    // Metode ini akan dipanggil dari LoginFragment saat login berhasil
    @Override
    public void onLoginSuccess(String username) {
        // Ganti LoginFragment dengan MainStructureFragment
        appNav mainFragment = appNav.newInstance(username);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, mainFragment)
                .commit();
    }

    // Helper method untuk memuat fragment
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, fragment)
                .commit();
    }

    @Override
    public void onLogout() {
        Session sessionManager = new Session(this);
        sessionManager.clearSession();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, new loginFragment())
                .commit();
    }

    public void onLogoutAbout(){

        Session sessionManager = new Session(this);
        sessionManager.clearSession();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, new loginFragment())
                .commit();
    }

    public void onLogoutList(){

        Session sessionManager = new Session(this);
        sessionManager.clearSession();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, new loginFragment())
                .commit();
    }
}