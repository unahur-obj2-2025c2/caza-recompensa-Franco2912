package ar.edu.unahur.obj2.profugos;

public class ProteccionLegal extends ProfugoDecorable {
    
    public ProteccionLegal(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getInocencia(){
        return Math.max(profugo.getInocencia(), 40);
    }
}
