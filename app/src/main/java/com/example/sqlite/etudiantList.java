package com.example.sqlite;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sqlite.adapter.EtudiantAdapter;
import com.example.sqlite.classes.Etudiant;
import com.example.sqlite.service.EtudiantService;

import java.util.List;

public class etudiantList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EtudiantAdapter adapter;
    private List<Etudiant> etudiants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_list);

        // Initialiser le RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Récupérer la liste des étudiants
        EtudiantService etudiantService = new EtudiantService(this);
        etudiants = etudiantService.findAll();

        // Créer et configurer l'adaptateur
        adapter = new EtudiantAdapter(this, etudiants);
        recyclerView.setAdapter(adapter);
    }
}