package ar.edu.unahur.obj2.profugos;

public class EntrenamientoElite extends ProfugoDecorable {
    
    public EntrenamientoElite(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer doGetHabilidad() {
        return 1;
    }

    @Override
    public Boolean doGetNervioso() {
        return Boolean.FALSE;
    }

    @Override
    public Integer doGetInocencia(){
        return profugo.getInocencia();
    }

}
