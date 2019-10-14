package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_city.view.*

class CityDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val cityView = LayoutInflater.from(context).inflate(R.layout.dialog_city, null)

            builder.setView(cityView)

                .setTitle(R.string.please_select_your_city)
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val city = cityView.city_edit_text.text.toString().toInt()
                    if(city == 1) {
                        SharedData.oneTimeData.add(1, getString(R.string.addis_ababa).substring(2))
                        val addisAbabaDialog = AddisAbabaDialog()
                        addisAbabaDialog.show(parentFragmentManager, "addis ababa")


                    }
                    else if(city == 2){
                        SharedData.oneTimeData.add(1, R.string.dire_dawa.toString())
                        val direDawaDialog = AddisAbabaDialog()
                        direDawaDialog.show(parentFragmentManager, "dire dawa")


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