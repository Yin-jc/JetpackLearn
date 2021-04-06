package com.yjc.datastore

import androidx.datastore.core.Serializer
import com.yjc.datastore.protobuf.PersonProtos
import java.io.InputStream
import java.io.OutputStream

/**
 * author: yinjiacheng
 * date: 4/6/21 2:19 PM
 * description:
 */
object PersonSerializer : Serializer<PersonProtos.Person> {
    override val defaultValue: PersonProtos.Person
        get() = PersonProtos.Person.getDefaultInstance()

    override fun readFrom(input: InputStream): PersonProtos.Person = PersonProtos.Person.parseFrom(input)

    override fun writeTo(t: PersonProtos.Person, output: OutputStream) = t.writeTo(output)
}