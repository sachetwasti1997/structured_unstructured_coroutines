package com.sachet.unstrcturednstructuredcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var btnDnld: Button
    private lateinit var btnIncr: Button
    private lateinit var downloadViewer: TextView
    private lateinit var countViewer: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDnld = findViewById(R.id.download_btn)
        btnIncr = findViewById(R.id.button_increment)
        downloadViewer = findViewById(R.id.download_viewer)
        countViewer = findViewById(R.id.count_view)

        btnDnld.setOnClickListener {
            CoroutineScope(Main).launch {
//                downloadViewer.text = UserDataManager().getTotalUserCount().toString() //got 70 as answer
                downloadViewer.text = UserDataManger2().getTotalUserCount().toString()
            }
        }
    }
}