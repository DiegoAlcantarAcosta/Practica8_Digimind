package alcantar.diego.mydigimind

import java.io.Serializable
import java.lang.reflect.Array

data class Recordatorio(var nombre: String, var dias: ArrayList<String>, var tiempo: String) : Serializable
