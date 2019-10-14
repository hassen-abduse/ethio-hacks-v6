package et.aait.itsc.abduselam.ussdregistration

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.city_or_region.view.*
import java.lang.IllegalStateException

class CityOrRegionForStatusPin : DialogFragment(){


    @SuppressLint("MissingPermission")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val cityOrRegionView = LayoutInflater.from(context).inflate(R.layout.city_or_region, null)

            builder.setView(cityOrRegionView)

                .setTitle(R.string.city_or_region)
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val cityOrRegion = cityOrRegionView.city_or_region_edit_text.text.toString().toInt()

                    if(cityOrRegion == 1) {
                        SharedData.statusPin.add(0, "City")
                        val telephonyManager = getActivity()?.getSystemService(
                            Context.TELEPHONY_SERVICE) as TelephonyManager
                        val strMobileNumber = telephonyManager.line1Number
                        if(strMobileNumber != null && strMobileNumber != ""){

                            SharedData.statusPin.add(1, strMobileNumber)}
                        else {
                            SharedData.statusPin.add(1, "+251943869199")
                        }
                        val statusAndPinDialog = StatusAndPinDialog()
                        statusAndPinDialog.show(parentFragmentManager, "status-pin")

                    }
                    else if(cityOrRegion == 2){
                        SharedData.statusPin.add(0, "Region")
                        val telephonyManager = getActivity()?.getSystemService(
                            Context.TELEPHONY_SERVICE) as TelephonyManager
                        val strMobileNumber = telephonyManager.line1Number
                        if(strMobileNumber != null && strMobileNumber != ""){

                            SharedData.statusPin.add(1, strMobileNumber)}
                        else {
                            SharedData.statusPin.add(1, "+251943869199")
                        }
                        val statusAndPinDialog = StatusAndPinDialog()
                        statusAndPinDialog.show(parentFragmentManager, "status-pin")

                    }
                    else {
                        dismiss()

                    }
                })

                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener{ dialog, id ->
                    // user cancelled the dialog
                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }
}