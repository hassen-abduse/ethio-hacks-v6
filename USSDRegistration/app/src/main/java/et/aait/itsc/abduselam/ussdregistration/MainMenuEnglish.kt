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

                .setTitle("Choose what to do")
                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val mainChoice = mainDialogView.main_edit_text.text.toString().toInt()
                    if(mainChoice == 1) {
                        val ctiyOrRegionDialog = CityOrRegionDialog()
                        ctiyOrRegionDialog.show(parentFragmentManager, "cityOrRegion")

                    }
                    else if(mainChoice == 2){
                        val phoneNumberForStatusPinDialog = PhoneNumberForStatusPinDialog()
                        phoneNumberForStatusPinDialog.show(parentFragmentManager, "phone")

                    }
                    else if(mainChoice == 3) {
                        val phoneNumberForStatusPinDialog = PhoneNumberForStatusPinDialog()
                        phoneNumberForStatusPinDialog.show(parentFragmentManager, "phone")

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