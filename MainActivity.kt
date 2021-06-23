package com.example.ageinmin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val datebtn = findViewById(R.id.datebutton) as Button
        datebtn.setOnClickListener {view ->
            clickDatePicker(view)
            //
        }


    }
    fun clickDatePicker(view:View){
        val mycalendar = Calendar.getInstance()
        val year = mycalendar.get(Calendar.YEAR)
        val month = mycalendar.get(Calendar.MONTH)
        val day = mycalendar.get(Calendar.DAY_OF_MONTH)
     val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
             view,Syear, Smonth, SdayOfMonth ->
                         val Sdate = "$SdayOfMonth/${Smonth+1}/$Syear"
                          val tvdate = findViewById(R.id.selecteddate) as TextView
         val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
         val thedate = sdf.parse(Sdate)
         tvdate.text = Sdate

         val inminutes = thedate!!.time/60000
         var indays = inminutes/1440
         val crntdate = sdf.parse(sdf.format(System.currentTimeMillis()))
         val crntdateinminutes = crntdate!!.time/60000
         val crntdateindays = crntdateinminutes/1440
         val finalres = crntdateindays - indays
         val tvfinal = findViewById(R.id.dateinminutes)as TextView
         tvfinal.text = finalres.toString()                                                   },year,month,day)
        dpd.datePicker.setMaxDate(Date().time-86400000)
dpd.show()
    }
}