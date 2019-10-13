package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_phone.view.*

class PhoneNumberForStatusPinDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val phoneNumberDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_phone, null)

            builder.setView(phoneNumberDialogView)

                .setTitle("Please Enter your phone number")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val phone = phoneNumberDialogView.phone_edit_text.text.toString()
                    SharedData.statusPin.add(1, phone)
                    val statusPinDialog = StatusAndPinDialog()
                    statusPinDialog.show(parentFragmentManager, "status and pin")
                })

                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener{ dialog, id ->
                    // user cancelled the dialog
                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }
}