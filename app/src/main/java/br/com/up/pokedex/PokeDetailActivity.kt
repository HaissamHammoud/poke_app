package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.up.pokedex.network.Api
import com.squareup.picasso.Picasso

class PokeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)


        val LayoutName: TextView = findViewById(R.id.PokemonDetailsName)
        val LayoutImage : ImageView = findViewById(R.id.PokemonDetailsImage)
        val LayoutTypes : TextView = findViewById(R.id.PokemonDetailsTypes)
        val LayoutStats : TextView = findViewById(R.id.PokemonDetailsStats)
        val LayoutSkills : TextView = findViewById(R.id.PokemonDetailsSkills)
        val LayoutMoves : TextView = findViewById(R.id.PokemonDetailsMoves)

        var name = ""
        var stats = ""
        var abilidades = ""
        var moves = ""
        var types = ""


        val id = intent.getStringExtra("id")
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png").into(LayoutImage)

        Api().getDetailsById((id.toString())){ details ->
            name = details!!.name
            details.stats.forEach { stats = stats + it.stat.name + " " + it.base_stat + "\n" }
            details.abilities.forEach { abilidades = abilidades + it.ability.name + " " }
            details.moves.forEach { moves = moves + it.move.name + " " }
            details.types.forEach { types = types + it.type.name + " " }

            LayoutName.text = name
            LayoutTypes.text = types
            LayoutMoves.text = moves
            LayoutSkills.text = abilidades
            LayoutStats.text = stats
        }

    }
}