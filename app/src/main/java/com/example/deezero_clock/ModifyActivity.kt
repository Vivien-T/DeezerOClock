package com.example.deezero_clock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_modify.*

class ModifyActivity : AppCompatActivity() {

    var _alarm = Alarme()
    var manager = AlarmManager()
    var index:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)
        index = intent.getIntExtra("keyAlarmList", 0)
        manager.getListBD()
        _alarm = manager.listealarmes[index]
        timeSet.hour = _alarm.getHour()
        timeSet.minute = _alarm.getMinute()
        timeSet.setIs24HourView(true)
    }

    fun ClickJour(jour: View){
        chkEveryday.isChecked = false

        if(jour == imageLundi){
            if(_alarm.lundi == false){
                _alarm.lundi = true
                imageLundi.setImageResource(R.drawable.lettrelsurl)
            }
            else{
                _alarm.lundi = false
                imageLundi.setImageResource(R.drawable.lettrel)
            }
        }
        else if(jour == imageMardi){
            if(_alarm.mardi == false){
                _alarm.mardi = true
                imageMardi.setImageResource(R.drawable.lettremsurl)
            }
            else{
                _alarm.mardi = false
                imageMardi.setImageResource(R.drawable.lettrem)
            }
        }
        else if(jour == imageMercredi){
            if(_alarm.mercredi == false){
                _alarm.mercredi = true
                imageMercredi.setImageResource(R.drawable.lettremsurl)
            }
            else{
                _alarm.mercredi = false
                imageMercredi.setImageResource(R.drawable.lettrem)
            }
        }
        else if(jour == imageJeudi){
            if(_alarm.jeudi == false){
                _alarm.jeudi = true
                imageJeudi.setImageResource(R.drawable.lettrejsurl)
            }
            else{
                _alarm.jeudi = false
                imageJeudi.setImageResource(R.drawable.lettrej)
            }
        }
        else if(jour == imageVendredi){
            if(_alarm.vendredi == false){
                _alarm.vendredi = true
                imageVendredi.setImageResource(R.drawable.lettrevsurl)
            }
            else{
                _alarm.vendredi = false
                imageVendredi.setImageResource(R.drawable.lettrev)
            }
        }
        else if(jour == imageSamedi){
            if(_alarm.samedi == false){
                _alarm.samedi = true
                imageSamedi.setImageResource(R.drawable.lettressurl)
            }
            else{
                _alarm.samedi = false
                imageSamedi.setImageResource(R.drawable.lettres)
            }
        }
        else if(jour == imageDimanche){
            if(_alarm.dimanche == false){
                _alarm.dimanche = true
                imageDimanche.setImageResource(R.drawable.lettredsurl)
            }
            else{
                _alarm.dimanche = false
                imageDimanche.setImageResource(R.drawable.lettred)
            }
        }

    }

    fun clickValider(bouton:View){

        _alarm.setTime(timeSet.hour.toInt(), timeSet.minute.toInt())
        manager.addAlarmeList(_alarm)
        var mainAct: Intent = Intent(this, MainActivity::class.java)
        startActivity(mainAct)
    }

    fun clickDelete(bouton:View){
        manager.deleteElementBD(_alarm)

        var mainAct: Intent = Intent(this, MainActivity::class.java)
        startActivity(mainAct)
    }
}
