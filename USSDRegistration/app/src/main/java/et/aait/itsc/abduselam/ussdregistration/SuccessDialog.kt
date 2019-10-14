package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import et.aait.itsc.abduselam.ussdregistration.data.CityVoter
import et.aait.itsc.abduselam.ussdregistration.data.RegionalVoter
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import et.aait.itsc.abduselam.ussdregistration.viewmodel.CityVoterViewModel
import et.aait.itsc.abduselam.ussdregistration.viewmodel.RegionalVoterViewModel
import kotlinx.android.synthetic.main.dialog_success.view.*
import kotlin.random.Random

class SuccessDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val successDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_success, null)
            val regionalVoterViewModel = ViewModelProviders.of(this).get(RegionalVoterViewModel::class.java)
            val cityVoterViewModel = ViewModelProviders.of(this).get(CityVoterViewModel::class.java)

            val pin = Random.nextLong()
            val data = SharedData.oneTimeData
//            Log.e("City or  Region", SharedData.oneTimeData[0])
//            Log.e("City", SharedData.oneTimeData[1])
//            Log.e("Sub City", SharedData.oneTimeData[2])
//            Log.e("Wereda", SharedData.oneTimeData[3])
//            Log.e("kebele", SharedData.oneTimeData[4])
//            Log.e("phone Number", SharedData.oneTimeData[5])
//            Log.e("Kebele ID", SharedData.oneTimeData[6])
            if(SharedData.oneTimeData[0] == "City") {

                val cityVoter = CityVoter(data[1],data[2], data[3], data[4], data[5], pin, "PENDING")
                Log.e("City or  Region", SharedData.oneTimeData[0])
                Log.e("City", cityVoter.city)
                Log.e("Sub City", cityVoter.subCity)
                Log.e("Wereda", cityVoter.wereda)
                Log.e("wereda ID", cityVoter.weredaID)
                Log.e("phone Number", cityVoter.phoneNumber)
                Log.e("status", cityVoter.status)

                cityVoterViewModel.insertCityVoter(cityVoter)
                cityVoterViewModel.insertResponse.observe(this, androidx.lifecycle.Observer {
                    response -> response.body()?.run {

                    successDialogView.pin.text = "Succesfully Registerd!"

                }
                })

            }

            else {

                val regionalVoter = RegionalVoter(data[1],data[2], data[3], data[4], data[5], data[6], pin, "PENDING")
                Log.e("City or  Region", SharedData.oneTimeData[0])
                Log.e("Region", regionalVoter.region)
                Log.e("Zone", regionalVoter.zone)
                Log.e("Wereda", regionalVoter.wereda)
                Log.e("kebele", regionalVoter.kebele)
                Log.e("kebeleID", regionalVoter.kebeleID)
                Log.e("phone Number", regionalVoter.phoneNumber)
                Log.e("status", regionalVoter.status)
                regionalVoterViewModel.insertRegionalVoter(regionalVoter)
                regionalVoterViewModel.insertResponse.observe(this, androidx.lifecycle.Observer {

                    successDialogView.pin.text = "Succesfully Registerd!"

                })}

            builder.setView(successDialogView)

                .setTitle("Operation Succesful!")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->


                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }




}