package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_amhara.view.*

class AmharaDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val amharaDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_amhara, null)

            builder.setView(amharaDialogView)

                .setTitle("Please Select your Zone")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val region = amharaDialogView.zone_edit_text.text.toString().toInt()
                    SharedData.oneTimeData.add(2, getString(R.string.south_wollo).substring(2))
                    if(region == 3) {
                        val southWolloDialog = SouthWolloDialog()
                        southWolloDialog.show(parentFragmentManager, "south-wollo")
                    }
                    else if(region == 1) {
                        val southWolloDialog = SouthWolloDialog()
                        southWolloDialog.show(parentFragmentManager, "south-wollo")
                    }
                    else if(region == 2) {
                        val southWolloDialog = SouthWolloDialog()
                        southWolloDialog.show(parentFragmentManager, "south-wollo")
                    }
                    else if(region == 4) {
                        val southWolloDialog = SouthWolloDialog()
                        southWolloDialog.show(parentFragmentManager, "south-wollo")
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