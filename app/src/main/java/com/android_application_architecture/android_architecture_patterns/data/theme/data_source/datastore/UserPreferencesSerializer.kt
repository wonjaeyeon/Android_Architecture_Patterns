package com.android_application_architecture.android_architecture_patterns.data.theme.data_source.datastore

import androidx.datastore.core.CorruptionException
import com.google.protobuf.InvalidProtocolBufferException
import kotlinx.serialization.Serializer
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject
/**
 * An [androidx.datastore.core.Serializer] for the [UserPreferences] proto.
 */
class UserPreferencesSerializer @Inject constructor() : Serializer<UserPreferences> {
    override val defaultValue: UserPreferences = UserPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreferences =
        try {
            // readFrom is already called on the data store background thread
            UserPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        // writeTo is already called on the data store background thread
        t.writeTo(output)
    }
}
