package com.example.gameslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameslist.adapter.GamesAdapter
import com.example.gameslist.databinding.ActivityMainBinding
import com.example.gameslist.listitems.Products
import com.example.gameslist.model.Produto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val gamesAdapter:MutableList<Produto> = mutableListOf()
    private val products = Products()
    private val productsList:MutableList<Produto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        couroutines()

    }

    fun couroutines(){
        CoroutineScope(Dispatchers.IO).launch {
         products.getProduct().collectIndexed { index, value ->
             for (p in value){
                 productsList.add(p)
             }
         }
        }
    }

    private fun initRecycler(){
        val listaGames = binding.rvGames
        listaGames.layoutManager = LinearLayoutManager(applicationContext)
        listaGames.setHasFixedSize(true)
        val adapter = GamesAdapter(this,gamesAdapter)
        listaGames.adapter = adapter

                val game1 = Produto(
                    1,
                    "Overwatch",
                    R.drawable.overwatch,
                    "Overwatch é um jogo de tiro em equipe que conta com um elenco diversificado de heróis poderosíssimos. Viaje pelo mundo, monte uma equipe e dispute objetivos em combates 6v6 de tirar o fôlego.",
                    "R$160,00",
                    "pc/ps4/XboxOne/Switch",
                    "Loja Tamboré/Loja União"
                )
        gamesAdapter.add(game1)
        val game2 = Produto(
            2,
            "Spider-Man",
            R.drawable.spider_man_jogo,
            "Spider-Man é um jogo eletrônico de ação-aventura desenvolvido pela Insomniac Games e publicado pela Sony Interactive Entertainment. É baseado nos personagens, mitologia e adaptações em outras mídias do super-herói de histórias em quadrinhos Homem-Aranha da Marvel Comics, tendo sido lançado exclusivamente para PlayStation 4 em 7 de setembro de 2018. Na história, o criminoso super-humano Senhor Negativo organiza um plano para se vingar do prefeito Norman Osborn e assumir o controle do submundo criminal de Nova Iorque. O Homem-Aranha precisa proteger a cidade assim que o Senhor Negativo ameaça lançar um vírus mortal por toda a área, ao mesmo tempo que é forçado a lidar com seus problemas pessoais como Peter Parker",
            "R$116,90",
            "PS4",
            "Loja Tamboré/Loja União/Loja Iguatemi"
        )
         gamesAdapter.add(game2)
        val game3= Produto(
            3,
            "God of War ",
            R.drawable.god_of_war_capa,
            "É um novo começo para Kratos. Vivendo como um homem longe da sombra dos deuses, ele se aventura pelas selvagens florestas nórdicas com seu filho Atreus, lutando para cumprir uma missão profundamente pessoal. O Santa Monica Studio e o diretor de criação Cory Barlog lançam um novo começo para um dos personagens mais conhecidos dos jogos. Vivendo como um homem, fora da sombra dos deuses, Kratos deve se adaptar a terras desconhecidas, ameaças inesperadas e a uma segunda oportunidade de ser pai. Junto ao seu filho, Atreus, os dois vão se aventurar pelas selvagens florestas nórdicas e lutar para cumprir uma missão profundamente pessoal.",
            "R$69,90",
            "PS4",
            "Loja Tamboré/Loja União"
        )
        gamesAdapter.add(game3)
        val game4= Produto(
            4,
            "Ghost of Tsushima",
            R.drawable.ghost_of_tsushima_capa,
            "No final do século XIII, o império mongol devastou nações inteiras durante sua campanha para conquistar o Oriente. A Ilha de Tsushima é tudo o que está entre o Japão continental e uma enorme frota invasora mongol comandada pelo implacável e sagaz general Khotun Khan. À medida que a ilha queima na esteira da primeira onda do assalto mongol, o guerreiro samurai Jin Sakai mantém-se como um dos último membros sobreviventes de seu clã. Ele está decidido a proteger seu povo e recuperar seu lar, independente do que aconteça, custe o que custar. Será preciso romper com as tradições que o tornaram um guerreiro para forjar um novo caminho do Fantasma e declarar uma guerra incomum pela liberdade de Tsushima.",
            "R$249,00",
            "PS4",
            "Loja Tamboré/Loja Iguatemi"
        )
        gamesAdapter.add(game4)
        val game5= Produto(
            5,
            "Tom Clancy's Splinter Cell: Double Agent",
            R.drawable.splint,
            "Vivencie a tensão incessante e os dilemas da vida de um agente duplo. Minta. Mate. Prejudique. Traia. Tudo para proteger os inocentes. Até onde você iria para ganhar a confiança do inimigo? Como o agente secreto Sam Fisher, você deve se infiltrar num grupo terrorista cruel e destruí-lo internamente. Você precisará ponderar muito bem as consequências dos seus atos. Mate terroristas demais e estragará seu disfarce. Hesite e milhões morrerão. Faça o que for preciso para completar a missão, mas procure sobreviver.",
            "R$36,00",
            "Xbox/PS2/PS3/PC",
            "Loja Tamboré/Loja Iguatemi"
        )
        gamesAdapter.add(game5)
        val game6= Produto(
            6,
            "God of War 3",
            R.drawable.god_of_war3,
            "Kratos está devolta, ainda com a vingança pulsando forte em suas veias. O Olimpo e seus deuses é o seu alvo, não importa o preço que o Deus da Guerra irá pagar. Neste terceiro e épico capítulo você irá controlar Kratos através de batalhas celestiais contra os deuses mais poderosos de todo o Olimpo – inclusive voltará ao inferno e acertar as contas com seu pai colossal e poderoso, Kronos. Deuses como Hermes e Hades não serão páreo para seu poder, os olhos ardentes daquele que busca vingança que nem a mais cruel das mortes pode deter. Enfrente desafios arrasadores e enfrente monstros poderosos como a Quimera, o Cérberus e muitos outros seres místicos que estão ali apenas para acabar com sua existência. Não pare por nada até enfrentar o deus dos deuses: Zeus, e acabar com isso de uma vez por todas",
            "R$50,00",
            "PS3/PS4",
            "Loja Tamboré/Loja Iguatemi"
        )
        gamesAdapter.add(game6)
        val game7= Produto(
            7,
            "Watch Dogs",
            R.drawable.watch_dogs,
            "Junte-se ao Dedsec, um grupo notório de hackers, para executar o maior hack da história; Derrube o ctOS 2.0, um sistema operacional invasivo que está sendo usado por um gênio do crime para monitorar e manipular os cidadãos em uma escala massiva.",
            "R$60,00",
            "PS4/PC/XboxOne",
            "Loja Tamboré/Loja União"
        )
        gamesAdapter.add(game7)
        val game8= Produto(
            8,
            "Batman Arkham City",
            R.drawable.batman_arkham_city_,
            "Batman: Arkham City é um jogo eletrônico de Ação-Aventura e Stealth, baseado na série de quadrinhos Batman da DC Comics. O jogo é distribuído para: PlayStation 3, Xbox 360 e Microsoft Windows. Foi desenvolvido pela Rocksteady Studios e foi publicado pela Warner Bros. Interactive Entertainment e DC Entertainment.",
            "R$31,00",
            "PC/Xbox/WiiU",
            "Loja Tamboré/Loja União/Loja Iguatemi"
        )
        gamesAdapter.add(game8)
    }
}