package com.kkangs_android.ch8_event

import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kkangs_android.ch8_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var initTime = 0L   // 뒤로가기 버튼을 누른 시각
    var pauseTime = 0L  // 멈춘 시각

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            binding.myChronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.myChronometer.start()

            // 버튼 표시 여부
            binding.startButton.isEnabled = false
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
        }

        binding.stopButton.setOnClickListener {
            pauseTime = binding.myChronometer.base - SystemClock.elapsedRealtime()
            binding.myChronometer.stop()

            // 버튼 표시 여부
            binding.startButton.isEnabled = true
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
        }

        binding.resetButton.setOnClickListener {
            pauseTime = 0L
            binding.myChronometer.base = SystemClock.elapsedRealtime()
            binding.myChronometer.stop()

            // 버튼 표시 여부
            binding.startButton.isEnabled = true
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = false
        }
    }

    // 뒤로가기 버튼의 이벤트 핸들러
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode === KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime > 3000) {
                Toast.makeText(this, "종료하려면 한 번 더 누르세요!", Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}