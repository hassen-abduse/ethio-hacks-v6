package et.aait.itsc.abduselam.ussdregistration.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import et.aait.itsc.abduselam.ussdregistration.data.CityVoter
import et.aait.itsc.abduselam.ussdregistration.data.CityVoterApiService
import et.aait.itsc.abduselam.ussdregistration.data.RegionalVoter
import et.aait.itsc.abduselam.ussdregistration.data.RegionalVoterApiService
import et.aait.itsc.abduselam.ussdregistration.repository.CityVoterRepository
import et.aait.itsc.abduselam.ussdregistration.repository.RegionalVoterRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class RegionalVoterViewModel: ViewModel(){

    private val regionalVoterRepository: RegionalVoterRepository

    init {
        val regionalVoterApiService = RegionalVoterApiService.getInstance()
        regionalVoterRepository = RegionalVoterRepository(regionalVoterApiService)
    }

    private val _getResponse = MutableLiveData<Response<RegionalVoter>>()
    val getResponse: LiveData<Response<RegionalVoter>>
        get()= _getResponse

    private val _insertResponse = MutableLiveData<Response<RegionalVoter>>()
    val insertResponse: LiveData<Response<RegionalVoter>>
        get() = _insertResponse

    fun getRegionalVoterByPhoneNumber(phone: String) = viewModelScope.launch {
        _getResponse.postValue(regionalVoterRepository.getRegionalVoterByPhoneNumber(phone))

    }

    fun insertRegionalVoter(regionalVoter: RegionalVoter) = viewModelScope.launch {
        _insertResponse.postValue(regionalVoterRepository.insertRegionalVoter(regionalVoter))
    }
}