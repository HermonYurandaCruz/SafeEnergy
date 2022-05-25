package com.codeline.safeenergy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import java.sql.Connection;
//import java.sql.DriverManager;
//
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

public class ClassificacaoEquipa extends AppCompatActivity {
Button bt_enviarClassificacao;
TextView tv_testeDB;
Timer timer;
    private static final String URL = "jdbc:mysql://sql4.freesqldatabase.com:3306/sql4493939";
    private static final String USER = "sql4493939";
    private static final String SENHA = "l1C91vXETm";
   // svm-chac-snv

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classificacao_equipa);
        getSupportActionBar().hide();
        Inicializar();

        bt_enviarClassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*/  Intent intent=new Intent(ClassificacaoEquipa.this,TelaCategorias.class);
                startActivity(intent);
                finish();

               */
                TesteDb();

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

    public void TesteDb(){
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, SENHA);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into reclamacao (nomeDoCliente, mensagem, anonimo) value (?, ? , ?)");
            preparedStatement.setString(1, "Hermon");
            preparedStatement.setString(2, "Estou com problemas de corrente eléctrica há 5 dias");
            preparedStatement.setBoolean(3, false);
            preparedStatement.execute();
            //ResultSet resultSet = statement.executeQuery("Select * from AreaDeServicoAoCliente");
            //ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            Statement st = connection.createStatement();
//            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection connection=DriverManager.getConnection(URL,USER,SENHA);
//            Connection con = DriverManager.getConnection(URL, USER, SENHA);
//            Statement statement=connection.createStatement();
//            ResultSet resultSet=statement.executeQuery("Select * from AreaDeServicoAoCliente");
//            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
//            String result = "Sem conexao";
//            if(connection != null) {
            String result = "Enviado com sucesso";/* = "conexao com sucesso";*/
////                result = "conexao com sucesso";
//            }
//            while (resultSet.next()){
//                result+=resultSetMetaData.getColumnName(4)+": "+resultSet.getString(4)+"\n";
//            }
            tv_testeDB.setText(result);


        }catch (Exception e){
            e.printStackTrace();
            tv_testeDB.setText(e.toString());

        }

    }


    public void Inicializar(){
        bt_enviarClassificacao=findViewById(R.id.bt_enviarClassificacao);
        tv_testeDB=findViewById(R.id.Tv_testeDB);
    }
}