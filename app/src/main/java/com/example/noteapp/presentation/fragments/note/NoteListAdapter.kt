package com.example.noteapp.presentation.fragments.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.ItemNoteRvBinding
import com.example.noteapp.domain.model.Note

class NoteListAdapter(private val onClick:(position:Int)->Unit,private var onItemLongClick:(Int)->Unit):
    ListAdapter<Note, NoteListAdapter.NoteViewHolder>(NoteDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

  inner  class NoteViewHolder(private val binding: ItemNoteRvBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            with(binding){
                textNote.text = note.text
                noteTitle.text = note.title
            }

        }
      init {
          itemView.setOnLongClickListener {
              onItemLongClick(adapterPosition)
              true
          }
          itemView.setOnClickListener {
              onClick(adapterPosition)
          }
      }

    }

}

class NoteDiffUtil:DiffUtil.ItemCallback<Note>(){
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem

}