package alcantar.diego.mydigimind.ui.home

import alcantar.diego.mydigimind.R
import alcantar.diego.mydigimind.Recordatorio
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class HomeFragment : Fragment() {

    private var adaptador: AdaptadorRecordatorios? = null
    private lateinit var homeViewModel: HomeViewModel

    companion object {
        var tasks = ArrayList<Recordatorio>()
        var first = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        if (first) {
            fillTasks()
            first = false
        }


        Toast.makeText(root.context, tasks[0].toString(), Toast.LENGTH_LONG).show()
        val gridView: GridView = root.findViewById(R.id.gridView)

        adaptador = AdaptadorRecordatorios(root.context, tasks)
        gridView.adapter = adaptador


        return root
    }

    fun fillTasks() {
        tasks.add(Recordatorio("Practice 1", arrayListOf("Tuesday"), "17:30"))
        tasks.add(Recordatorio("Practice 2", arrayListOf("Monday", "Sunday"), "17:40"))
        tasks.add(Recordatorio("Practice 3", arrayListOf("Wednesday"), "14:00"))
        tasks.add(Recordatorio("Practice 4", arrayListOf("Saturday"), "11:00"))
        tasks.add(Recordatorio("Practice 5", arrayListOf("Friday"), "13:00"))
        tasks.add(Recordatorio("Practice 6", arrayListOf("Thursday"), "10:40"))
        tasks.add(Recordatorio("Practice 7", arrayListOf("Monday"), "12:00"))

    }

    private class AdaptadorRecordatorios(context: Context, var tasks: ArrayList<Recordatorio>) :
        BaseAdapter() {
        var contexto: Context? = context

        override fun getCount(): Int {
            return tasks.size
        }

        override fun getItem(p0: Int): Any {
            return tasks[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val task = tasks[p0]
            val inflador = LayoutInflater.from(contexto)
            val vista = inflador.inflate(R.layout.recordatorio, null)

            val titulo: TextView = vista.findViewById(R.id.txtNombreRecordatorio)
            val tiempo: TextView = vista.findViewById(R.id.txtTiempoRecordatorio)
            val dias: TextView = vista.findViewById(R.id.txtDiasRecordatorio)

            titulo.text = task.nombre
            tiempo.text = task.tiempo
            dias.text = task.dias.toString()

            return vista
        }
    }
}