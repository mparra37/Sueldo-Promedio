package parra.mario.sueldopromedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AgregarSueldo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_sueldo)

        val btn_agregar_diario: Button = findViewById(R.id.btn_agregar_diario)
        val btn_cancelar: Button = findViewById(R.id.btn_cancelar_diario)
        val et_sueldo: EditText = findViewById(R.id.et_sueldo)
        val et_meses: EditText = findViewById(R.id.et_meses)

        btn_agregar_diario.setOnClickListener{
            var sueldo_diario: Double? = et_sueldo.text.toString().toDoubleOrNull()
            var meses: Double? = et_meses.text.toString().toDoubleOrNull()

            if(sueldo_diario == null || meses == null){
                Toast.makeText(this,"Llenar los datos", Toast.LENGTH_SHORT).show()
            }else{
                var sueldo = Sueldo(sueldo_diario, meses)

                MainActivity.sueldos.add(sueldo)

                MainActivity.adaptador?.notifyDataSetChanged()

                finish()

            }


        }

        btn_cancelar.setOnClickListener{
            finish()
        }
    }
}