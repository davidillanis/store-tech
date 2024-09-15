package com.example.demo.seguridad;

public class Encriptar {
    public static int rango=1;
    public static String encriptar(String txt){
        String new_txt="";
        for(int i=0; i<txt.length(); i++){
            new_txt+=((char)(((int)txt.charAt(i))+rango));
        }
        return new_txt;
    }
    public static String desencriptar(String txt){
        String new_txt="";
        for(int i=0; i<txt.length(); i++){
            new_txt+=((char)(((int)txt.charAt(i))-rango));
        }
        return new_txt;
    }
}
