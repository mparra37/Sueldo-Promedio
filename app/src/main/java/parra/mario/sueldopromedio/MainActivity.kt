package parra.mario.sueldopromedio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tv_prom: TextView
    lateinit var tv_meses: TextView

    companion object{
        var sueldos: ArrayList<Sueldo> = ArrayList()
        var adaptador: AdaptadorSueldos? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sueldos_prueba()

        val listview: ListView = findViewById(R.id.listview)
        val btn_agregar: Button = findViewById(R.id.btn_agregar)
        val btn_borrar: Button = findViewById(R.id.btn_borrar)
        tv_prom = findViewById(R.id.tv_prom)
        tv_meses = findViewById(R.id.tv_meses)

        adaptador = AdaptadorSueldos(this, sueldos)



        listview.adapter = adaptador

        btn_agregar.setOnClickListener{
            val intent = Intent(this, AgregarSueldo::class.java)

            startActivity(intent)

        }

        btn_borrar.setOnClickListener{
            sueldos.clear()
            adaptador?.notifyDataSetChanged()
            obtener_promedio()
        }


    }

//    fun sueldos_prueba(){
//        sueldos.add(Sueldo(900.0, 35.0))
//        sueldos.add(Sueldo(2240.0, 23.0))
//        sueldos.add(Sueldo(207.0, 2.0))
//
//    }

    override fun onResume() {
        super.onResume()

        obtener_promedio()
    }

    fun obtener_promedio(){
        var promedio: Double = 0.0
        var suma_meses: Double = 0.0



        if(sueldos.size > 0){

            for(sueldo in sueldos){
                suma_meses += sueldo.meses
                promedio += sueldo.sueldo * sueldo.meses
            }

            promedio = promedio/suma_meses

        }
        val rounded = String.format("%.2f", promedio)

        tv_prom.setText("$$rounded")
        tv_meses.setText("$suma_meses")

    }
}