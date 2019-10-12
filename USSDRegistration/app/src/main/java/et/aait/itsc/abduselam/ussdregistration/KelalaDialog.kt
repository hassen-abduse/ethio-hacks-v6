package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_kelala.view.*
import kotlinx.android.synthetic.main.english_main_menu.view.*
import java.lang.IllegalStateException

class KelalaDialog: DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val kelalaDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_kelala, null)

            builder.setView(kelalaDialogView)

                .setTitle("Choose what to do")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val kebele = kelalaDialogView.kebele_edit_text.text.toString().toInt()
                    SharedData.oneTimeData.add(4, R.string.kebele01.toString())
                    if (kebele == 1){
                        val phoneNumberDialog = PhoneNumberDialog()
                        phoneNumberDialog.show(parentFragmentManager, "phone")
                    }
                    else if(kebele == 2){
                        val phoneNumberDialog = PhoneNumberDialog()
                        phoneNumberDialog.show(parentFragmentManager, "phone")
                    }
                    else if(kebele == 3){
                        val phoneNumberDialog = PhoneNumberDialog()
                        phoneNumberDialog.show(parentFragmentManager, "phone")
                    }
                    else if(kebele == 4){
                        val phoneNumberDialog = PhoneNumberDialog()
                        phoneNumberDialog.show(parentFragmentManager, "phone")
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