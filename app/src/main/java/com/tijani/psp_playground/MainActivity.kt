package com.tijani.psp_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //var es mutable, val inmutable (si o si hay que inicializarla)
    lateinit var label: TextView
    lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Método para la vista
        setupView()

    }

    private fun setupView() {
        label = findViewById(R.id.label)
        button = findViewById(R.id.button)

        //añadimos evento
        button.setOnClickListener {
            //launchARN()
            //withThread()
            //withThreadAndPost()
            //withThreadAndPost()
            //threadFromParam()
            //launcMultipleThread()
            launchInsideThread()
        }
    }

    private fun launchARN() {
        //Bucle for donde mostramos hola + i 99 veces
        for (i in 1..100) {
            label.text = "Hola $i"

            Thread.sleep(2000)
        }
    }

    //Crear un hilo, que no es ejecutado por el hilo de la UI
    private fun withThread() {
        //objeto
        Thread(Runnable {

            for (i in 1..100) {
                label.text = "Hola $i"
                Thread.sleep(2000)
            }

        }).start()
    }

    private fun withThreadAndPost() {
        Thread(Runnable {

            for (i in 1..100) {
                //la vista tiene un método  post para permitir pintar en la UI
                label.post {
                    label.text = "Hola $i"
                }
                Thread.sleep(2000)
            }

        }).start()

    }

    private fun withRunUiThread() {
        Thread(Runnable {

            for (i in 1..100) {
                runOnUiThread {
                    label.text = "Hola $i"
                }

                Thread.sleep(2000)
            }

        }).start()

    }

    //Crear hilo con variable
    private fun threadFromParam() {

        val thread = Thread(Runnable {
            for (i in 1..100) {
                runOnUiThread {
                    label.text = "Hola $i"
                }
                Thread.sleep(2000)
            }
        })

        thread.start()
    }

    //Creamos varios hilos que se ejecutan al mismo tiempo
    private fun launcMultipleThread() {

        val thread1 = Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "thread1")
                Thread.sleep(1000)
            }
        })

        val thread2 = Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "thread2")
                Thread.sleep(1500)
            }
        })

        val thread3 = Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "thread3")
                Thread.sleep(2000)
            }
        })

        thread1.start()
        thread2.start()
        thread3.start()
    }

    //Ejecutamos un hilo y dentro de ese hilo otro hilo

    private fun launchInsideThread() {

        Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "thread1 $i")
                Thread.sleep(1500)
            }
        }).start()

        Thread(Runnable {
            for (i in 1..100) {
                Log.d("@dev", "thread2 $i")
                Thread.sleep(1500)
            }
        }).start()

    }


}