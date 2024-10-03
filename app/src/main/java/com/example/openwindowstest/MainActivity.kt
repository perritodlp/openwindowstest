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

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.renderscript.Sampler.Value
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.io.InputStream
import java.util.Properties


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Status", "onCreate")

        // Load properties
        val properties = loadProperties(this)

        val urlBaseDev = properties.getProperty("app.dev.url")
        val urlBaseStage = properties.getProperty("app.stage.url")
        val urlBaseProd = properties.getProperty("app.prod.url")
        var tokens = properties.getProperty("app.tokens").split(',')
        //println("Token: $tokens")
        //println(tokens[(0..tokens.size).random()])
        //val tokens = arrayOf("3ca59228-0e53-4258-b589-2e36dcd37577","29ca9aae-b75a-427b-826d-648eda34223f","f176331a-a71e-407e-8cda-a38966ad02df","11682fa7-9be9-4b18-af0f-fb190da97af3")
        val urlDetalle = properties.getProperty("app.detalle.url")
        val urlParam = properties.getProperty("app.param.url")
        val urlBaseTokenizada = urlBaseStage.plus(urlParam).plus((0..10000000).random())
        val urlTp = urlBaseStage.plus(urlDetalle).plus(35).plus(urlParam).plus((0..1000000).random())
        val urlVmP = urlBaseStage.plus(urlDetalle).plus(39).plus(urlParam).plus((0..1000000).random()).plus("&source=APPITAU&param2=MQ==")
        val urlPosventa = urlBaseStage.plus("aftersales").plus(urlParam).plus((0..1000000).random()).plus("&source=APPITAU")
        val urlPosventaProd = urlBaseProd.plus("aftersales").plus(urlParam).plus(tokens[(0..tokens.size).random()]).plus("&source=APPITAU")

        createButton(R.id.open_browser_buttonTp, urlTp)
        Log.d("Status", urlTp)
        createButton(R.id.open_browser_buttonVmP, urlVmP)
        Log.d("Status", urlVmP)
        createButton(R.id.open_browser_button, urlBaseTokenizada)
        Log.d("Status", urlBaseTokenizada)
        createButton(R.id.open_browser_buttonPosventa, urlPosventa)
        Log.d("Status", urlPosventa)
        createButton(R.id.open_browser_buttonPosventaProd, urlPosventaProd)
        Log.d("Status", urlPosventaProd)
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

    private fun loadProperties(context: Context): Properties {
        val properties = Properties()
        try {
            val inputStream: InputStream = context.assets.open("config.properties")
            properties.load(inputStream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return properties
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