package com.example.fragmentprova;

import java.util.ArrayList;
import java.util.List;

public class Up {

    private int modelImage;
    private List<Integer> lstUp = new ArrayList<Integer>();
    private List<Integer> typeUp = new ArrayList<Integer>();

    public Up() {
        lstUp.add(R.drawable.camicia_collo);
        lstUp.add(R.drawable.camicia_collo_taschino);
        lstUp.add(R.drawable.camicia_nocollo);
        lstUp.add(R.drawable.camicia_nocollo_taschino);
        lstUp.add(R.drawable.camici_manichecorte_collo);
        lstUp.add(R.drawable.camicia_manichecorte_collo_taschino);
        lstUp.add(R.drawable.polo_collo);
        lstUp.add(R.drawable.polo_collo_taschino);
        lstUp.add(R.drawable.polo_collo_orli);
        lstUp.add(R.drawable.polo_collo_orli_taschino);
        lstUp.add(R.drawable.tshirt_taschino_nocollo);
        lstUp.add(R.drawable.tshirt_taschino);

        typeUp.add(101);
        typeUp.add(102);
        typeUp.add(103);
        typeUp.add(104);
        typeUp.add(105);
        typeUp.add(106);
        typeUp.add(107);
        typeUp.add(108);
        typeUp.add(109);
        typeUp.add(110);
        typeUp.add(111);
        typeUp.add(112);
    }

    public List<Integer> getLstUp() {
        return lstUp;
    }

    public void setLstUp(List<Integer> lstUp) {
        this.lstUp = lstUp;
    }

    public List<Integer> getTypeUp() {
        return typeUp;
    }

    public void setTypeUp(List<Integer> typeUp) {
        this.typeUp = typeUp;
    }

    public Up(int upImage) {
        this.modelImage = upImage;
    }

    public int getModelImage() {
        return modelImage;
    }

    public void setModelImage(int modelImage) {
        this.modelImage = modelImage;
    }
}
