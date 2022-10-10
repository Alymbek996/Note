package com.example.noteapp.presentation.fragments.home

import android.os.Bundle
import android.util.Log
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
import com.example.noteapp.R
import com.example.noteapp.databinding.HomeFragmentBinding
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.UIState
import com.example.noteapp.presentation.acitvities.MainViewModel
import com.example.noteapp.presentation.fragments.note.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var noteAdapter:NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = HomeFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        noteAdapter = NoteAdapter {
            val note = noteAdapter.getItem(it)
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()

        parentFragmentManager.setFragmentResultListener(
            "note",
            viewLifecycleOwner
        ) { requestKey, bundle ->

            val note = bundle.getSerializable("note") as Note

            Log.e("notee", "text :${note.text } title: ${note.title}")

            viewModel.getAllNotes()

          viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getNoteAllState.collect{
                    when(it){
                        is UIState.Loading->{
                            //progressbar
                         //   binding.progressBar.isVisible = true
                        }
                        is UIState.Error->{
                            Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success->{
                            noteAdapter.addItems(it.data)
                        }
                    }
                    viewModel.createNote(Note(title = note.title, text = note.text))
                    lifecycleScope.launch {
                        repeatOnLifecycle(Lifecycle.State.STARTED){
                            viewModel.createNoteState.collect{
                                when(it){
                                    is UIState.Loading->{
                                        //progressbar
                                    }
                                    is UIState.Error->{
                                        Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                                    }
                                    is UIState.Success->{
                                        viewModel.getAllNotes()
                                    }
                                }
                            }
                        }

                    }

                }
                }

            }
        }
        binding.recyclerView.adapter = noteAdapter

    }

    private fun initListener() {
        binding.FloatBtn.setOnClickListener{
            findNavController().navigate(R.id.noteFragment)
        }
    }


}