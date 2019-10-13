package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_language.view.*

class LanguageDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val languageDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_language, null)

            builder.setView(languageDialogView)

                .setTitle("Select Your Language")

                .setPositiveButton(R.string.next, DialogInterface.OnClickListener{ dialog, id ->

                    val inputText = languageDialogView.language_edit_text.text.toString().toInt()


                    if(inputText == 1) {
                        val mainMenuEnglish = MainMenuEnglish()
                        mainMenuEnglish.show(parentFragmentManager, "english")


                    }
                    else if(inputText == 2){

                        val mainMenuEnglish = MainMenuEnglish()
                        mainMenuEnglish.show(parentFragmentManager, "english")
                    }
                    else if(inputText == 3) {
                        val mainMenuEnglish = MainMenuEnglish()
                        mainMenuEnglish.show(parentFragmentManager, "english")

                    }
                    else {

                    }
                })

                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener{ dialog, id ->
                    // user cancelled the dialog
                })

                builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }
}