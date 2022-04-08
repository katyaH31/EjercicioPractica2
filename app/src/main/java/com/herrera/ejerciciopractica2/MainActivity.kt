package com.herrera.ejerciciopractica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Data
    private var scoreTeamA = 0
    private var scoreTeamB = 0
    //views
    private lateinit var TeamAScoreTextView: TextView
    private lateinit var TeamBScoreTextView: TextView
    private lateinit var TeamAddButton: Button
    private lateinit var TeamBddButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate")
        bind()
        setupScore(savedInstanceState)
        addListeners()
    }
//almacenar valores mixtos en formato
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    outState.putInt(KEY_SCORE_TEAM_A,scoreTeamA)
    outState.putInt(KEY_SCORE_TEAM_B, scoreTeamB)
    Log.d(TAG,"onSaveInstance")
    }

    //crear funciones de lo que se hara
    private fun addListeners(){
        TeamAddButton.setOnClickListener{//funcion cuando haga click
            scoreTeamA++//cuando haga click este aumenta su  valor
            updateVisualScore(TeamAScoreTextView,scoreTeamA)
        }
        TeamBddButton.setOnClickListener {
            scoreTeamB++
            updateVisualScore(TeamBScoreTextView,scoreTeamB)
        }
    }

    //funcion para cambiar las funciones que reciba los dos parametros
    private fun updateVisualScore(view: TextView, score:Int){
        view.text = score.toString()
    }

    //crear archivo para el score
    private fun setupScore(savedInstanceState: Bundle?) {
        savedInstanceState?.let { bundle ->
            scoreTeamA = bundle.getInt(KEY_SCORE_TEAM_A, 0 )
            scoreTeamB= bundle.getInt(KEY_SCORE_TEAM_B, 0)
        }
        updateVisualScore(TeamAScoreTextView,scoreTeamA)
        updateVisualScore(TeamBScoreTextView,scoreTeamB)
    }

    private fun bind(){ //funcion principal
        //team A
        TeamAScoreTextView = findViewById(R.id.score_textviewA)
        TeamAddButton = findViewById(R.id.add_scoreA)
        //Team B
        TeamBScoreTextView = findViewById(R.id.score_textviewB)
        TeamBddButton = findViewById(R.id.add_scoreB)
    }
/*ciclo de vida */
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }

    companion object{
        val TAG = MainActivity::class.simpleName
        private const val KEY_SCORE_TEAM_A = "ScoreTeamA"
        private const val KEY_SCORE_TEAM_B = "ScoreTeamB"
    }
}