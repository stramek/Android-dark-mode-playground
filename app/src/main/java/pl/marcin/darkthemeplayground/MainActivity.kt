package pl.marcin.darkthemeplayground

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.*
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        setupListeners()
    }

    private fun setupListeners() {
        dayModeButton.setOnClickListener { setDefaultNightMode(MODE_NIGHT_NO) }
        darkModeButton.setOnClickListener { setDefaultNightMode(MODE_NIGHT_YES) }
        followPhoneButton.setOnClickListener { setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM) }
        followEnergySaveButton.setOnClickListener { setDefaultNightMode(MODE_NIGHT_AUTO_BATTERY) }
        checkModeButton.setOnClickListener { checkMode() }
    }

    private fun checkMode() {
        currentStateTextView.text = when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> getString(R.string.check_current_mode_result_day)
            Configuration.UI_MODE_NIGHT_YES -> getString(R.string.check_current_mode_result_night)
            else -> getString(R.string.check_current_mode_result_other)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        Log.i(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        super.onDestroy()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
