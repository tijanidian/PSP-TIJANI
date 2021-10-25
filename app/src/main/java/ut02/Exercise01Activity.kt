package ut02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.tijani.psp_playground.R
import ut02.exercise1.UserRepository

class Exercise01Activity : AppCompatActivity() {
    private val TAG: String = Exercise01Activity::class.java.simpleName

    private val apiClientFactory: ApiClientFactory = ApiClientFactory()
    //Es lo mismo que en la linea anterior - > private val apiClientFactory = ApiClientFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise01)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_exercise01)
            setupView()
        }

        private fun setupView() {
            val actionMock: Button = findViewById(R.id.action_mock)
            actionMock.setOnClickListener {
                runRepository(it.id)
            }

            val actionApi: Button = findViewById(R.id.action_api)
            actionApi.setOnClickListener {
                runRepository(it.id)
            }
        }

        private fun runRepository(actionId: Int) {
            //obtengo la abstracción del ApiClient a usar
            val userRepository = UserRepository(apiClientFactory.build(actionId))

            //Visualizo el listado de usuarios
            val users = userRepository.getUsers()
            users.forEach { userApiModel ->
                Log.d(TAG, "$userApiModel")
            }

            //Obtengo un usuario y visualizo el usuario
            val user = userRepository.getUser(1)
            user?.run {
                Log.d(TAG, "$this")
            }
    }
}