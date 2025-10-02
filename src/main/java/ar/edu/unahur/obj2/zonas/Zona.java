package ar.edu.unahur.obj2.zonas;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.profugos.Profugo;

public class Zona {
    private final String nombre;
    private final Set<Profugo> profugos = new HashSet<>();

    public Zona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Profugo> getProfugos() {
        return profugos;
    }

    public void agregarProfugo(Profugo profugo) {
        this.profugos.add(profugo);
    }

    public void eliminarProfugo(Profugo profugo) {
        this.profugos.remove(profugo);
    }

    public Profugo getProfugo(Profugo profugo) {
        return this.profugos.stream().filter(p -> p.equals(profugo)).findFirst().orElse(null);
    }

}
