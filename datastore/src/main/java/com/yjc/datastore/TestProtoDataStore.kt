package com.yjc.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.yjc.datastore.protobuf.PersonProtos
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * author: yinjiacheng
 * date: 4/6/21 2:19 PM
 * description:
 */
class TestProtoDataStore(ctx: Context) {

    private val dataStore: DataStore<PersonProtos.Person> = ctx.createDataStore("TestProtoDataStore", PersonSerializer)

    suspend fun readData(): PersonModel {
        val result = dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(PersonProtos.Person.getDefaultInstance())
                } else {
                    throw it
                }
            }.map {
                PersonModel(it.name, it.age, it.isMale)
            }
        return result.first()
    }

    suspend fun saveData(personModel: PersonModel) {
        dataStore.updateData {
            it.toBuilder().setName(personModel.name).setAge(personModel.age).setIsMale(personModel.isMale).build()
        }
    }
}