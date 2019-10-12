package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_id.view.*
import kotlinx.android.synthetic.main.english_main_menu.view.*
import java.lang.IllegalStateException

class IdDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val idDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_id, null)

            builder.setView(idDialogView)

                .setTitle("Please Enter your ID")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val id = idDialogView.id_edit_text.text.toString()
                    if(SharedData.oneTimeData[0] == "City") {

                        SharedData.oneTimeData.add(5, id.toString())
                    }
                    else {
                        SharedData.oneTimeData.add(6, id.toString())
                    }
                    val successDialog = SuccessDialog()
                    successDialog.show(parentFragmentManager, "success")

                })

                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener{ dialog, id ->
                    // user cancelled the dialog
                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }
}