package com.example.deezero_clock

import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.kotlin.where

class AlarmManager(){
    var listealarmes  = mutableListOf<Alarme>()



    fun addAlarmeList(lAlarme:Alarme){
        listealarmes.add(lAlarme)
        pushListBD()
    }

    fun pushListBD(){
        var realm : Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        for(alarme : Alarme in listealarmes){
            realm.copyToRealm(alarme)
        }
        realm.commitTransaction()
    }

    fun getListBD(){
        var realm : Realm = Realm.getDefaultInstance()
        for(alarme:Alarme in listealarmes){
            listealarmes.remove(alarme)
        }
        var test : RealmResults<Alarme> = realm.where<Alarme>().findAll()
        for(alert:Alarme in test){
            listealarmes.add(alert)
        }
    }

    fun deleteElementBD(thealarme: Alarme){
        var realm :Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        thealarme.deleteFromRealm()
        realm.commitTransaction()
        getListBD()
    }

    fun getElementBD(thealarme : Alarme):Alarme{
        var realm :Realm = Realm.getDefaultInstance()

        var test : RealmResults<Alarme> = realm.where<Alarme>().findAll()

        for(alert:Alarme in test){
            if(alert == thealarme){
                return alert
            }
        }
        return thealarme
    }
}