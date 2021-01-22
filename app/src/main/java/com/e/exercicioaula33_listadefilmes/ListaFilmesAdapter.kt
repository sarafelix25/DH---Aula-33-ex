package com.e.exercicioaula33_listadefilmes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_filme.view.*

class ListaFilmesAdapter(private val listFilmes: MutableList<Filme>) :
    RecyclerView.Adapter<ListaFilmesAdapter.FilmesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
        return FilmesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        val filme = listFilmes[position]

        holder.tituloFilme.text = filme.titulo
        holder.dataFilme.text = filme.data
        holder.descricaoFilme.text = filme.descricao
        holder.direcaoFilme.text = filme.direcao

    }

    override fun getItemCount() = listFilmes.size


    class FilmesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tituloFilme: TextView = itemView.tv_item_titulo_filme
        val dataFilme: TextView = itemView.tv_item_data
        val descricaoFilme: TextView = itemView.tv_item_descricao
        val direcaoFilme: TextView = itemView.tv_item_direcao


    }

}