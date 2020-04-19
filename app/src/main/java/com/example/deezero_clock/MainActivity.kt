package com.example.deezero_clock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cell_ring.view.*
import java.sql.Time
import java.time.LocalTime

class MainActivity : AppCompatActivity() {

    var manager = AlarmManager();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager.getListBD()
        theRecycler.layoutManager = LinearLayoutManager(this)

        theRecycler.adapter = ClockListAdapter();
    }

    override fun onRestart() {
        super.onRestart()
        manager.getListBD()
        theRecycler.layoutManager = LinearLayoutManager(this)

        theRecycler.adapter = ClockListAdapter();
    }

    fun clickAdd(Button:View){
        var addAct:Intent = Intent(this, AddActivity::class.java)
        startActivity(addAct)
    }




    inner class ClockListAdapter : RecyclerView.Adapter<ClockListAdapter.ClockCellHolder>() {

        inner class ClockCellHolder(root:View) : RecyclerView.ViewHolder(root) {
            val txt_name_music = root.txt_name_music
            val txt_hour = root.txt_hour
            val switchRing = root.switchRing
            val txt_days = root.txt_days

            init{
                root.setOnClickListener{OncellTouched(adapterPosition)}

            }

            fun displayClock(alarm: Alarme) {
                txt_name_music.text = alarm.name_music;
                txt_hour.text = alarm.getHour().toString() + ":" + alarm.getMinute().toString()
            }

        }
        fun OncellTouched(index : Int){
            var modifAct = Intent(this@MainActivity, ModifyActivity::class.java)
            modifAct.putExtra("keyAlarmList", index)
            startActivity(modifAct)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClockCellHolder {
            Log.i("THIEBAUT", "onCreateViewHolder")
            // 1 creer la vue avec mise en page
            val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_ring, parent, false)

            // 2 créer un holder associé à la vue
            val holder = ClockCellHolder(view)

            // 3 retourner le holder
            return holder
        }

        override fun getItemCount(): Int {
            return manager.listealarmes.size
        }

        override fun onBindViewHolder(holder: ClockCellHolder, position: Int) {
            Log.i("THIEBAUT", "onBindViewHolder $position")

            val alarm = manager.listealarmes[position]
            holder.displayClock(alarm)
        }
    }

}
