package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_south_wollo.view.*

class SouthWolloDialog: DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val southWolloDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_south_wollo, null)

            builder.setView(southWolloDialogView)

                .setTitle("Please Select your Region")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val wereda = southWolloDialogView.wereda_edit_text.text.toString().toInt()
                    SharedData.oneTimeData.add(3, getString(R.string.kelala).substring(2))
                    if(wereda == 3) {
                        val kelalaDialog = KelalaDialog()
                        kelalaDialog.show(parentFragmentManager, "kelala")
                    }
                    else if(wereda == 1) {
                        val kelalaDialog = KelalaDialog()
                        kelalaDialog.show(parentFragmentManager, "kelala")
                    }
                    else if(wereda == 2) {
                        val kelalaDialog = KelalaDialog()
                        kelalaDialog.show(parentFragmentManager, "kelala")
                    }
                    else if(wereda == 4) {
                        val kelalaDialog = KelalaDialog()
                        kelalaDialog.show(parentFragmentManager, "kelala")
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