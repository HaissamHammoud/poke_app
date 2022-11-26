package br.com.up.pokedex.model

data class Moves(
    val move:NameUrl,
    val version_group_details:List<VersionGroupDetails>
)
