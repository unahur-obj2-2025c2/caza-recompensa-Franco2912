package ar.edu.unahur.obj2.profugos;

public class EntrenamientoElite extends ProfugoDecorable {
    
    public EntrenamientoElite(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Boolean esNervioso() {
        return Boolean.FALSE;
    }


}
