package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.city_or_region.view.*

class CityOrRegionDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val cityOrRegionView = LayoutInflater.from(context).inflate(R.layout.city_or_region, null)

            builder.setView(cityOrRegionView)

                .setTitle("City or Region?")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val cityOrRegion = cityOrRegionView.city_or_region_edit_text.text.toString().toInt()

                    if(cityOrRegion == 1) {
                        SharedData.oneTimeData.add(0, "City")
                        val cityDialog = CityDialog()
                        cityDialog.show(parentFragmentManager, "city")


                    }
                    else if(cityOrRegion == 2){
                        SharedData.oneTimeData.add(0, "Region")
                        val regionDialog = RegionDialog()
                        regionDialog.show(parentFragmentManager, "region")

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