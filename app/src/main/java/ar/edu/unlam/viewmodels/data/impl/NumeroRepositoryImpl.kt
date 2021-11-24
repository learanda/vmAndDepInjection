package ar.edu.unlam.viewmodels.data.impl

import ar.edu.unlam.viewmodels.data.NumeroRepository
import ar.edu.unlam.viewmodels.data.room.PersonaDao
import ar.edu.unlam.viewmodels.utils.SeedNumber

class NumeroRepositoryImpl(seed: SeedNumber, personaDao: PersonaDao) : NumeroRepository {

    var number = seed.seed()

    override fun add() {
        number += 1
    }

    override fun delete() {
        number -=1
    }

    override fun get(): Int {
        return number
    }
}