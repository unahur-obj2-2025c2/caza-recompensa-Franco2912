package ar.edu.unahur.obj2.zonas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class Zona {
    private final String nombre;
    private final List<IProfugo> profugos;

    public Zona(String nombre) {
        this.nombre = nombre;
        this.profugos = new ArrayList<>();
    }

    public Zona(String nombre, List<IProfugo> profugos) {
        this.nombre = nombre;
        this.profugos = profugos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<IProfugo> getProfugos() {
        return profugos;
    }

    public Integer getCantidadProfugos() {
        return profugos.size();
    }

    public void agregarProfugo(IProfugo profugo) {
        this.profugos.add(profugo);
    }

    public void eliminarProfugo(IProfugo profugo) {
        this.profugos.remove(profugo);
    }

    public IProfugo getProfugo(IProfugo profugo) {
        return this.profugos.stream().filter(p -> p.equals(profugo)).findFirst().orElse(null);
    }

    public void vaciarProfugos() {
        profugos.clear();
    }

}
