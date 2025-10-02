package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.profugos.ArteMarcialAvanzado;
import ar.edu.unahur.obj2.profugos.EntrenamientoElite;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.profugos.ProteccionLegal;

public class Main {

    public static void main(String[] args) {

        IProfugo profugo1 = new Profugo(20, 60, Boolean.TRUE);
        IProfugo adquirirArtesMarciales = new ArteMarcialAvanzado(profugo1);   
        IProfugo adquirirEntrenamientoElite = new EntrenamientoElite(adquirirArtesMarciales);
        IProfugo adquirirProteccionLegal = new ProteccionLegal(adquirirEntrenamientoElite);
        
        System.out.println("Inocencia: " + adquirirProteccionLegal.getInocencia());
        System.out.println("Habilidad: " + adquirirProteccionLegal.getHabilidad());
        System.out.println("Nervioso: "  + adquirirProteccionLegal.esNervioso());

    }
}
