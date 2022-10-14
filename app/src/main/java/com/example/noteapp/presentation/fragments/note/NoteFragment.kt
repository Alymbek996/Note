package com.example.noteapp.presentation.fragments.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.noteapp.databinding.NoteFragmentBinding
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.UIState
import com.example.noteapp.presentation.acitvities.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class NoteFragment : Fragment() {
    private lateinit var binding: NoteFragmentBinding
    private var note: Note?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = NoteFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        note = arguments?.getSerializable("note") as Note?

        note?.let {
            binding.edTitle.setText(it.title)
            binding.EdText.setText(it.text)
        }
        binding.btnSave.setOnClickListener{
            save()
        }
    }

    private fun save() {
        val text = binding.EdText.text.toString().trim()
        val title = binding.edTitle.text.toString().trim()
        val bundle = Bundle()

        if (note == null) {
            note = Note(0,title,text)
        }else {
            note?.text = text
            note?.title = title
        }
        bundle.putSerializable("note", note)
        parentFragmentManager.setFragmentResult("note", bundle)
        findNavController().navigateUp()
    }
}