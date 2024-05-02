package com.danicode.basic.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.danicode.basic.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

// Persistencia => 1 sola instancia
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {
    companion object {
        const val VOLUME_KEY = "volumeKey"
        const val BLUETOOTH_KEY = "blueToothKey"
        const val VIBRATION_KEY = "vibrationKey"
        const val DARK_MODE_KEY = "darkModeKey"
    }

    private lateinit var mBinding: ActivitySettingsBinding
    private var firstTime: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        // LLamar a los settings (flujo que avisa cuando hay cambios)
        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { firstTime }.collect { settingsModel ->
                if (settingsModel != null) {
                    // Cuando se toca la UI(no se puede editar componentes desde un hilo secundario)
                    runOnUiThread {
                        mBinding.swVibration.isChecked = settingsModel.vibration
                        mBinding.swBluetooth.isChecked = settingsModel.bluetooth
                        mBinding.swDarkMode.isChecked = settingsModel.darkMode
                        mBinding.rsVolume.setValues(settingsModel.volume.toFloat())
                        firstTime = !firstTime
                    }
                }
            }
        }
        initUI()
    }

    private fun initUI() {
        mBinding.rsVolume.addOnChangeListener { _, value, _ ->
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
        }

        mBinding.swBluetooth.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(BLUETOOTH_KEY, value)
            }
        }

        mBinding.swVibration.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(VIBRATION_KEY, value)
            }
        }

        mBinding.swDarkMode.setOnCheckedChangeListener { _, value ->
            if (value) {
                enableDarkMode()
            } else {
                disableDarkMode()
            }
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(DARK_MODE_KEY, value)
            }
        }
    }

    // suspend, ya que estara dentro de una corutina
    private suspend fun saveVolume(value: Int) {
        dataStore.edit {
            it[intPreferencesKey(VOLUME_KEY)] = value
        }
    }

    private suspend fun saveOptions(key: String, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    // Flujos
    private fun getSettings(): Flow<SettingsModel?> {
        return dataStore.data.map { preferences ->
            SettingsModel(
                volume = preferences[intPreferencesKey(VOLUME_KEY)] ?: 20,
                bluetooth = preferences[booleanPreferencesKey(BLUETOOTH_KEY)] ?: true,
                darkMode = preferences[booleanPreferencesKey(DARK_MODE_KEY)] ?: true,
                vibration = preferences[booleanPreferencesKey(VIBRATION_KEY)] ?: true
            )

        }
    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}