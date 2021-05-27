package com.example.cacularimpuesto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calcular_datos.*

class calcularDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_datos)

        val bundle = intent.extras

        //Recibimos los datos tanto del nombre como el sueldo
        tvMostrar.text = bundle?.getString("dt")
        tvNombre.text = bundle?.getString("nm")

        //Ingresamos en una variable el dato enviado para poder operar con él
        var sueldoSend:String = tvMostrar.text.toString()

        //Ingresamos en una variable el dato enviado para poder agregar un mensaje con él
        var nameSend:String = tvNombre.text.toString()

        //Agregamos la variable del nombre junto con un saludo
        tvNombre.setText("¡Hola $nameSend!")

        //Transformamos en Double el dato para poder multiplicar
        val impuesto:Double = sueldoSend.toDouble()

        //Estructura If para verificar la cantidad de dinero que gana y aplicarle el respectivo Impuesto
        if(impuesto>0.01 && impuesto<487.61){

            tvImpuesto.setText("Sin retención")

        }else if (impuesto>487.60 && impuesto<642.86){

            val impuestoCal:Double = impuesto*0.1
            tvImpuesto.setText("$impuestoCal")

        } else if (impuesto>642.85 && impuesto<915.82){

            val impuestoCal:Double = impuesto*0.1
            tvImpuesto.setText("$impuestoCal")

        } else if (impuesto>915.81 && impuesto<2058.68){

            val impuestoCal:Double = impuesto*0.2
            tvImpuesto.setText("$impuestoCal")

        } else if (impuesto>2058.67){

            val impuestoCal:Double = impuesto*0.3
            tvImpuesto.setText("$impuestoCal")

        }





    }

    //Agregamos la funcion del boton para regresar al MainActivity
    fun Volver(view: View) {

        intent = Intent(this@calcularDatos,MainActivity::class.java)
        startActivity(intent)

    }
}