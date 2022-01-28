package com.example.testtareaperiodica
/*
https://guides.codepath.com/android/Repeating-Periodic-Tasks
https://stackoverflow.com/questions/32571878/simulate-blinking-of-a-button-android
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.testtareaperiodica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var HH=0 //horas
    var MM= 0 //Minutos
    var SS=0 //Segundos


    //Se repite ciclicamente cada segundo
    private val reloj = object : Runnable {
        override fun run() {
            segundos()
            mainHandler.postDelayed(this, 1000)//Cada Segundo 1000 ms
        }
    }

    lateinit var mainHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        //Llama al Loop
        mainHandler= Handler(Looper.getMainLooper())

    }

    override fun onPause() {
        super.onPause()
        mainHandler.removeCallbacks(reloj)
    }

    override fun onResume() {
        super.onResume()
        mainHandler.post(reloj)
    }

    //Formate HORAS : MINUTOS : SEGUNDOS a un String tipo HH:MM:SS
    fun formatTime(HH:Int,MM:Int,SS:Int):String {
        return String.format ("%02d:%02d:%02d", HH, MM, SS);
    }

    //Actualiza el paso del tiempo HH:MM:SS cada segundo
    fun segundos() {

        if (SS<59){SS++} //Segundos
        else{
            SS=0

            if (MM<59){MM++} //Minutos
            else {
                MM=0

                if (HH<23){HH++} //Horas
                else {HH=0}

            }
        }

        //Muestra resultado en TextView tiempo
        binding.tiempo.setText(formatTime(HH,MM,SS))

    }




}