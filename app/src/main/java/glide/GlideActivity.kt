package glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tijani.psp_playground.R

class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        loadImage()
    }


    private fun loadImage() {
        val url = "https://plagas.itacyl.es/documents/109511/303314/ZABRO.+ADULTO.jpg"

        val imageView=findViewById<ImageView>(R.id.logo_png)
        //Función extensión
        //imageView.fromUrl(url)
    }
}