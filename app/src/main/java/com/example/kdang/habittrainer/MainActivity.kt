package com.example.kdang.habittrainer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        iv_icon.setImageResource(R.drawable.restingfrog)
//        tv_title.text = getString(R.string.drink_water)
//        tv_description.text = getString(R.string.drink_water_desc)
        // Adapter -> define data
        rv.setHasFixedSize(true)

        rv.layoutManager = LinearLayoutManager(this)
//        rv.adapter = HabitsAdapter(getSampleHabits())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add_habit) {
            switchToActivity(CreateHabitActivity::class.java)
        }
        return true
    }

    private fun switchToActivity(c: Class<*>) {
        val intent = Intent(this, c)
        startActivity(intent)
    }
}
