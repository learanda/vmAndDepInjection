package ar.edu.unlam.viewmodels.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Persona")
data class Persona(
    @ColumnInfo(name = "name")
    val nombre: String,

    @ColumnInfo(name = "surname")
    val apellido: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}