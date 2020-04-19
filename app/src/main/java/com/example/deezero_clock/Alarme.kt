package com.example.deezero_clock

import android.os.Parcelable
import android.view.View
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Alarme():RealmObject(){
    var lundi = false
    var mardi = false
    var mercredi = false
    var jeudi = false
    var vendredi = false
    var samedi = false
    var dimanche = false

    private var _hour:Int = 0
    private var _minutes:Int=0
    private var _Active = true



    var name_music:String = "Dragostea Din Tei"



    fun changeActive(){

    }

    fun isActive() : Boolean{
        return _Active
    }

    fun getHour():Int{
        return _hour;
    }

    fun getMinute():Int{
        return _minutes
    }


    fun setTime(heure:Int,minutes:Int){
        if(heure < 0 || heure > 24){
        }
        else if(minutes < 0 || minutes > 60){
        }
        else{
            _hour = heure
            _minutes = minutes
        }
    }

    fun chkEvryday(){
        //var compteur = 0
        //for( jours in listeJours){
            //listeJours[compteur] = true
            //compteur++
        //}
        lundi = true
        mardi = true
        mercredi = true
        jeudi = true
        vendredi = true
        samedi = true
        dimanche = true
    }

    fun setActive(){
        if(_Active == false){
            _Active = true
        }
        else{
            _Active = false
        }
    }
}