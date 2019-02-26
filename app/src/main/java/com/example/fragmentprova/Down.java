package com.example.fragmentprova;

import java.util.ArrayList;
import java.util.List;

public class Down {

    private int downImage;
    private List<Integer> lstDown = new ArrayList<Integer>();
    private List<Integer> typeDown = new ArrayList<Integer>();

    public Down() {
        lstDown.add(R.drawable.pantaloni_tuta_regular);
        lstDown.add(R.drawable.pantaloni_tuta_slim);
        lstDown.add(R.drawable.pantaloni_sigaretta_tasconi);
        lstDown.add(R.drawable.pantaloni_vitaalta_regular);
        lstDown.add(R.drawable.pantaloni_vitaalta_sigaretta);
        lstDown.add(R.drawable.pantaloni_vitaalta_zampa);
        lstDown.add(R.drawable.tubino);
        lstDown.add(R.drawable.gonna);
        lstDown.add(R.drawable.gonna_orlata);

        typeDown.add(201);
        typeDown.add(202);
        typeDown.add(203);
        typeDown.add(204);
        typeDown.add(205);
        typeDown.add(206);
        typeDown.add(207);
        typeDown.add(208);
        typeDown.add(209);
    }

    public List<Integer> getLstDown() {
        return lstDown;
    }

    public void setLstDown(List<Integer> lstDown) {
        this.lstDown = lstDown;
    }

    public List<Integer> getTypeDown() {
        return typeDown;
    }

    public void setTypeDown(List<Integer> typeDown) {
        this.typeDown = typeDown;
    }

    public Down(int downImage) {
        this.downImage = downImage;
    }

    public int getDownImage() {
        return downImage;
    }

    public void setDownImage(int downImage) {
        this.downImage = downImage;
    }
}
