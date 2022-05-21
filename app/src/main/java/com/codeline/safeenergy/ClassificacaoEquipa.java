package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class ClassificacaoEquipa extends AppCompatActivity {
Button bt_enviarClassificacao;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classificacao_equipa);
        getSupportActionBar().hide();
        Inicializar();

        bt_enviarClassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ClassificacaoEquipa.this,TelaCategorias.class);
                startActivity(intent);
                finish();

                String mensagemNotificacao="A sua Classificacao foi enviada";
                NotificationCompat.Builder builder=new NotificationCompat.Builder(
                        ClassificacaoEquipa.this
                )
                        .setSmallIcon(R.drawable.ic_mensagem)
                        .setContentTitle("Nova Notificação")
                        .setContentText(mensagemNotificacao)
                        .setAutoCancel(true);
                timer=new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                Intent intent=new Intent(ClassificacaoEquipa.this,PopUp.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("mensagem",mensagemNotificacao);

                PendingIntent pendingIntent=PendingIntent.getActivities(ClassificacaoEquipa.this,0, new Intent[]{intent},PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager=(NotificationManager)getSystemService(
                        Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());

                    }
                },3000);

            }
        });
    }
    public void Inicializar(){
        bt_enviarClassificacao=findViewById(R.id.bt_enviarClassificacao);
    }
}