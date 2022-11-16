package com.example.izotov_criminalintent

import androidx.lifecycle.ViewModel
import com.example.izotov_criminalintent.database.CrimeRepository

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()
    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

    fun addCrime(crime: Crime) {
        crimeRepository.addCrime(crime)
    }

    init {
        for (i in 1 until 101) {
            val crime = Crime()
            crime.title = "Crime #$i"
            crime.isSolved = i % 2 == 0
            crimes += crime
        }
    }
}