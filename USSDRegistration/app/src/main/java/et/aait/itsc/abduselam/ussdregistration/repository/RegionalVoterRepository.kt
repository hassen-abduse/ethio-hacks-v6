package et.aait.itsc.abduselam.ussdregistration.repository

import et.aait.itsc.abduselam.ussdregistration.data.RegionalVoter
import et.aait.itsc.abduselam.ussdregistration.data.RegionalVoterApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RegionalVoterRepository(private val regionalVoterApiService: RegionalVoterApiService) {

    suspend fun getRegionalVoterByPhoneNumber(phone: String): Response<RegionalVoter> =
        withContext(Dispatchers.IO) {
            regionalVoterApiService.getRegionalVoterByPhoneNumber(phone).await()
        }

    suspend fun insertRegionalVoter(regionalVoter: RegionalVoter): Response<RegionalVoter> =
        withContext(Dispatchers.IO) {
            regionalVoterApiService.insertRegionalVoter(regionalVoter).await()
        }
}