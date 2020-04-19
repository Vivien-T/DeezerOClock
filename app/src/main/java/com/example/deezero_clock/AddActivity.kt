package com.example.deezero_clock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    var _alarm:Alarme = Alarme();
    var manager = AlarmManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        pickRing.setIs24HourView(true)
    }

    fun clickTsJours(btn:View){
        if (chkTsLesJours.isChecked){
            imgLundi.setImageResource(R.drawable.lettrel)
            imgMardi.setImageResource(R.drawable.lettrem)
            imgMercredi.setImageResource(R.drawable.lettrem)
            imgJeudi.setImageResource(R.drawable.lettrej)
            imgVendredi.setImageResource(R.drawable.lettrev)
            imgSamedi.setImageResource(R.drawable.lettres)
            imgDimanche.setImageResource(R.drawable.lettred)

            _alarm.lundi = false
            _alarm.mardi = false
            _alarm.mercredi = false
            _alarm.jeudi = false
            _alarm.vendredi = false
            _alarm.samedi = false
            _alarm.dimanche = false
        }
        else{
            imgLundi.setImageResource(R.drawable.lettrelsurl)
            imgMardi.setImageResource(R.drawable.lettremsurl)
            imgMercredi.setImageResource(R.drawable.lettremsurl)
            imgJeudi.setImageResource(R.drawable.lettrejsurl)
            imgVendredi.setImageResource(R.drawable.lettrevsurl)
            imgSamedi.setImageResource(R.drawable.lettressurl)
            imgDimanche.setImageResource(R.drawable.lettredsurl)

            _alarm.lundi = true
            _alarm.mardi = true
            _alarm.mercredi = true
            _alarm.jeudi = true
            _alarm.vendredi = true
            _alarm.samedi = true
            _alarm.dimanche = true
        }
    }

    fun ClickJour(jour:View){
        chkTsLesJours.isChecked = false

        if(jour == imgLundi){
            if(_alarm.lundi == false){
                _alarm.lundi = true
                imgLundi.setImageResource(R.drawable.lettrelsurl)
            }
            else{
                _alarm.lundi = false
                imgLundi.setImageResource(R.drawable.lettrel)
            }
        }
        else if(jour == imgMardi){
            if(_alarm.mardi == false){
                _alarm.mardi = true
                imgMardi.setImageResource(R.drawable.lettremsurl)
            }
            else{
                _alarm.mardi = false
                imgMardi.setImageResource(R.drawable.lettrem)
            }
        }
        else if(jour == imgMercredi){
            if(_alarm.mercredi == false){
                _alarm.mercredi = true
                imgMercredi.setImageResource(R.drawable.lettremsurl)
            }
            else{
                _alarm.mercredi = false
                imgMercredi.setImageResource(R.drawable.lettrem)
            }
        }
        else if(jour == imgJeudi){
            if(_alarm.jeudi == false){
                _alarm.jeudi = true
                imgJeudi.setImageResource(R.drawable.lettrejsurl)
            }
            else{
                _alarm.jeudi = false
                imgJeudi.setImageResource(R.drawable.lettrej)
            }
        }
        else if(jour == imgVendredi){
            if(_alarm.vendredi == false){
                _alarm.vendredi = true
                imgVendredi.setImageResource(R.drawable.lettrevsurl)
            }
            else{
                _alarm.vendredi = false
                imgVendredi.setImageResource(R.drawable.lettrev)
            }
        }
        else if(jour == imgSamedi){
            if(_alarm.samedi == false){
                _alarm.samedi = true
                imgSamedi.setImageResource(R.drawable.lettressurl)
            }
            else{
                _alarm.samedi = false
                imgSamedi.setImageResource(R.drawable.lettres)
            }
        }
        else if(jour == imgDimanche){
            if(_alarm.dimanche == false){
                _alarm.dimanche = true
                imgDimanche.setImageResource(R.drawable.lettredsurl)
            }
            else{
                _alarm.dimanche = false
                imgDimanche.setImageResource(R.drawable.lettred)
            }
        }

    }


    fun clickValider(bouton:View){

        _alarm.setTime(pickRing.hour, pickRing.minute);
        manager.addAlarmeList(_alarm)
        var mainAct: Intent = Intent(this, MainActivity::class.java)
        startActivity(mainAct)
    }
}
