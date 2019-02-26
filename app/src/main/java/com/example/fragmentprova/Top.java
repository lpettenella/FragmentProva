package com.example.fragmentprova;

import java.util.List;

public class Top {

    private int modelImage;
    private List<Integer> lstTop;
    private List<Integer> typeTop;

    public Top() {
        lstTop.add(R.drawable.cardigan);
        lstTop.add(R.drawable.cardigan_collo);
        lstTop.add(R.drawable.falpa_cappuccio_tascone);
        lstTop.add(R.drawable.felpa_cappuccio);
        lstTop.add(R.drawable.felpa_cappuccio_cerniera);
        lstTop.add(R.drawable.maglione_dolcevita);
        lstTop.add(R.drawable.pullover);
        lstTop.add(R.drawable.maglioncino_collo);

        typeTop.add(1);
        typeTop.add(2);
        typeTop.add(3);
        typeTop.add(4);
        typeTop.add(5);
        typeTop.add(6);
        typeTop.add(7);
        typeTop.add(8);
    }

        public Top(int modelImage) {
            this.modelImage = modelImage;
        }

    public int getModelImage() {
        return modelImage;
    }

    public void setModelImage(int modelImage) {
        this.modelImage = modelImage;
    }
}
