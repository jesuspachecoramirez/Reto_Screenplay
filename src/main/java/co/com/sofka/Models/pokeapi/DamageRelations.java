package co.com.sofka.Models.pokeapi;
import java.util.ArrayList;
import java.util.List;

public class DamageRelations {
    private List<DoubleDamageFrom> doubleDamageFrom = new ArrayList<DoubleDamageFrom>();
    private List<DoubleDamageTo> doubleDamageTo = new ArrayList<DoubleDamageTo>();
    private List<HalfDamageFrom> halfDamageFrom = new ArrayList<HalfDamageFrom>();
    private List<HalfDamageTo> halfDamageTo = new ArrayList<HalfDamageTo>();
    private List<Object> noDamageFrom = new ArrayList<Object>();
    private List<Object> noDamageTo = new ArrayList<Object>();

    public List<DoubleDamageFrom> getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    public void setDoubleDamageFrom(List<DoubleDamageFrom> doubleDamageFrom) {
        this.doubleDamageFrom = doubleDamageFrom;
    }

    public List<DoubleDamageTo> getDoubleDamageTo() {
        return doubleDamageTo;
    }

    public void setDoubleDamageTo(List<DoubleDamageTo> doubleDamageTo) {
        this.doubleDamageTo = doubleDamageTo;
    }

    public List<HalfDamageFrom> getHalfDamageFrom() {
        return halfDamageFrom;
    }

    public void setHalfDamageFrom(List<HalfDamageFrom> halfDamageFrom) {
        this.halfDamageFrom = halfDamageFrom;
    }

    public List<HalfDamageTo> getHalfDamageTo() {
        return halfDamageTo;
    }

    public void setHalfDamageTo(List<HalfDamageTo> halfDamageTo) {
        this.halfDamageTo = halfDamageTo;
    }

    public List<Object> getNoDamageFrom() {
        return noDamageFrom;
    }

    public void setNoDamageFrom(List<Object> noDamageFrom) {
        this.noDamageFrom = noDamageFrom;
    }

    public List<Object> getNoDamageTo() {
        return noDamageTo;
    }

    public void setNoDamageTo(List<Object> noDamageTo) {
        this.noDamageTo = noDamageTo;
    }
}
