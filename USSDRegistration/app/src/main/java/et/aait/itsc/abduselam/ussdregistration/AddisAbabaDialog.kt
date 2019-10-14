package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_addis_ababa.view.*

class AddisAbabaDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val addisAbabaView = LayoutInflater.from(context).inflate(R.layout.dialog_addis_ababa, null)

            builder.setView(addisAbabaView)

                .setTitle(R.string.please_enter_your_sub_city)
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val subCity = addisAbabaView.sub_city_edit_text.text.toString().toInt()
                    if(subCity == 1) {
                        SharedData.oneTimeData.add(2, getString(R.string.arada).substring(2))
                        val aradaDialog = AradaDialog()
                        aradaDialog.show(parentFragmentManager, "arada")


                    }
                    else if(subCity == 2){
                        val aradaDialog = AradaDialog()
                        aradaDialog.show(parentFragmentManager, "arada")

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