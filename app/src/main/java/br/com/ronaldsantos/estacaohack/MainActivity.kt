package br.com.ronaldsantos.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPrefereces = getSharedPreferences("cadastro", Context.MODE_PRIVATE)

        btnSairActivityMain.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }

        btnSiteCellepActivityMain.setOnClickListener {
            startActivity(Intent(this@MainActivity, WebActivity::class.java))
        }

        txvNomeActiviyMain.text = sharedPrefereces.getString("nome", "Erro String Shared")
        txvEmailActivityMain.text = sharedPrefereces.getString("email", "Erro String Shared")
        txvSexoActivityMain.text = sharedPrefereces.getString("sexo", "Erro String Shared")
    }
}
