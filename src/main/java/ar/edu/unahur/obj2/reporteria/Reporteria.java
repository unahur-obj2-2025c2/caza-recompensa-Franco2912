package ar.edu.unahur.obj2.reporteria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.zonas.Zona;

public class Reporteria {

    private final List<Cazador> cazadores;

    public Reporteria() {
        this.cazadores = new ArrayList<>();
    }

    public Reporteria(List<Cazador> cazadores) {
        this.cazadores = cazadores;
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

    public List<IProfugo> profugosCaptudados() {
        return cazadores.stream().flatMap(c -> c.getProfugosCapturados().stream()).toList();
    }

    public Integer cantidadDeProfugosCaptudados() {
        return profugosCaptudados().size();
    }

    public IProfugo profugoMasHabil(){
        return profugosCaptudados().stream().max((Comparator.comparingInt(IProfugo::getHabilidad))).orElse(null);
    }

    public Cazador cazadorConMasCaptudas(){
        return cazadores.stream().max((c1, c2) -> c1.getCantidadDeProfugosCapturados().compareTo(c2.getCantidadDeProfugosCapturados())).orElseThrow(() -> new IllegalStateException("No hay cazadores con profugos capturados"));
    }

    public void procesoCaptura(Cazador cazador, Zona zona) {
        cazador.capturar(zona);
    }

}
