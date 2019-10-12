package et.aait.itsc.abduselam.ussdregistration.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import et.aait.itsc.abduselam.ussdregistration.data.CityVoter
import et.aait.itsc.abduselam.ussdregistration.data.CityVoterApiService
import et.aait.itsc.abduselam.ussdregistration.repository.CityVoterRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CityVoterViewModel : ViewModel() {

    private val cityVoterRepository: CityVoterRepository

    init {
        val cityVoterApiService = CityVoterApiService.getInstance()
        cityVoterRepository = CityVoterRepository(cityVoterApiService)
    }

    private val _getResponse = MutableLiveData<Response<CityVoter>>()
    val getResponse: LiveData<Response<CityVoter>>
        get()= _getResponse

    private val _insertResponse = MutableLiveData<Response<CityVoter>>()
    val insertResponse: LiveData<Response<CityVoter>>
        get() = _insertResponse

    fun getCityVoterByPhoneNumber(phone: String) = viewModelScope.launch {
        _getResponse.postValue(cityVoterRepository.getCityVoterByPhoneNumber(phone))

    }

    fun insertCityVoter(cityVoter: CityVoter) = viewModelScope.launch {
        _insertResponse.postValue(cityVoterRepository.insertCityVoter(cityVoter))
    }
}