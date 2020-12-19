package com.aula.agenda

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contatos = arrayOf("Maria", "José", "Carlos")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contatos)

        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

        var listaContatos = lista
        listaContatos.setAdapter(adapter);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }


}
