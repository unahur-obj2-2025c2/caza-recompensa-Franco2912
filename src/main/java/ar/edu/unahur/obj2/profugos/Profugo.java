package ar.edu.unahur.obj2.profugos;

public class Profugo implements IProfugo{
    private Integer nivelDeInocencia;
    private Integer nivelDeHabilidad;
    private Boolean esNervioso;
    
    public Profugo(Integer nivelDeInocencia, Integer nivelDeHabilidad, Boolean esNervioso) {
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
