package et.aait.itsc.abduselam.ussdregistration

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import et.aait.itsc.abduselam.ussdregistration.data.SharedData
import kotlinx.android.synthetic.main.dialog_arada.view.*
import java.lang.IllegalStateException

class NoNetWorkDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val noNetWorkDialogView = LayoutInflater.from(context).inflate(R.layout.no_network, null)

            builder.setView(noNetWorkDialogView)

                .setTitle("Connect to Network!")
                .setPositiveButton(R.string.ok, DialogInterface.OnClickListener{ dialog, id ->

                })

            builder.create()


        } ?: throw IllegalStateException("Actitvity Cannot be null")
    }
}