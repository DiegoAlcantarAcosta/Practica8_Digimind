package alcantar.diego.mydigimind.ui.dashboard

import alcantar.diego.mydigimind.R
import alcantar.diego.mydigimind.Recordatorio
import alcantar.diego.mydigimind.ui.home.HomeFragment
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.Calendar

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val btn_time: Button = root.findViewById(R.id.btn_time)

        btn_time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                btn_time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                root.context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true
            ).show()

        }

        val btn_save: Button = root.findViewById(R.id.btn_save)
        val et_titulo: EditText = root.findViewById(R.id.et_task)
        val checkMonday: CheckBox = root.findViewById(R.id.checkMonday)
        val checkTuesday: CheckBox = root.findViewById(R.id.checkTuesday)
        val checkWednesday: CheckBox = root.findViewById(R.id.checkWednesday)
        val checkThursday: CheckBox = root.findViewById(R.id.checkThursday)
        val checkFriday: CheckBox = root.findViewById(R.id.checkFriday)
        val checkSaturday: CheckBox = root.findViewById(R.id.checkSaturday)
        val checkSunday: CheckBox = root.findViewById(R.id.checkSunday)

        btn_save.setOnClickListener {
            val titulo = et_titulo.text.toString()
            val time = btn_time.text.toString()
            val days = ArrayList<String>()

            if (checkMonday.isChecked && checkTuesday.isChecked
                && checkWednesday.isChecked && checkThursday.isChecked
                && checkFriday.isChecked && checkSaturday.isChecked
                && checkSunday.isChecked
            ) {
                days.add("Everyday")
            } else {
                if (checkMonday.isChecked)
                    days.add("Monday")
                if (checkTuesday.isChecked)
                    days.add("Tuesday")
                if (checkWednesday.isChecked)
                    days.add("Wednesday")
                if (checkThursday.isChecked)
                    days.add("Thursday")
                if (checkFriday.isChecked)
                    days.add("Friday")
                if (checkSaturday.isChecked)
                    days.add("Saturday")
                if (checkSunday.isChecked)
                    days.add("Sunday")
            }
            val task = Recordatorio(titulo, days, time)

            HomeFragment.tasks.add(task)

            Toast.makeText(root.context, "New task added!!", Toast.LENGTH_SHORT).show()
        }

        return root
    }
}