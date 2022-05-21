package com.codeline.safeenergy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Timer;
import java.util.TimerTask;

public class TelaReclamacao extends AppCompatActivity  implements  CompoundButton.OnCheckedChangeListener  {
    private EditText et_reclamacao;
    Timer timer;
    private EditText et_localizacao;
    private TextView tv_nomeUsuarioReclamacao;
    Button botao;
    FirebaseFirestore bancoDeDados=FirebaseFirestore.getInstance();
    String usuarioId,nome,dataDeNascimento,morada,numeroDecelular;
    String mensagemReclamacao;
    String messagem="Se deseja enviar uma reclamação anonima(sem os seus dados), ative o modo anonimo.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_reclamacao);
        getSupportActionBar().hide();
       Inicializar();
      Switch swt_anonimo=(Switch) findViewById(R.id.swt_anonimo);
      swt_anonimo.setOnCheckedChangeListener(this);


        usuarioId= FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference=bancoDeDados.collection("usuario").document(usuarioId);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot !=null){
                    nome=(documentSnapshot.getString("nome"));
                  dataDeNascimento=(documentSnapshot.getString("Data de Nascimento"));
                 morada=(documentSnapshot.getString("Morada"));
                numeroDecelular=(documentSnapshot.getString("Contacto"));

                }
            }
        });

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoReclamacao = et_reclamacao.getText().toString();

                if (textoReclamacao.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, messagem, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    String localizacao=et_localizacao.getText().toString();
                    mensagemReclamacao="Nome:"+nome+"\n"+"Contacto:"+numeroDecelular+"\n"+"Reclamação:"+textoReclamacao+"\n"+"Localizacao:"+localizacao;


                    startActivity(new Intent(TelaReclamacao.this,PopUp.class));
                    String mensagemNotificacao="A sua Reclamacao foi enviada";
                    NotificationCompat.Builder builder=new NotificationCompat.Builder(
                            TelaReclamacao.this
                    )
                            .setSmallIcon(R.drawable.ic_mensagem)
                            .setContentTitle("Nova Notificação")
                            .setContentText(mensagemNotificacao)
                            .setAutoCancel(true);
                    timer=new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(TelaReclamacao.this,PopUp.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("mensagem",mensagemNotificacao);

                            PendingIntent pendingIntent=PendingIntent.getActivities(TelaReclamacao.this,0, new Intent[]{intent},PendingIntent.FLAG_UPDATE_CURRENT);
                            builder.setContentIntent(pendingIntent);

                            NotificationManager notificationManager=(NotificationManager)getSystemService(
                                    Context.NOTIFICATION_SERVICE);
                            notificationManager.notify(0,builder.build());

                        }
                    },5000);
                }
            }
        });

    }



    public void Inicializar(){

        et_localizacao=findViewById(R.id.et_LocalizacaoActual);
        et_reclamacao=findViewById(R.id.Et_textoDaReclamacao);
        botao=findViewById(R.id.botaoReclamacao);

    }


    public void DadosReclamacao(){

        String localizacao=et_localizacao.getText().toString();
        String textoReclamacao=et_reclamacao.getText().toString();
        mensagemReclamacao="Nome:"+nome+"\n"+"Contacto:"+numeroDecelular+"\n"+"Reclamação:"+textoReclamacao+"\n"+"Localizacao:"+localizacao;


    }



    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        String localizacao=et_localizacao.getText().toString();
        String textoReclamacao=et_reclamacao.getText().toString();
        if (isChecked) {
        mensagemReclamacao="Reclamação:"+textoReclamacao+"\n"+"Localizacao:"+localizacao;

        } else {
            DadosReclamacao();
        }

    }




}