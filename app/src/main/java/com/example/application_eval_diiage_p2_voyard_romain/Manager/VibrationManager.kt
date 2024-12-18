package com.example.application_eval_diiage_p2_voyard_romain.nativemanager

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

class VibrationManager(private val context: Context) {
    private val vibrator: Vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    /**
     * Fonction pour faire vibrer le téléphone pendant une durée donnée.
     * @param durationMs Durée de la vibration en millisecondes.
     */
    private fun vibratePhone(durationMs: Long) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Pour Android Oreo (API 26) et versions supérieures
            val vibrationEffect = VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE)
            vibrator.vibrate(vibrationEffect)
        } else {
            // Pour les anciennes versions d'Android
            @Suppress("DEPRECATION")
            vibrator.vibrate(durationMs)
        }
    }

    /**
     * Fonction pour faire vibrer le téléphone quand un bouton est cliqué.
     */
    fun vibrateOnButtonClicked() = vibratePhone(200) // Vibration de 200ms
}
