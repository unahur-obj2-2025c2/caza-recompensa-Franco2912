package ar.edu.unahur.obj2.profugos;

public class ProteccionLegal extends ProfugoDecorable {
    
    public ProteccionLegal(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer doGetHabilidad() {
        return 1;
    }

    @Override
    public Boolean doGetNervioso() {
        return profugo.esNervioso();
    }

    @Override
    public Integer doGetInocencia(){
        return 40;
    }
}
