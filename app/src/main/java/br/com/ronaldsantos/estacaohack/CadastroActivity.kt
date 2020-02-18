package br.com.ronaldsantos.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val listaSexo = arrayListOf(
            "Selecione o sexo",
            "Feminino",
            "Masculino",
            "Outros"
        )

        val sexoAdapter = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )

        spnSexoCadastro.adapter = sexoAdapter

        btnCadastrarActivityLogin.setOnClickListener {
            cadastrar()
        }
    }

    private fun cadastrar(){
        val nome = edtNomeCadastro.text.toString().trim()
        val sobrenome = edtSobrenomeCadastro.text.toString().trim()
        val email = edtEmailCadastro.text.toString().trim().toLowerCase()
        val senha = edtSenhaCadastro.text.toString().trim()
        val sexo = spnSexoCadastro.selectedItem.toString()

        if (nome.isEmpty() ||
            sobrenome.isEmpty() ||
            email.isEmpty() ||
            senha.isEmpty() ||
                sexo == "Selecione o sexo"){
            AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Por favor preecnha todos os campos")
                .setPositiveButton("Ok"){_,_ ->
                    //ação do botão ok
                }
                .setCancelable(true)
                .create()
                .show()
        } else {
            val sharedPreference = getSharedPreferences("cadastro", Context.MODE_PRIVATE)
            val base = sharedPreference.edit()

            base.putString("nome", nome).apply()
            base.putString("sobrenome", sobrenome).apply()
            base.putString("email", email).apply()
            base.putString("senha", senha).apply()
            base.putString("sexo", sexo).apply()

            startActivity(Intent(this@CadastroActivity, MainActivity::class.java))
            finish()
        }
    }

}
