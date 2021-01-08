package com.aula.agenda

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contato.*
import java.text.SimpleDateFormat
import java.util.*

class ContatoActivity : AppCompatActivity() {

    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)

        setSupportActionBar(toolbar_child)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        txtDatanascimento.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@ContatoActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        btnCadastro.setOnClickListener{
            var dados = "[${txtNome.text} : ${txtEmail.text} : ${txtEndereco.text} : ${txtTelefone.text} : ${txtSite.text} : ${txtDatanascimento.text}}]"
            Toast.makeText(this, dados, Toast.LENGTH_LONG).show()
        }
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy : HH:mm:ss" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        txtDatanascimento.text = sdf.format(cal.getTime())
    }



}
