package test.localhost.pruebas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_IDUSUARIO = "test.localhost.pruebas.EXTRA_IDUSUARIO"

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val actionBar = supportActionBar
        val DNI = intent.extras!!.getInt(EXTRA_DNI)
        val db = DatabaseHelper(this)
        val idDsuarioPorDNI = db.obtenerIdUsuarioPorDNI(DNI)
        val usuarioPorId = db.obtenerDatosUsuarioPorId(idDsuarioPorDNI)
        actionBar!!.title = "Bienvenido, ${usuarioPorId.nombre}"
        val dashboardBotonNuevoTest = findViewById<Button>(R.id.dashboardBotonNuevoTest)
        val dashboardBotonTestsAnteriores = findViewById<Button>(R.id.dashboardBotonTestsAnteriores)
        val dashboardBotonModifUsuario = findViewById<Button>(R.id.dashboardBotonModifUsuario)
        dashboardBotonNuevoTest.setOnClickListener {
            val intentOpciones = Intent(this, OpcionesActivity::class.java)
            intentOpciones.putExtra(EXTRA_IDUSUARIO, idDsuarioPorDNI)
            startActivity(intentOpciones)
        }
        dashboardBotonTestsAnteriores.setOnClickListener {
            val intentTests = Intent(this, TestsActivity::class.java)
            intentTests.putExtra(EXTRA_IDUSUARIO, idDsuarioPorDNI)
            startActivity(intentTests)
        }
        dashboardBotonModifUsuario.setOnClickListener {
            val intentTests = Intent(this, ActualizarUsuarioActivity::class.java)
            intentTests.putExtra(EXTRA_IDUSUARIO, idDsuarioPorDNI)
            startActivity(intentTests)
        }
    }
}