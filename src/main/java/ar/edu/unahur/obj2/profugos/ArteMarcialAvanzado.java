package ar.edu.unahur.obj2.profugos;

public class ArteMarcialAvanzado extends ProfugoDecorable {
    
    public ArteMarcialAvanzado(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getHabilidad() {
        return  super.getHabilidad() * 2;
    }

}
