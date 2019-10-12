package et.aait.itsc.abduselam.ussdregistration.data

data class CityVoter(
    val weredaID: Long,
    val voterPIN: Long,
    val status: String,
    val city: String,
    val subCity: String,
    val wereda: String,
    val phoneNumber: String

)