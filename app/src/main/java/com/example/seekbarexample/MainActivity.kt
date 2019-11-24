package com.example.seekbarexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    var position1:Int = 255 // 紅
    var position2:Int = 255 // 綠
    var position3:Int = 255 // 藍
    // 宣告元件
    lateinit var background:ConstraintLayout
    lateinit var seek_red:SeekBar
    lateinit var seek_green:SeekBar
    lateinit var seek_blue:SeekBar
    lateinit var edit_red:EditText
    lateinit var edit_green:EditText
    lateinit var edit_blue:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 透過 Layout Resource 的 id 來取得 UI 元件
        background = findViewById(R.id.background)
        seek_red = findViewById(R.id.seekBarRed)
        seek_green = findViewById(R.id.seekBarGreen)
        seek_blue = findViewById(R.id.seekBarBlue)
        edit_red = findViewById(R.id.editRed)
        edit_green = findViewById(R.id.editGreen)
        edit_blue = findViewById(R.id.editBlue)

        // 設定 SeekBar:red 的監聽事件
        seek_red.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        edit_red.setText(progress.toString())
                        position1 = progress
                        background.setBackgroundColor(Color.rgb(position1,position2,position3))
                        Log.d( "redValue=",position1.toString())
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        } )

        // 設定 SeekBar:green 的監聽事件
        seek_green.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        edit_green.setText(progress.toString())
                        position2 = progress
                        background.setBackgroundColor(Color.rgb(position1,position2,position3))
                        Log.d( "greenValue=",position2.toString())
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
                })

        // 設定 SeekBar:blue 的監聽事件
        seek_blue.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        edit_blue.setText(progress.toString())
                        position3 = progress
                        background.setBackgroundColor(Color.rgb(position1,position2,position3))
                        Log.d( "blueValue=",position3.toString())
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
                })
        }
    }
