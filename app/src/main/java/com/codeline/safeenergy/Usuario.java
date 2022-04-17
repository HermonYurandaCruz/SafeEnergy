package com.codeline.safeenergy;

import android.widget.EditText;

public class Usuario {
    private EditText et_nome;
    private EditText et_dataDeNascimento;
    private EditText et_morada;
    private EditText et_email;
    private EditText et_passWord;
    private EditText et_contacto;


    public Usuario(EditText et_nome, EditText et_dataDeNascimento, EditText et_morada, EditText et_email, EditText et_passWord, EditText et_contacto) {
        this.et_nome = et_nome;
        this.et_dataDeNascimento = et_dataDeNascimento;
        this.et_morada = et_morada;
        this.et_email = et_email;
        this.et_passWord = et_passWord;
        this.et_contacto = et_contacto;
    }

    public EditText getEt_nome() {
        return et_nome;
    }

    public void setEt_nome(EditText et_nome) {
        this.et_nome = et_nome;
    }

    public EditText getEt_dataDeNascimento() {
        return et_dataDeNascimento;
    }

    public void setEt_dataDeNascimento(EditText et_dataDeNascimento) {
        this.et_dataDeNascimento = et_dataDeNascimento;
    }

    public EditText getEt_morada() {
        return et_morada;
    }

    public void setEt_morada(EditText et_morada) {
        this.et_morada = et_morada;
    }

    public EditText getEt_email() {
        return et_email;
    }

    public void setEt_email(EditText et_email) {
        this.et_email = et_email;
    }

    public EditText getEt_passWord() {
        return et_passWord;
    }

    public void setEt_passWord(EditText et_passWord) {
        this.et_passWord = et_passWord;
    }

    public EditText getEt_contacto() {
        return et_contacto;
    }

    public void setEt_contacto(EditText et_contacto) {
        this.et_contacto = et_contacto;
    }
}