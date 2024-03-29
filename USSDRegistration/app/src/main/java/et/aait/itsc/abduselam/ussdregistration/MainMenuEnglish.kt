package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.english_main_menu.view.*
import java.lang.IllegalStateException

class MainMenuEnglish : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val mainDialogView = LayoutInflater.from(context).inflate(R.layout.english_main_menu, null)

                builder.setView(mainDialogView)

                .setTitle(R.string.please_choose_what_to_do)
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val mainChoice = mainDialogView.main_edit_text.text.toString().toInt()
                    if(mainChoice == 1) {
                        val ctiyOrRegionDialog = CityOrRegionDialog()
                        ctiyOrRegionDialog.show(parentFragmentManager, "cityOrRegion")

                    }
                    else if(mainChoice == 2){
                        val cityOrRegionForStatusPin = CityOrRegionForStatusPin()
                        cityOrRegionForStatusPin.show(parentFragmentManager, "city-or-region-status")


                    }
                    else if(mainChoice == 3) {
                        val cityOrRegionForStatusPin = CityOrRegionForStatusPin()
                        cityOrRegionForStatusPin.show(parentFragmentManager, "city-or-region-status")

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