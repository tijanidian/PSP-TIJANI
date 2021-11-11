package ut03.ex01.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tijani.psp_playground.R

class Ut03Ex01Activity : AppCompatActivity() {
    private val viewModel =Ut03Ex01ViewModel()
    private lateinit var thread1:Thread
    private val TAG=Ut03Ex01Activity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex01)
        //exampleThread()
        exampleCoroutines()
    }

    private  fun exampleThread(){
        thread1=Thread (Runnable{
            var i=0
            while (true){
                Log.d(TAG,"hola: $i")
                Thread.sleep(1000)
                i+=1
            }
        })
        thread1.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(this::thread1.isInitialized){
            thread1.interrupt()
        }
    }

    private fun exampleCoroutines(){
        viewModel.getUsersGlobalScope()
    }
}