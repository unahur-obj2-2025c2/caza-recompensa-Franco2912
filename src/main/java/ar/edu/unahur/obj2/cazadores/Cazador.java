package ar.edu.unahur.obj2.cazadores;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zonas.Zona;

public abstract class Cazador {
    protected Integer experiencia;
    protected final Zona zona;
    protected final Set<Profugo> profugosCapturados = new HashSet<>();

    protected Cazador(Integer experiencia, Zona zona) {
        this.experiencia = experiencia;
        this.zona = zona;
    }

    public Boolean cazar(Profugo profugo) {
        return this.experiencia > zona.getProfugo(profugo).getInocencia();
    }

    public void intimidar(Profugo profugo) {
        profugo.disminuirInocencia();
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public Set<Profugo> getProfugosCapturados() {
        return profugosCapturados;
    }

    public void agregarProfugo(Profugo profugo) {
        this.profugosCapturados.add(profugo);
    }

    public void eliminarProfugo(Profugo profugo) {
        this.profugosCapturados.remove(profugo);
    }

    public void capturar(Profugo profugo) {
        if (Boolean.TRUE.equals(this.cazar(profugo))) {
            this.experiencia = this.incrementarExperiencia();
            this.agregarProfugo(profugo);
            this.zona.eliminarProfugo(profugo);
        } else {
            this.intimidar(profugo);
        }
    }

    private Integer incrementarExperiencia() {
        return profugosCapturados.stream().mapToInt(p -> p.getHabilidad()).min().orElse(0) + profugosCapturados.size() * 2;
    }
}
