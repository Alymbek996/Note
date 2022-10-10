package com.example.noteapp.presentation.acitvities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        viewModel.getAllNotes()
//
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED){
//                viewModel.getNoteAllState.collect{
//                    when(it){
//                        is UIState.Loading->{
//                            //progressbar
//                            binding.progressBar.isVisible = true
//                        }
//                        is UIState.Error->{
//                            Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
//                        }
//                        is UIState.Success->{
//                            binding.tvNotes.text = it.data.toString()
//                            binding.progressBar.isVisible = false
//                        }
//                    }
//                }
//            }
//        }
//        var i = 0
//        binding.btnNotes.setOnClickListener{
//            ++i
//            viewModel.createNote(Note(title = i.toString(), text = i.toString()))
//            lifecycleScope.launch {
//                repeatOnLifecycle(Lifecycle.State.STARTED){
//                    viewModel.createNoteState.collect{
//                        when(it){
//                            is UIState.Loading->{
//                                //progressbar
//                            }
//                            is UIState.Error->{
//                                Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
//                            }
//                            is UIState.Success->{
//                                viewModel.getAllNotes()
//                            }
//                        }
//                    }
//                }
//
//            }
//        }
//        binding.btnDelete.setOnClickListener{
//
//            viewModel.deleteNote(Note(title = i.toString(), text = i.toString()))
//            lifecycleScope.launch {
//                repeatOnLifecycle(Lifecycle.State.STARTED){
//                    viewModel.deleteNoteState.collect{
//                        when(it){
//                            is UIState.Loading->{
//                                //progressbar
//                            }
//                            is UIState.Error->{
//                                Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_SHORT).show()
//                            }
//                            is UIState.Success->{
//                                viewModel.getAllNotes()
//                            }
//                        }
//                    }
//                }
//
//            }
//        }

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}