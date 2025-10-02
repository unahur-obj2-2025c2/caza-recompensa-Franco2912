package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zonas.Zona;

public class CazadorUrbano extends Cazador{

    public CazadorUrbano(Integer experiencia, Zona zona) {
        super(experiencia, zona);
    }

    @Override
    public Boolean cazar(Profugo profugo) {
        return super.cazar(profugo) && !profugo.esNervioso();
    }

    @Override
    public void intimidar(Profugo profugo) {
        super.intimidar(profugo);
        profugo.dejarDeEstarNervioso();
    }
}
