package com.yjc.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * author: yinjiacheng
 * date: 3/31/21 9:19 PM
 * description: Test DataStore
 */
class TestPreferencesDataStore (ctx: Context) {

    private val dataStore: DataStore<Preferences> = ctx.createDataStore("TestPreferencesDataStore")

    suspend fun saveData(value: String) {
        val preferKey = stringPreferencesKey("TestPreferencesDataStoreKey")
        dataStore.edit { preferences ->
            preferences[preferKey] = value
        }
    }

    suspend fun readData(): String {
        val preferKey = stringPreferencesKey("TestPreferencesDataStoreKey")
        val value = dataStore.data.map { preferences ->
            preferences[preferKey] ?: ""
        }
        return value.first()
    }

}
