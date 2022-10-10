package com.example.noteapp.presentation.fragments.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.ItemNoteRvBinding
import com.example.noteapp.domain.model.Note


class NoteAdapter(private val onClick:(position:Int)->Unit) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var list = arrayListOf<Note>()

    var onItemLongClick:((Int)->Unit)?=null


    inner class ViewHolder(private var binding: ItemNoteRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnLongClickListener {
                onItemLongClick?.invoke(position)
                true
            }
        }

        fun bind(note: Note) {
            with(binding){
                textNote.text = note.text
                noteTitle.text = note.title
            }

            itemView.setOnClickListener {
                onClick(position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItem(note: Unit) {
        list.add(note)
        notifyItemInserted(0)

    }

    fun addItems(list: List<Note>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun removeItems(list: List<Note>) {
        this.list.removeAll(list)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addList(list: List<Note>) {
        this.list = list as ArrayList<Note>
        this.list.reverse()
        notifyDataSetChanged()
    }

    fun getItem(pos: Int): Note {
        return list[pos]
    }

    fun replaceItem(note: Note, position: Int) {
        list.set(position, note)
        notifyItemChanged(position)
    }



}


