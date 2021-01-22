package com.e.exercicioaula33_listadefilmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //instanciando a MainViewModel
    private val viewModel: MainViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaFilmes: MutableList<Filme> = viewModel.getFilmes()
        val adapterFilmes = ListaFilmesAdapter(listaFilmes)



        //configurando o recycler view
        rv_main.adapter = adapterFilmes
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.setHasFixedSize(true)


    }
}