package com.example.openwindowstest

//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.openwindowstest.ui.theme.OpenWindowsTestTheme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Status", "onCreate")

        val urlBaseDev = "https://itausegurosqafront.alwayson.cl/"
        val urlBaseStage = "https://serviciositaucompra.alwayson.cl/"
        val urlDetalle = "detalle-seguro/"
        val urlParam = "?param1="
        val urlBaseTokenizada = urlBaseDev.plus(urlParam).plus((0..10000000).random())
        val urlTp = urlBaseDev.plus(urlDetalle).plus(35).plus(urlParam).plus((0..1000000).random())
        val urlVmP = urlBaseStage.plus(urlDetalle).plus(39).plus(urlParam).plus((0..1000000).random()).plus("&source=APPITAU&param2=MQ==")

        createButton(R.id.open_browser_buttonTp, urlTp)
        Log.d("Status", urlTp)
        createButton(R.id.open_browser_buttonVmP, urlVmP)
        Log.d("Status", urlVmP)
        createButton(R.id.open_browser_button, urlBaseTokenizada)
        Log.d("Status", urlBaseTokenizada)
    }

    private fun createButton(buttonId: Int, urlTokenizada: String) {
        val openBrowserButton: Button = findViewById(buttonId)

        openBrowserButton.setOnClickListener {
            openBrowser(urlTokenizada) // Replace with your desired URL
        }
    }

    private fun openBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    OpenWindowsTestTheme {
//        Greeting("Android")
//    }
//}