package ar.edu.unahur.obj2.reporteria;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.profugos.Profugo;

public class Reporteria {

    private final List<Cazador> cazadores;

    public Reporteria(List<Cazador> cazadores) {
        this.cazadores = new ArrayList<>(cazadores);
    }

    public List<Cazador> getCazadores() {
        return cazadores;
    }

    public void agregarCazador(Cazador cazador){
        this.cazadores.add(cazador);
    }

    public void eliminarCazador(Cazador cazador){
        this.cazadores.remove(cazador);
    }

    public List<Profugo> profugosCaptudados() {
        return cazadores.stream().flatMap(c -> c.getProfugosCapturados().stream()).toList();
    }

    public Integer cantidadDeProfugosCaptudados() {
        return profugosCaptudados().size();
    }

    public Profugo profugoMasHabil(){
        return profugosCaptudados().stream().max((p1, p2) -> p1.getHabilidad().compareTo(p2.getHabilidad())).orElse(null);
    }

    public Cazador cazadorConMasCaptudas(){
        return cazadores.stream().max((c1, c2) -> c1.getCantidadDeProfugosCapturados().compareTo(c2.getCantidadDeProfugosCapturados())).orElse(null);
    }

}
