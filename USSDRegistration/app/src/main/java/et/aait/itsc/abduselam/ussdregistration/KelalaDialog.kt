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
import kotlinx.android.synthetic.main.dialog_kelala.view.*

class KelalaDialog: DialogFragment() {


    @SuppressLint("MissingPermission")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val kelalaDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_kelala, null)

            builder.setView(kelalaDialogView)

                .setTitle(R.string.please_select_your_kebele)
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val kebele = kelalaDialogView.kebele_edit_text.text.toString().toInt()
                    SharedData.oneTimeData.add(4, getString(R.string.kebele01).substring(2))
                    val telephonyManager = getActivity()?.getSystemService(
                        Context.TELEPHONY_SERVICE) as TelephonyManager
                    val strMobileNumber = telephonyManager.line1Number
                    if(strMobileNumber != null && strMobileNumber != ""){

                    SharedData.oneTimeData.add(5, strMobileNumber)}
                    else {
                        SharedData.oneTimeData.add(5, "+251943869199")
                    }
                    val idDialog = IdDialog()
                    idDialog.show(parentFragmentManager, "id")
                })

                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener{ dialog, id ->
                    // user cancelled the dialog
                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }
}