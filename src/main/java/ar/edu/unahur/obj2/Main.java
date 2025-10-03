package ar.edu.unahur.obj2;

import java.util.Arrays;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.profugos.ArteMarcialAvanzado;
import ar.edu.unahur.obj2.profugos.EntrenamientoElite;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.profugos.ProteccionLegal;
import ar.edu.unahur.obj2.reporteria.Reporteria;
import ar.edu.unahur.obj2.zonas.Zona;

public class Main {

    public static void main(String[] args) {

        Zona zona1 = new Zona("Zona 1");
        Zona zona2 = new Zona("Zona 2");
    
        Cazador sigiloso = new CazadorSigiloso(40);
        Cazador urbano = new CazadorUrbano(50);

        IProfugo profugoSimple1 = new Profugo(30, 26, false);
        IProfugo conArteMarcial = new ArteMarcialAvanzado(new Profugo(30, 26, false));
        IProfugo conProteccionLegal = new ProteccionLegal(new Profugo(30, 3, false));

        IProfugo profugoSimple2 = new Profugo(30, 26, true);
        IProfugo conEntrenamiento = new EntrenamientoElite(new Profugo(30, 26, true));
        IProfugo conArteMarcialYEntrenamiento = new ArteMarcialAvanzado(new EntrenamientoElite(new Profugo(30, 33, true)));

        Reporteria reporteria = new Reporteria(Arrays.asList(sigiloso, urbano));

        zona1.vaciarProfugos();
        zona1.agregarProfugo(profugoSimple1);
        zona1.agregarProfugo(conArteMarcial);
        zona1.agregarProfugo(conProteccionLegal);

        zona2.vaciarProfugos();
        zona2.agregarProfugo(profugoSimple2);
        zona2.agregarProfugo(conEntrenamiento);
        zona2.agregarProfugo(conArteMarcialYEntrenamiento);

        System.out.println("Inocencia: " + profugoSimple1.getInocencia());
        System.out.println("Habilidad: " + profugoSimple1.getHabilidad());
        System.out.println("Nervioso: "  + profugoSimple1.esNervioso());

        System.out.println("Inocencia: " + conArteMarcial.getInocencia());
        System.out.println("Habilidad: " + conArteMarcial.getHabilidad());
        System.out.println("Nervioso: "  + conArteMarcial.esNervioso());

        System.out.println("Inocencia: " + conProteccionLegal.getInocencia());
        System.out.println("Habilidad: " + conProteccionLegal.getHabilidad());
        System.out.println("Nervioso: "  + conProteccionLegal.esNervioso());

        System.out.println("En zona1: " + zona1.getCantidadProfugos());
        System.out.println("Capturados sigiloso: " + sigiloso.getCantidadDeProfugosCapturados());

         System.out.println("/----------------------------------------------------------------------------------------------------/");

        reporteria.procesoCaptura(sigiloso, zona1);


        System.out.println("Inocencia: " + profugoSimple1.getInocencia());
        System.out.println("Habilidad: " + profugoSimple1.getHabilidad());
        System.out.println("Nervioso: "  + profugoSimple1.esNervioso());

        System.out.println("Inocencia: " + conArteMarcial.getInocencia());
        System.out.println("Habilidad: " + conArteMarcial.getHabilidad());
        System.out.println("Nervioso: "  + conArteMarcial.esNervioso());

        System.out.println("Inocencia: " + conProteccionLegal.getInocencia());
        System.out.println("Habilidad: " + conProteccionLegal.getHabilidad());
        System.out.println("Nervioso: "  + conProteccionLegal.esNervioso());

        System.out.println("En zona1: " + zona1.getCantidadProfugos());
        System.out.println("Capturados sigiloso: " + sigiloso.getCantidadDeProfugosCapturados());

        System.out.println("/----------------------------------------------------------------------------------------------------/");
        System.out.println("/----------------------------------------------------------------------------------------------------/");

        System.out.println("Inocencia: " + profugoSimple2.getInocencia());
        System.out.println("Habilidad: " + profugoSimple2.getHabilidad());
        System.out.println("Nervioso: "  + profugoSimple2.esNervioso());

        System.out.println("Inocencia: " + conEntrenamiento.getInocencia());
        System.out.println("Habilidad: " + conEntrenamiento.getHabilidad());
        System.out.println("Nervioso: "  + conEntrenamiento.esNervioso());

        System.out.println("Inocencia: " + conArteMarcialYEntrenamiento.getInocencia());
        System.out.println("Habilidad: " + conArteMarcialYEntrenamiento.getHabilidad());
        System.out.println("Nervioso: "  + conArteMarcialYEntrenamiento.esNervioso());

        System.out.println("En zona2: " + zona2.getCantidadProfugos());
        System.out.println("Capturados urbano: " + urbano.getCantidadDeProfugosCapturados());

        System.out.println("/----------------------------------------------------------------------------------------------------/");
        reporteria.procesoCaptura(urbano, zona2);

        System.out.println("Inocencia: " + profugoSimple2.getInocencia());
        System.out.println("Habilidad: " + profugoSimple1.getHabilidad());
        System.out.println("Nervioso: "  + profugoSimple2.esNervioso());

        System.out.println("Inocencia: " + conEntrenamiento.getInocencia());
        System.out.println("Habilidad: " + conEntrenamiento.getHabilidad());
        System.out.println("Nervioso: "  + conEntrenamiento.esNervioso());

        System.out.println("Inocencia: " + conArteMarcialYEntrenamiento.getInocencia());
        System.out.println("Habilidad: " + conArteMarcialYEntrenamiento.getHabilidad());
        System.out.println("Nervioso: "  + conArteMarcialYEntrenamiento.esNervioso());

        System.out.println("En zona2: " + zona2.getCantidadProfugos());
        System.out.println("Capturados urbano: " + urbano.getCantidadDeProfugosCapturados());
    }
}
