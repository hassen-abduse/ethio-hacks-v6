package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.CityVoter
import et.aait.itsc.abduselam.ussdregistration.data.RegionalVoter
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import et.aait.itsc.abduselam.ussdregistration.viewmodel.CityVoterViewModel
import et.aait.itsc.abduselam.ussdregistration.viewmodel.RegionalVoterViewModel
import kotlinx.android.synthetic.main.dialog_city.view.*
import kotlinx.android.synthetic.main.dialog_south_wollo.view.*
import java.lang.IllegalStateException
import kotlin.random.Random

class SuccessDialog: DialogFragment() {

    val cityVoterViewModel = CityVoterViewModel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val successDialog = LayoutInflater.from(context).inflate(R.layout.dialog_success, null)
            val cityVoterViewModel: CityVoterViewModel
            val regionalVoterViewModel: RegionalVoterViewModel
            val pin = Random.nextLong()
            val data = SharedData.oneTimeData
            if(SharedData.oneTimeData[0] == "City") {

                val cityVoter = CityVoter(data[1],data[2], data[3], data[4], data[5], pin, "Pending")
                //cityVoterViewModel.insertCityVoter(cityVoter)
            }
            else {

                val regionalVoter = RegionalVoter(data[1],data[2], data[3], data[4], data[5], data[6], pin, "Pending")
               // regionalVoterViewModel.insertRegionalVoter(regionalVoter)
            }
            builder.setView(successDialog)

                .setTitle("Operation Succesful!")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->


                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }
}