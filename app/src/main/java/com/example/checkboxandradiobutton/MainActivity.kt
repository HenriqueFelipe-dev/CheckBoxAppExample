package com.example.checkboxandradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var editTextProduto: EditText
    lateinit var radioTipos: RadioGroup
    lateinit var checkBoxLocal: CheckBox
    lateinit var buttonCadastro: Button
    lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextProduto = findViewById(R.id.editTextProduto)
        radioTipos = findViewById(R.id.radioGroupTipo)
        checkBoxLocal = findViewById(R.id.checkBoxLocal)
        buttonCadastro = findViewById(R.id.buttonCadastro)
        textResultado = findViewById(R.id.textViewResultado)

        textResultado.movementMethod = ScrollingMovementMethod()

        buttonCadastro.setOnClickListener {

            if (editTextProduto.text.toString() == ""){
                Toast.makeText(this, "Insira o nome do produto!", Toast.LENGTH_LONG).show()
            }else if (radioTipos.checkedRadioButtonId == -1){
                Toast.makeText(this, "Selecione um tipo!", Toast.LENGTH_LONG).show()
            }else{
                    val nomeProduto = editTextProduto.text.toString()

                    val itemId =  radioTipos.checkedRadioButtonId
                    val checkedRadio = findViewById<RadioButton>(itemId)
                    val itemNome = checkedRadio.text.toString()

                    lateinit var isChecked: String

                    if (checkBoxLocal.isChecked){
                        isChecked = "sim"
                     }else{
                        isChecked = "não"
                     }

                    textResultado.append("""
                    ***Cadastro realizado com sucesso***
                    Produto: $nomeProduto
                    Grupo: $itemNome
                    Este produto $isChecked pode ser consumido no local
                    
                    """.trimIndent())

                }
            }
    }
}