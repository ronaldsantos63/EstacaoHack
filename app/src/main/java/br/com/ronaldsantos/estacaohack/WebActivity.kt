package br.com.ronaldsantos.estacaohack

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        wbvWeb.settings.javaScriptEnabled = true
        wbvWeb.loadUrl("https://br.cellep.com/estacaohack")
    }
}
