package ar.edu.unlam.viewmodels.data.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface PersonaDao {
    @Query("SELECT * FROM Persona")
    fun get(): List<Persona>
}