package com.example.myageinmin
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDatePicker.setOnClickListener{
                View->ClickDatePicker(View)


        }
    }

    fun ClickDatePicker(view:View){
        val myCalendar=Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)
//        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
//                View,
//                selyear,
//                selmonth,
//                seldayOfMonth,
//            ->Toast.makeText(this, "The Chosen Year $selyear, the chosen month ${selmonth+1} the chosen date $seldayOfMonth", Toast.LENGTH_SHORT).show()
//            val selectedDate="$seldayOfMonth/${selmonth+1}/$selyear"
//            tvSelectedDate.setText(selectedDate)
//
//            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
//            val theDate=sdf.parse(selectedDate)
//            val selectedDateInMinues=theDate!!.time/60000
//            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
//            val currentDateInMin=currentDate!!.time/60000
//            val diffInMiutes=currentDateInMin-selectedDateInMinues
//            tvAgeInMin.setText(diffInMiutes.toString())
//        },year,month,day)
//        dpd.datePicker.setMaxDate(Date().time-86400000)
//        dpd.show()
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
                View,
                selyear,
                selmonth,
                seldayOfMonth,
            ->Toast.makeText(this, "The Chosen Year $selyear, the chosen month ${selmonth+1} the chosen date $seldayOfMonth", Toast.LENGTH_SHORT).show()
            val selectedDate="$seldayOfMonth/${selmonth+1}/$selyear"
            tvSelectedDate.setText(selectedDate)

            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate=sdf.parse(selectedDate)
            val selectedDateInMinues=theDate!!.time/60000
            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMin=currentDate!!.time/60000
            val diffInMiutes=currentDateInMin-selectedDateInMinues
            val diffInDays=diffInMiutes/1440
            val diffInYear=diffInDays/365
            tvAgeInMin.setText(diffInMiutes.toString())
            tvAgeInDays.setText(diffInDays.toString())
            tvAgeInYears.setText(diffInYear.toString() )
        },year,month,day).show()
    }

}