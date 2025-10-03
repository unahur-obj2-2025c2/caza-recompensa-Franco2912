package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class CazadorSigiloso extends Cazador{

    public CazadorSigiloso(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean cazar(IProfugo profugo) {
        return super.cazar(profugo) && profugo.getHabilidad() < 50;
    }

    @Override
    public void intimidar(IProfugo profugo) {
        super.intimidar(profugo);
        profugo.reducirHabilidad();
    }
}
