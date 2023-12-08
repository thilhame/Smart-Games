package com.example.gameslist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameslist.DetailsGame
import com.example.gameslist.R
import com.example.gameslist.model.Produto
import com.example.gameslist.databinding.ListajogosBinding
import com.squareup.picasso.Picasso

class GamesAdapter(
    private val context: Context,
    private val produtos: MutableList<Produto>
) : RecyclerView.Adapter<GamesAdapter.ProdutoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val binding = ListajogosBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProdutoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.img.setBackgroundResource(produtos[position].foto)
        holder.name.text = produtos[position].nome
        holder.price.text = produtos[position].preco
        //holder.description.text = produtos[position].descricao

        //Evento de click
        holder.description.setOnClickListener{
            val intent = Intent(context,DetailsGame::class.java)
            intent.putExtra("imgGame", produtos[position].foto)
            intent.putExtra("name",produtos[position].nome)
            intent.putExtra("price",produtos[position].preco)
            intent.putExtra("description",produtos[position].descricao)
            context.startActivity(intent)
        }


    }

    override fun getItemCount()=produtos.size

    inner class ProdutoViewHolder( binding: ListajogosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name = binding.nameGame
        val img = binding.imageView
        val price = binding.gamePrice
        val description = binding.descriptionGame
}}
