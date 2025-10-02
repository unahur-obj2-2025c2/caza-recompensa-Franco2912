package ar.edu.unahur.obj2.cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zonas.Zona;

public abstract class Cazador {
    protected Integer experiencia;
    protected final Zona zona;
    protected final List<Profugo> profugosCapturados = new ArrayList<>();

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

    public List<Profugo> getProfugosCapturados() {
        return profugosCapturados;
    }

    public Integer getCantidadDeProfugosCapturados() {
        return profugosCapturados.size();
    }

    public void agregarProfugo(Profugo profugo) {
        this.profugosCapturados.add(profugo);
    }

    public void eliminarProfugo(Profugo profugo) {
        this.profugosCapturados.remove(profugo);
    }

    public void capturar() {
        final List<Profugo> profugosEnZona = zona.getProfugos();

        // Collect profugos to be captured in a separate list to avoid concurrent modification
        List<Profugo> capturables = new ArrayList<>();
        profugosEnZona.stream().filter(this::cazar).forEach(capturables::add);

        capturables.forEach(p -> {
            this.agregarProfugo(p);
            this.zona.eliminarProfugo(p);
        });

        profugosEnZona.stream().filter(p -> !this.cazar(p)).forEach(this::intimidar);
        experiencia += incrementarExperiencia();
    }

    private Integer incrementarExperiencia() {
        return zona.getProfugos().stream().mapToInt(p -> p.getHabilidad()).min().orElse(0) + profugosCapturados.size() * 2;
    }

}
