package com.example.migel.proyectointegrador2dambueno;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by migel on 19/02/2017.
 */

public class Viaje implements Parcelable {

    private String origen;
    private String destino;
    //private String fecha;
    //private String hora;
    private String precio;
    private boolean fumador;
    private int plaza;
    private String userId;

    public Viaje() {
    }

    public Viaje(String origen, String destino, String precio, boolean fumador, int plaza, String userId) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fumador = fumador;
        this.plaza = plaza;
        this.userId = userId;
    }

    public String getOrigen() { return origen;
    }

    public void setOrigen(String origen) {        this.origen = origen;
    }

    public String getDestino() {        return destino;
    }

    public void setDestino(String destino) {        this.destino = destino;
    }

    public String getPrecio() {        return precio;
    }

    public void setPrecio(String precio) {        this.precio = precio;
    }

    public boolean isFumador() {        return fumador;
    }

    public void setFumador(boolean fumador) {        this.fumador = fumador;
    }

    public int getPlaza() {        return plaza;
    }

    public void setPlaza(int plaza) {        this.plaza = plaza;
    }

    public String getUserId() {        return userId;
    }

    public void setUserId(String userId) {        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(origen);
        dest.writeString(destino);
       //dest.writeString(fecha);
        //dest.writeString(hora);
        dest.writeString(precio);
        //dest.write
        dest.writeInt(plaza);
        dest.writeString(userId);
    }
    public Viaje(Parcel in) {
        origen = in.readString();
        destino = in.readString();
        //fecha = in.readString();
        //hora = in.readString();
        precio = in.readString();
        plaza = in.readInt();
        userId = in.readString();
    }
    public static final Creator<Viaje> CREATOR = new Creator<Viaje>() {
        @Override
        public Viaje createFromParcel(Parcel in) {
            return new Viaje(in);
        }
        @Override
        public Viaje[] newArray(int size) {
            return new Viaje[size];
        }
    };
}
