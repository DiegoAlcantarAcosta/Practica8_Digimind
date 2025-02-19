package alcantar.diego.mydigimind.ui.home

import alcantar.diego.mydigimind.R
import alcantar.diego.mydigimind.Recordatorio
import alcantar.diego.mydigimind.RecordatorioAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var gridView: GridView
    private lateinit var adapter: RecordatorioAdapter
    private val listaRecordatorios = arrayListOf(
        Recordatorio("Everyday", "17:00", "Practice"),
        Recordatorio("Everyday", "17:00", "Practice"),
        Recordatorio("Everyday", "17:00", "Practice"),
        Recordatorio("Everyday", "17:00", "Practice"),
        Recordatorio("Everyday", "17:00", "Practice"),
        Recordatorio("Everyday", "17:00", "Practice"),
        Recordatorio("Everyday", "17:00", "Practice"),
        Recordatorio("Everyday", "17:00", "Practice"),
        Recordatorio("Everyday", "17:00", "Practice")
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        gridView = root.findViewById(R.id.gridView)
        adapter = RecordatorioAdapter(requireContext(), listaRecordatorios)
        gridView.adapter = adapter

        homeViewModel.text.observe(viewLifecycleOwner, {
        })
        return root
    }
}