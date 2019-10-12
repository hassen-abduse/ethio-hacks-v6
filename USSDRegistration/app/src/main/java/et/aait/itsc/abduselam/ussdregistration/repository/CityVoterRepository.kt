package et.aait.itsc.abduselam.ussdregistration.repository

import et.aait.itsc.abduselam.ussdregistration.data.CityVoter
import et.aait.itsc.abduselam.ussdregistration.data.CityVoterApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CityVoterRepository(private val cityVoterApiService: CityVoterApiService) {

    suspend fun getCityVoterByPhoneNumber(phone: String): Response<CityVoter> =
        withContext(Dispatchers.IO) {
            cityVoterApiService.getCityVoterByPhoneNumber(phone).await()
        }

    suspend fun insertCityVoter(cityVoter: CityVoter): Response<CityVoter> =
        withContext(Dispatchers.IO) {
            cityVoterApiService.insertRegionalVoter(cityVoter).await()
        }
}