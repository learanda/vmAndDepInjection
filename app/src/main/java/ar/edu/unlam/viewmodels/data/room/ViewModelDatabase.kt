package ar.edu.unlam.viewmodels.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    exportSchema = false,
    entities = [Persona::class]
)
abstract class ViewModelDatabase :RoomDatabase(){
    abstract fun personaDao():PersonaDao
}