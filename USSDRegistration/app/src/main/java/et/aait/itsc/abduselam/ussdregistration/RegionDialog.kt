package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_region.view.*

class RegionDialog : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val regionDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_region, null)

            builder.setView(regionDialogView)

                .setTitle(R.string.please_select_your_region)
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val region = regionDialogView.region_edit_text.text.toString().toInt()
                    SharedData.oneTimeData.add(1, getString(R.string.amhara).substring(2))
                    if(region == 3) {

                        val amharaDialog = AmharaDialog()
                        amharaDialog.show(parentFragmentManager, "amhara")
                    }
                    else if(region == 1) {
                        val amharaDialog = AmharaDialog()
                        amharaDialog.show(parentFragmentManager, "amhara")
                    }
                    else if(region == 2) {
                        val amharaDialog = AmharaDialog()
                        amharaDialog.show(parentFragmentManager, "amhara")
                    }
                    else if(region == 4) {
                        val amharaDialog = AmharaDialog()
                        amharaDialog.show(parentFragmentManager, "amhara")
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