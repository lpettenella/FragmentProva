package com.example.fragmentprova;

public class Vestito {

    private String colore;
    private String isDisponibile;
    private String nome;
    private String tessuto;
    private String tipoVestito;
    private String style;
    private int pic_tag;

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String isDisponibile() {
        return isDisponibile;
    }

    public void setDisponibile(String disponibile) {
        isDisponibile = disponibile;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTessuto() {
        return tessuto;
    }

    public void setTessuto(String tessuto) {
        this.tessuto = tessuto;
    }

    public String getTipoVestito() {
        return tipoVestito;
    }

    public void setTipoVestito(String tipoVestito) {
        this.tipoVestito = tipoVestito;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getPic_tag() {
        return pic_tag;
    }

    public void setPic_tag(int pic_tag) {
        this.pic_tag = pic_tag;
    }
}
