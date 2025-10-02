package ar.edu.unahur.obj2.profugos;

public class ArteMarcialAvanzado extends ProfugoDecorable {
    
    public ArteMarcialAvanzado(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer doGetHabilidad() {
        return 2;
    }

    @Override
    public Boolean doGetNervioso() {
        return profugo.esNervioso();
    }

    @Override
    public Integer doGetInocencia(){
        return profugo.getInocencia();
    }

}
