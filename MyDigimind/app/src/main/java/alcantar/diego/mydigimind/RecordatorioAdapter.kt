package alcantar.diego.mydigimind

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class RecordatorioAdapter(private val context: Context, private val recordatorios: ArrayList<Recordatorio>) : BaseAdapter() {

    override fun getCount(): Int {
        return recordatorios.size
    }

    override fun getItem(position: Int): Any {
        return recordatorios[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val inflater = LayoutInflater.from(context)

        if (convertView == null) {
            view = inflater.inflate(R.layout.recordatorio, parent, false)
        } else {
            view = convertView
        }

        val recordatorio = recordatorios[position]

        view.findViewById<TextView>(R.id.txtNombreRecordatorio).text = recordatorio.nombre
        view.findViewById<TextView>(R.id.txtTiempoRecordatorio).text = recordatorio.tiempo
        view.findViewById<TextView>(R.id.txtDiasRecordatorio).text = recordatorio.dias

        return view
    }
}
