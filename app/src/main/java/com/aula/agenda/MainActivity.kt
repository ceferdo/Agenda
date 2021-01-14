package com.aula.agenda

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aula.constants.APP_NAME
import com.aula.db.Contato
import com.aula.db.ContatoRepository
import kotlinx.android.synthetic.main.activity_contato.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var contatos: ArrayList<Contato>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

        lista.setOnItemClickListener { _, _, position, id ->
            Log.i(APP_NAME, "position: $position id: " + contatos?.get(id.toInt())?.id)
            val intent = Intent(this@MainActivity, ContatoActivity::class.java)
            intent.putExtra("contato", contatos?.get(position))
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.novo -> {
                val intent = Intent(this, ContatoActivity::class.java)
                startActivity(intent)
                return false
            }

            R.id.sincronizar -> {
                Toast.makeText(this, "Enviar", Toast.LENGTH_LONG).show()
                return false
            }

            R.id.receber -> {
                Toast.makeText(this, "Receber", Toast.LENGTH_LONG).show()
                return false
            }

            R.id.mapa -> {
                Toast.makeText(this, "Mapa", Toast.LENGTH_LONG).show()
                return false
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        contatos = ContatoRepository(this).findAll()
        if(contatos != null){
            lista.adapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, contatos!!
            )
        }

//        val contato = intent?.getSerializableExtra("contato")
//        if(contato != null){
//            contato as Contato
//            txtNome.setText(contato?.nome)
//            txtEndereco.setText(contato?.nome)
//            txtTelefone.setText(contato?.nome)
//            txtSite.setText(contato?.nome)
//            txtEmail.setText(contato?.nome)
//        }

    }
}