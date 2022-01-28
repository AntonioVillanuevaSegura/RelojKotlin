# RelojKotlin
Un reloj sencillo en KOTLIN y Android Studio .La idea principal es de realizar tareas periodicas , en este caso actualizamos un textView cada segundo 
mostrando el funcionamiento de un reloj digital HH:MM:SS


El tiempo se formatea por String.format ("%02d:%02d:%02d", HH, MM, SS); donde HH MM SS son Int

Detalles clave de implementacion 

    //Se repite ciclicamente cada segundo
    private val reloj = object : Runnable {
        override fun run() {
            segundos()
            mainHandler.postDelayed(this, 1000)//Cada Segundo 1000 ms
        }
    }
....
 lateinit var mainHandler: Handler
 ...
 mainHandler= Handler(Looper.getMainLooper())
 ...
  override fun onPause() 
  ..
  override fun onResume() 
