package ar.edu.unahur.obj2.cazadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.zonas.Zona;

public abstract class Cazador {
    protected Integer experiencia;
    protected final List<IProfugo> profugosCapturados;

    protected Cazador(Integer experiencia) {
        this.experiencia = experiencia;
        this.profugosCapturados = new ArrayList<>();
    }

    protected Cazador(Integer experiencia, List<IProfugo> profugosCapturados) {
        this.experiencia = experiencia;
        this.profugosCapturados = profugosCapturados;
    }

    public Boolean cazar(IProfugo profugo) {
        return this.experiencia > profugo.getInocencia();
    }

    public void intimidar(IProfugo profugo) {
        profugo.disminuirInocencia();
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public List<IProfugo> getProfugosCapturados() {
        return profugosCapturados;
    }

    public Integer getCantidadDeProfugosCapturados() {
        return profugosCapturados.size();
    }

    public void agregarProfugo(IProfugo profugo) {
        this.profugosCapturados.add(profugo);
    }

    public void eliminarProfugo(IProfugo profugo) {
        this.profugosCapturados.remove(profugo);
    }

    public void capturar(Zona zona) {
        List<IProfugo> intimidados = new ArrayList<>();
        List<IProfugo> profugosEnZona = new ArrayList<>(zona.getProfugos());

        profugosEnZona.stream().forEach(
                profugo -> {
                    if (Boolean.TRUE.equals(this.cazar(profugo))) {
                        profugosCapturados.add(profugo);
                        zona.eliminarProfugo(profugo);
                    } else {
                        this.intimidar(profugo);
                        intimidados.add(profugo);
                    }
                });

        this.incrementarExperiencia(intimidados);
    }

    private void incrementarExperiencia(List<IProfugo> intimidados) {
        Optional<Integer> minimaHabilidad = encontrarMinimaHabilidad(intimidados);
        experiencia += minimaHabilidad.orElse(0) + 2 * profugosCapturados.size();
    }

    private Optional<Integer> encontrarMinimaHabilidad(List<IProfugo> intimidados) {
        return intimidados.stream().map(IProfugo::getHabilidad).min(Comparator.naturalOrder());
    }

}
