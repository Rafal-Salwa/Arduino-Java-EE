/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inzAT;

/**
 *
 * @author Salwa
 */
public class ArdParametry {

    private static ArdParametry instance = new ArdParametry();

    private int dioda1 = 0;
    private int dioda2 = 0;
    private int dioda3 = 0;
    private int dioda4 = 0;

    private int temp = 0;
    private int wilgotnosc = 0;
    
    private int czujnikRuch = 0;
    private int czujnikSwiatlo = 0;
    
    private String tekst = "";

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public static ArdParametry getInstance() {
        return instance;
    }
    
    public int getDioda1() {
        return dioda1;
    }

    public void setDioda1(int dioda1) {
        this.dioda1 = dioda1;
    }

    public int getDioda2() {
        return dioda2;
    }

    public void setDioda2(int dioda2) {
        this.dioda2 = dioda2;
    }

    public int getDioda3() {
        return dioda3;
    }

    public void setDioda3(int dioda3) {
        this.dioda3 = dioda3;
    }

    public int getDioda4() {
        return dioda4;
    }

    public void setDioda4(int dioda4) {
        this.dioda4 = dioda4;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getWilgotnosc() {
        return wilgotnosc;
    }

    public void setWilgotnosc(int wilgotnosc) {
        this.wilgotnosc = wilgotnosc;
    }

    public int getCzujnikRuch() {
        return czujnikRuch;
    }

    public void setCzujnikRuch(int czujnikRuch) {
        this.czujnikRuch = czujnikRuch;
    }

    public int getCzujnikSwiatlo() {
        return czujnikSwiatlo;
    }

    public void setCzujnikSwiatlo(int czujnikSwiatlo) {
        this.czujnikSwiatlo = czujnikSwiatlo;
    }
    
    public ArdParametry() {

    }


}
