package ar.edu.unlam.viewmodels.utils

class SeedRandomNumber : SeedNumber() {

    override fun seed(): Int {
        return (0..100).random()
    }
}