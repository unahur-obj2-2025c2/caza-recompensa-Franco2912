package ar.edu.unahur.obj2.profugos;

public class Profugo implements IProfugo{
    protected Integer nivelDeInocencia;
    protected Integer nivelDeHabilidad;
    protected Boolean esNervioso;
    
    public Profugo(Integer nivelDeInocencia, Integer nivelDeHabilidad, Boolean esNervioso) {
        if (nivelDeHabilidad <= 0 || nivelDeHabilidad > 100)
            throw new IllegalArgumentException("La habilidad es un valor entre 1 y 100");
        this.nivelDeInocencia = nivelDeInocencia;
        this.nivelDeHabilidad = nivelDeHabilidad;
        this.esNervioso = esNervioso;
    }

    @Override
    public Integer getInocencia() {
        return nivelDeInocencia;
    }

    @Override
    public Integer getHabilidad() {
        return nivelDeHabilidad;
    }

    @Override
    public Boolean esNervioso() {
        return esNervioso;
    }

    @Override
    public void volverseNervioso() {
        esNervioso = Boolean.TRUE;
    }

    @Override
    public void dejarDeEstarNervioso() {
        esNervioso = Boolean.FALSE;
    }

    @Override
    public void reducirHabilidad() {
        nivelDeHabilidad = Math.max(0, nivelDeHabilidad - 5);
    }

    @Override
    public void disminuirInocencia() {
        nivelDeInocencia = Math.max(0, nivelDeInocencia - 2);
    }
}
