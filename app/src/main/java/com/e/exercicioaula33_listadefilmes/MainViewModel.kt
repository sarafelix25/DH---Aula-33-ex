package com.e.exercicioaula33_listadefilmes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import kotlin.math.log

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //contexto para poder acessar o assets e o arquivo json dentro dele
    private val context = getApplication<Application>().applicationContext

    //função que vai ler o json e devolver um mutable liste de filmes
    fun getFilmes(): MutableList<Filme> {

        var listaDeFilmes: MutableList<Filme> = mutableListOf()

        //sempre usar try/catch
        try {

            //variavel que atreves do context acessa o assets, abre o json,
            // guarda espaço na memória pra poder ler, e depois transforma cada linha em string
            val jsonString = context.assets.open("filmes.json")
                .bufferedReader().use { it.readText() }


            //aqui dizemos que a listaDeFilmes vai usar o Gson para transformar o jsonString em uma MutableList<Filme>
            listaDeFilmes =
                Gson().fromJson(jsonString, object : TypeToken<MutableList<Filme>>() {}.type)

            return listaDeFilmes


        } catch (ioException: IOException) {
            Log.i("MainViewModel", ioException.toString())
            //lista vai retornar vazia se não tiver entrado no try
            return listaDeFilmes

        }


    }


}