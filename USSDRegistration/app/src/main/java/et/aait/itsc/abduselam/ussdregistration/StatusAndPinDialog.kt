package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class StatusAndPinDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val statusPinDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_pin_status, null)

            builder.setView(statusPinDialogView)

                .setTitle("Your Info!")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->
                    dismiss()

                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }

}
