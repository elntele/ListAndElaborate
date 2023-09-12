package br.com.candeias.listandelaborate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import br.com.candeias.listandelaborate.databinding.ActivityMainBinding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController:NavController
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navFragment= supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navFragment.navController
        auth = Firebase.auth
    }


    override fun onStart() {
        super.onStart()
        val currentUser= auth?.currentUser
        if (currentUser != null) {
            navController?.setGraph(R.navigation.feature_login)
        }else{
            navController?.setGraph(R.navigation.feature_login)
        }
    }
}