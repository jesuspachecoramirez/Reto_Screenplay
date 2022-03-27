package co.com.sofka.Models.pokeapi;
import java.util.ArrayList;
import java.util.List;

public class PokemonTypes {
    private DamageRelations damageRelations;
    private List<GameIndex> gameIndices = new ArrayList<GameIndex>();
    private Generation__1 generation;
    private Integer id;
    private MoveDamageClass moveDamageClass;
    private List<Move> moves = new ArrayList<Move>();
    private String name;
    private List<Name> names = new ArrayList<Name>();
    private List<Object> pastDamageRelations = new ArrayList<Object>();
    private List<Pokemon> pokemon = new ArrayList<Pokemon>();

    public DamageRelations getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(DamageRelations damageRelations) {
        this.damageRelations = damageRelations;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public Generation__1 getGeneration() {
        return generation;
    }

    public void setGeneration(Generation__1 generation) {
        this.generation = generation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MoveDamageClass getMoveDamageClass() {
        return moveDamageClass;
    }

    public void setMoveDamageClass(MoveDamageClass moveDamageClass) {
        this.moveDamageClass = moveDamageClass;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<Object> getPastDamageRelations() {
        return pastDamageRelations;
    }

    public void setPastDamageRelations(List<Object> pastDamageRelations) {
        this.pastDamageRelations = pastDamageRelations;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

}
