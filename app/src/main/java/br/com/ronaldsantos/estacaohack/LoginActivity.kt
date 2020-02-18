package br.com.ronaldsantos.estacaohack

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("cadastro", Context.MODE_PRIVATE)

        btnCadastrarActivityLogin.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }

        btnEntrarActivityLogin.setOnClickListener {
            fazerLogin()
        }
    }

    private fun fazerLogin(){
        val usuario = edtUsuarioActivityLogin.text.toString().trim()
        val senha = edtSenhaActivityLogin.text.toString().trim()

        val senhaBanco = sharedPreferences.getString("senha", "")
        val usuarioBanco = sharedPreferences.getString("email", "")

        if (usuario.isEmpty()) {
            edtUsuarioActivityLogin.error = "Por favor preenche o nome do usuário"
        } else if (senha.isEmpty()) {
            edtSenhaActivityLogin.error = "Por favor preencha sua senha"
        } else if ((usuario == usuarioBanco) && (senha == senhaBanco)){
            Toast.makeText(this@LoginActivity,
                "Usuário logado",
                Toast.LENGTH_LONG).show()
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this@LoginActivity,
                "Usuário ou senha inválido",
                Toast.LENGTH_LONG)
                .show()
        }
    }
}
