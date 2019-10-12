package et.aait.itsc.abduselam.ussdregistration.data

data class RegionalVoter(
    val kebeleID: Long,
    val voterPIN: Long,
    val status: String,
    val region: String,
    val zone: String,
    val wereda: String,
    val kebele: String,
    val phoneNumber: String

)
