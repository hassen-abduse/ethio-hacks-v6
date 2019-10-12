package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.RegionalVoter
import kotlinx.android.synthetic.main.dialog_id.view.*
import kotlinx.android.synthetic.main.dialog_phone.view.*
import java.lang.IllegalStateException

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
                    //val statusView = LayoutInflater.from(context).inflate(R.layout.dialog_pin_status, null)
                    //statusView.id_edit_text.text = voter.pin
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