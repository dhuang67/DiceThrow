package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel : ViewModel() {
    private val _dieSides = MutableLiveData(20)
    val dieSides: LiveData<Int> = _dieSides

    private val _currentRoll = MutableLiveData(1)
    val currentRoll: LiveData<Int> = _currentRoll

    fun setDieSides(sides: Int) {
        _dieSides.value = sides
        rollDie()
    }

    fun rollDie() {
        val sides = _dieSides.value ?: 6
        _currentRoll.value = (1..sides).random()
    }
}