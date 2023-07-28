package com.kkangs_android.ch10_notification

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class ReplyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // 알림에서 입력한 글 받아오기
        val replyTxt = androidx.core.app.RemoteInput.getResultsFromIntent(intent)
            ?.getCharSequence("key_text_reply")

        // 알림 취소
        val manager = context.getSystemService(
            AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(11)
    }
}