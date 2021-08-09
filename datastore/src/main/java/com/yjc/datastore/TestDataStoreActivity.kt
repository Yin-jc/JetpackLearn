package com.yjc.jetpacklearn

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.yjc.datastore.PersonModel
import com.yjc.datastore.TestPreferencesDataStore
import com.yjc.datastore.TestProtoDataStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * author: yinjiacheng
 * date: 4/2/21 3:28 PM
 * description:
 */
class TestDataStoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_datastore)

        val preferencesDataStore = TestPreferencesDataStore(this)
        lifecycleScope.launch {
            preferencesDataStore.saveData("456")
            val result = preferencesDataStore.readData()
            Log.d("JetpackLearn", result)
        }

        val protoDataStore = TestProtoDataStore(this)
        val personModel = PersonModel("Yjc", 25, true)
        lifecycleScope.launch {
            protoDataStore.saveData(personModel)
            val result = protoDataStore.readData()
            Log.d("JetpackLearn", String.format("Person name is: %s, age is: %d, isMale is: %b", result.name, result.age, result.isMale))
        }
    }
}