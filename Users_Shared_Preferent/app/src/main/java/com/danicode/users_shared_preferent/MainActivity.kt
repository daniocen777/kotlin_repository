package com.danicode.users_shared_preferent

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danicode.users_shared_preferent.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

// Implementar la interface IOnClickListener VIDEO 19
class MainActivity : AppCompatActivity(), IOnClickListener {
    // Variables para mostrar el listado (UserAdapter)
    // instancia del adapter
    private lateinit var userAdapter: UserAdapter

    // linear una sola columna
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    // binding para vincular vista del recycleView
    // no suple por completo al findViewById (caso de los dialogos)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Preferences
        val preferences = getPreferences(MODE_PRIVATE)
        // sp => SharedPreference
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        // Insertar un dato
        if (isFirstTime) {
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_confirm) { _, _ ->
                    val username =
                        dialogView.findViewById<TextInputEditText>(R.id.etUsername).text.toString()
                    with(preferences.edit()) {
                        putBoolean(getString(R.string.sp_first_time), false)
                        putString(getString(R.string.sp_username), username)
                            .apply()
                    }
                    Toast.makeText(this, R.string.register_success, Toast.LENGTH_SHORT).show()
                }
                .show()

        } else {
            val username =
                preferences.getString(
                    getString(R.string.sp_username),
                    getString(R.string.hint_username)
                )
            Toast.makeText(this, "Bienvenido $username", Toast.LENGTH_SHORT).show()
        }
        // Adaptador
        // this => Hace referencia a la implementacion (onClick)
        userAdapter = UserAdapter(getUsers(), this)
        linearLayoutManager = LinearLayoutManager(this)
        // Recycle
        // setHasFixedSize(true) => se indica que la vista tiene un tamaño definido (56dp)
        binding.recycleView.apply {
            setHasFixedSize(true) // para optimizar
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    // Llenar datos
    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()
        val danicode = User(
            1,
            "Danicode",
            "Ochoa",
            "https://frogames.es/wp-content/uploads/2020/09/alain-1.jpg"
        )
        val lola = User(
            2,
            "Lola",
            "Peña",
            "https://upload.wikimedia.org/wikipedia/commons/b/b2/Samanta_villar.jpg"
        )
        val juana = User(
            3,
            "Juana",
            "Ortega",
            "https://live.staticflickr.com/974/42098804942_b9ce35b1c8_b.jpg"
        )
        val pepe = User(
            4,
            "Pepe",
            "Ulloa",
            "https://upload.wikimedia.org/wikipedia/commons/d/d9/Emma_Wortelboer_%282018%29.jpg"
        )
        val carola = User(
            5,
            "Carola",
            "Rengifo",
            "https://frogames.es/wp-content/uploads/2020/09/alain-1.jpg"
        )

        users.add(danicode)
        users.add(lola)
        users.add(juana)
        users.add(pepe)
        users.add(carola)
        users.add(danicode)
        users.add(lola)
        users.add(juana)
        users.add(pepe)
        users.add(carola)
        users.add(danicode)
        users.add(lola)
        users.add(pepe)
        users.add(juana)
        users.add(danicode)
        users.add(lola)
        users.add(juana)
        users.add(pepe)
        users.add(carola)
        users.add(danicode)
        users.add(lola)
        users.add(juana)
        users.add(pepe)
        users.add(carola)

        return users
    }

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position: ${user.getFullName()}", Toast.LENGTH_SHORT).show()
    }
}