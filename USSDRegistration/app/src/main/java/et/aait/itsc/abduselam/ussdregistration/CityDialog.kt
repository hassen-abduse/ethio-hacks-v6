package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.city_or_region.view.*
import kotlinx.android.synthetic.main.dialog_city.view.*
import java.lang.IllegalStateException

class CityDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val cityView = LayoutInflater.from(context).inflate(R.layout.dialog_city, null)

            builder.setView(cityView)

                .setTitle("Please Select your City")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val city = cityView.city_edit_text.text.toString().toInt()
                    if(city == 1) {
                        SharedData.oneTimeData.add(1, R.string.addis_ababa.toString())
                        val addisAbabaDialog = AddisAbabaDialog()
                        addisAbabaDialog.show(parentFragmentManager, "addis ababa")


                    }
                    else if(city == 2){
                        SharedData.oneTimeData.add(1, R.string.dire_dawa.toString())
                        val direDawaDialog = DireDawaDialog()
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