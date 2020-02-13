package br.com.ronaldsantos.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrarActivityLogin.setOnClickListener {
            val usuario = edtUsuarioActivityLogin.text.toString().trim()
            val senha = edtSenhaActivityLogin.text.toString().trim()

            if (usuario.isEmpty()) {
                edtUsuarioActivityLogin.error = "Por favor preenche o nome do usuário"
            } else if (senha.isEmpty()) {
                edtSenhaActivityLogin.error = "Por favor preencha sua senha"
            } else if ((usuario == "ADM") && (senha == "123")){
                Toast.makeText(this@LoginActivity,
                    "Usuário logado",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@LoginActivity,
                    "Usuário ou senha inválido",
                    Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
