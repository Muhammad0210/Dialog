package com.example.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogs.databinding.ActivityMainBinding
import com.example.dialogs.databinding.ItemDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlert.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Ogohlantirish")
            dialog.setMessage("Haqiqattanham ochirmoqchimisiz")
            dialog.setNeutralButton(
                "Back"
            ) { p0, p1 ->
                Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show()
            }
            dialog.setPositiveButton("Yes",) { p0, p1 ->
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("Rozi emasman", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(this@MainActivity, "Ochirilmadi", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.show()
        }
        binding.btnCustom.setOnClickListener {
            val dialog = AlertDialog.Builder(this).create()
            val itemDialog = ItemDialogBinding.inflate(layoutInflater)

            dialog.setCancelable(false)

            itemDialog.btnYes.setOnClickListener {
                Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }

            itemDialog.btnNo.setOnClickListener {
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }

            dialog.setView(itemDialog.root)
            dialog.show()
        }

        binding.btnFragment.setOnClickListener {
            val myDialogFragment = DialogFragment()
            myDialogFragment.show(supportFragmentManager, myDialogFragment.toString())
        }

        binding.btnTimePicker.setOnClickListener {
            val dialog = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Toast.makeText(this@MainActivity, "$p1:$p2", Toast.LENGTH_SHORT).show()
                }
            }, 17, 57, true )
            dialog.show()
        }
        binding.btnDatePicker.setOnClickListener {
            val dateDialog = DatePickerDialog(
                this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                        Toast.makeText(this@MainActivity, "$p1.$p2.$p3", Toast.LENGTH_SHORT).show()
                    }
                },
                2022, 11, 23
            ).show()
        }
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Welcome to Android Teachers!!!",
                Snackbar.LENGTH_LONG)
                .setAction("Back", object :View.OnClickListener{
                    override fun onClick(p0: View?) {
                        Toast.makeText(this@MainActivity, "Back", Toast.LENGTH_SHORT).show()
                    }
                })
                .show()

        }
        binding.btnBottomSheet.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val itemDialogBinding = ItemDialogBinding.inflate(layoutInflater)
            dialog.setContentView(itemDialogBinding.root)
            dialog.show()
        }
    }
}