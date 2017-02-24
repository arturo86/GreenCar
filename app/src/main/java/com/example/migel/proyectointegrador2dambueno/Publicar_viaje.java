package com.example.migel.proyectointegrador2dambueno;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




/**
 * Created by migel on 18/01/2017.
 */

public class Publicar_viaje extends Fragment {
    private DatabaseReference mDatabase;
    FloatingActionButton btnPublicar;
    EditText salida,precio;
    RadioButton fumadorSi, fumadorNo;
    RadioGroup fumar;
    String fum;
    Spinner destino, plazas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.publicar, container, false);
        return rootView;

    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        btnPublicar = (FloatingActionButton) view.findViewById(R.id.publicarViaje);
        salida = (EditText) view.findViewById(R.id.salida);
        destino = (Spinner) view.findViewById(R.id.destino);
        plazas = (Spinner) view.findViewById(R.id.plazas);
        fumadorSi = (RadioButton) view.findViewById(R.id.rbsi);
        fumadorNo = (RadioButton) view.findViewById(R.id.rbno);
        fumar = (RadioGroup) view.findViewById(R.id.radiogroup);
        precio = (EditText) view.findViewById(R.id.etPrecio);


        btnPublicar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (salida.getText().toString().equals("")){

                    Toast.makeText(getActivity(),R.string.rellenocampos,Toast.LENGTH_SHORT).show();
            }else{
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    String key = mDatabase.child("posts").push().getKey();
                    mDatabase.child("Viajes").child(key).child("Salida").setValue(salida.getText().toString().trim());
                    mDatabase.child("Viajes").child(key).child("Destino").setValue(destino.getSelectedItem().toString().trim());
                    mDatabase.child("Viajes").child(key).child("Plazas").setValue(plazas.getSelectedItem().toString().trim());
                    mDatabase.child("Viajes").child(key).child("Precio").setValue(precio.getText().toString().trim());
                    if (fumadorSi.isChecked()){
                        fum="Sí";
                        mDatabase.child("Viajes").child(key).child("Se permite fumar").setValue(fum);
                    }else{
                        fum="No";
                        mDatabase.child("Viajes").child(key).child("Se permite fumar").setValue(fum);
                    }

                    salida.setText("");
                    precio.setText("");

                }
            }
        });

    }
    }