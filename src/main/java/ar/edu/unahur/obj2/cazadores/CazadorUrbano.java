package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class CazadorUrbano extends Cazador{

    public CazadorUrbano(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean cazar(IProfugo profugo) {
        return super.cazar(profugo) && !profugo.esNervioso();
    }

    @Override
    public void intimidar(IProfugo profugo) {
        super.intimidar(profugo);
        profugo.dejarDeEstarNervioso();
    }
}
