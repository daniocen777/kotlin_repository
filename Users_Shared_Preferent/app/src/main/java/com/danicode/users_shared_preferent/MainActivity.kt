package com.danicode.users_shared_preferent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danicode.users_shared_preferent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Variables para mostrar el listado (UserAdapter)
    // instancia del adapter
    private lateinit var userAdapter: UserAdapter

    // linear una sola columna
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    // binding para vincular vista del recycleView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Adaptador
        userAdapter = UserAdapter(getUsers())
        linearLayoutManager = LinearLayoutManager(this)
        // Recycle
        binding.recycleView.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    // Llenar datos
    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()
        val danicode = User(1, "Danicode", "Ochoa", "")
        val lola = User(1, "Lola", "Peña", "")
        val juana = User(1, "Juana", "Ortega", "")
        val pepe = User(1, "Pepe", "Ulloa", "")
        val carola = User(1, "Carola", "Rengifo", "")
        users.add(danicode)
        users.add(lola)
        users.add(juana)
        users.add(pepe)
        users.add(carola)

        return users;
    }
}