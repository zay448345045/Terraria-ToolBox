package silkways.terraria.toolbox.logic

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import silkways.terraria.toolbox.data.Settings

object ApplicationSettings {

    @JvmStatic
    fun setupLanguage(context: Context) {
        val type = LanguageHelper.getLanguage(JsonConfigModifier.readJsonValue(context, Settings.jsonPath, Settings.languageKey), context)
        LanguageHelper.setAppLanguage(context, type)
        println("Language: $type")
    }

    fun setupTheme(context: Context) {
        when(JsonConfigModifier.readJsonValue(context, Settings.jsonPath, Settings.themeKey)) {
            0 -> {
                val isDarkModeEnabled = AppCompatDelegate.getDefaultNightMode()
                if (isDarkModeEnabled == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }else if(isDarkModeEnabled == AppCompatDelegate.MODE_NIGHT_NO){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }

            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}