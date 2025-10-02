package ar.edu.unahur.obj2.profugos;

public abstract class ProfugoDecorable implements IProfugo {

    protected IProfugo profugo;

    protected ProfugoDecorable(IProfugo profugo) {
        this.profugo = profugo;
    }

    // temple method

    @Override
    public void volverseNervioso() {
        profugo.volverseNervioso();
    }

    @Override
    public void dejarDeEstarNervioso() {
        profugo.dejarDeEstarNervioso();
    }

    @Override
    public void reducirHabilidad() {
        profugo.reducirHabilidad();
    }

    @Override
    public void disminuirInocencia() {
        profugo.disminuirInocencia();
    }

    @Override
    public Integer getInocencia() {
        return this.doGetInocencia();
    }

    @Override
    public Integer getHabilidad() {
        return profugo.getHabilidad() * doGetHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        return this.doGetNervioso();
    }

    public abstract Integer doGetHabilidad();

    public abstract Boolean doGetNervioso();

    public abstract Integer doGetInocencia();
    
}
