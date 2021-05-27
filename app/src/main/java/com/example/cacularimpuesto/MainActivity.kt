package com.example.cacularimpuesto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calcular_datos.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Enviar(view: View) {

        //Creamos dos variables que almacenaran los datos ingresados en los edit text
        var name : String = etName.text.toString()
        var dinero : String = etIngresar.text.toString()

        //Si el usuario no rellena ninguno de los espacios entonces mostramos ambos errores a la vez
        //Para que se vea mejor esteticamente
        if ("".equals(name) && "".equals(dinero)){
            etName.setError("Introduzca su nombre")
            etName.requestFocus()
            etIngresar.setError("introduzca su sueldo")
            etIngresar.requestFocus()
            return
        }

        //Verificamos si el usuario agregó su nombre
        if ("".equals(name)){
            etName.setError("Introduzca su nombre")
            etName.requestFocus()
            return
        }

        //Verificamos si el usuario agregó su sueldo

        if ("".equals(dinero)){
            etIngresar.setError("introduzca su sueldo")
            etIngresar.requestFocus()
            return
        }

        //Creamos la variabke intent y que esta sea no modificable
        val intent = Intent(this@MainActivity, calcularDatos::class.java)

        //Creamos la variable con el dato a enviar
        var sueldo :String = etIngresar.text.toString()
        var nombre :String = etName.text.toString()

        //Creamos b como Bundle
        val b :Bundle = Bundle()
        val b2 :Bundle = Bundle()

        //Le agregamos la variable con el dato a enviar
        b.putString("dt", sueldo)
        b2.putString("nm", nombre )

        //Agregamos al intent el dato
        intent.putExtras(b)
        intent.putExtras(b2)

        //Por último ejecutamos el intent
        startActivity(intent)

    }
}