package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zonas.Zona;

public class Main {

    public static void main(String[] args) {

        IProfugo profugo1 = new Profugo(20, 60, Boolean.TRUE);
        IProfugo profugo2 = new Profugo(10, 30, Boolean.FALSE);
        IProfugo profugo3 = new Profugo(60, 20, Boolean.TRUE);
        IProfugo profugo4 = new Profugo(30, 10, Boolean.FALSE);

        Zona villa = new Zona("Villa 31");
        
        CazadorUrbano cazadorUrbano = new CazadorUrbano(50, villa);

        System.out.println("Inocencia: " + profugo1.getInocencia());
        System.out.println("Habilidad: " + profugo1.getHabilidad());
        System.out.println("Nervioso: "  + profugo1.esNervioso());

        System.out.println("Inocencia: " + profugo2.getInocencia());
        System.out.println("Habilidad: " + profugo2.getHabilidad());
        System.out.println("Nervioso: "  + profugo2.esNervioso());

        System.out.println("Experiencia: "  + cazadorUrbano.getExperiencia());

        villa.agregarProfugo((Profugo) profugo1);
        villa.agregarProfugo((Profugo) profugo2);
        villa.agregarProfugo((Profugo) profugo3);

        System.out.println("Profugos en zona: " + villa.getProfugos().size());
        System.out.println("Profugos capturados: " + cazadorUrbano.getProfugosCapturados().size());

        cazadorUrbano.capturar();

        System.out.println("Inocencia: " + profugo1.getInocencia());
        System.out.println("Habilidad: " + profugo1.getHabilidad());
        System.out.println("Nervioso: "  + profugo1.esNervioso());

        System.out.println("Inocencia: " + profugo2.getInocencia());
        System.out.println("Habilidad: " + profugo2.getHabilidad());
        System.out.println("Nervioso: "  + profugo2.esNervioso());

        System.out.println("Experiencia: "  + cazadorUrbano.getExperiencia());

        System.out.println("Profugos en zona: "  + villa.getProfugos().size());
        System.out.println("Profugos capturados: "  + cazadorUrbano.getProfugosCapturados().size());

    }
}
