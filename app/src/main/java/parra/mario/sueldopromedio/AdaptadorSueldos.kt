package parra.mario.sueldopromedio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

class AdaptadorSueldos: BaseAdapter {
    lateinit var context: Context
    var sueldos: ArrayList<Sueldo> = ArrayList()

    constructor(context: Context, sueldos: ArrayList<Sueldo>){
        this.context = context
        this.sueldos = sueldos
    }

    override fun getCount(): Int {
        return sueldos.size
    }

    override fun getItem(p0: Int): Any {
        return sueldos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflador = LayoutInflater.from(context)
        val vista = inflador.inflate(R.layout.sueldo_view, null)

        var sueldo = sueldos[p0]

        val tv_diario: TextView = vista.findViewById(R.id.tv_diario_ind)
        val tv_mes_ind: TextView = vista.findViewById(R.id.tv_meses_ind)

        tv_diario.setText("$${sueldo.sueldo}")
        tv_mes_ind.setText("${sueldo.meses}")

        return vista
    }


}