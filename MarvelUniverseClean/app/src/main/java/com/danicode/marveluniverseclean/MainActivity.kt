package com.danicode.marveluniverseclean

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danicode.marveluniverseclean.databinding.ActivityMainBinding
import com.danicode.marveluniverseclean.domain.model.Character
import com.danicode.marveluniverseclean.ui.charactersList.CharactersListState
import com.danicode.marveluniverseclean.ui.charactersList.CharactersViewModel
import com.danicode.marveluniverseclean.ui.charactersList.adapter.CharactersListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private lateinit var charactersListAdapter: CharactersListAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var rvCharacters: RecyclerView

    private val charactersViewModel by viewModels<CharactersViewModel>()

    var flag = 3
    var paginated = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        charactersViewModel.getCharacters()
        initUI()
        // initListeners()
        // charactersViewModel.getAllCharacters(offset = 1)

    }

    private fun initUI() {
        rvCharacters = mBinding.rvCharacters
        gridLayoutManager = GridLayoutManager(this, 2)

        charactersListAdapter = CharactersListAdapter()
        with(rvCharacters) {
            layoutManager = gridLayoutManager
            adapter = charactersListAdapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                charactersViewModel.state.collect {
                    when (it) {
                        is CharactersListState.Error -> {
                            mBinding.pbCharacters.isVisible = false
                            mBinding.tvTitle.text = it.error
                        }
                        CharactersListState.Loading -> {
                            mBinding.pbCharacters.isVisible = true
                        }
                        is CharactersListState.Success -> {
                            mBinding.pbCharacters.isVisible = false
                            charactersListAdapter.setData(it.characters)
                        }
                    }
                }
            }
        }
    }

    private fun initListeners() {
        Log.i("initListeners", "ENTRA AL initListeners")
        rvCharacters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (gridLayoutManager.findLastVisibleItemPosition() == gridLayoutManager.itemCount - 1) {
                    paginated += 20
                    // charactersViewModel.getAllCharacters(paginated)

                }
            }
        })
    }


}