package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_addis_ababa.view.*
import kotlinx.android.synthetic.main.dialog_arada.view.*
import java.lang.IllegalStateException

class AradaDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val aradaview = LayoutInflater.from(context).inflate(R.layout.dialog_arada, null)

            builder.setView(aradaview)

                .setTitle("Please Select your Wereda")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val wereda = aradaview.wereda_edit_text.text.toString().toInt()
                    SharedData.oneTimeData.add(3, R.string.wereda1.toString())
                    val phoneNumberDialog = PhoneNumberDialog()
                    phoneNumberDialog.show(parentFragmentManager, "id")
                    //SharedData.oneTimeData.add(3, R.string.wereda1.toString())
                })

                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener{ dialog, id ->
                    // user cancelled the dialog
                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }
}