package com.example.gkapp;

public class States {
    private String name,population,capital,gdp,cmName,rulingParty,gdpPerCapita,image;
    States(String name,String population,String capital,String gdp,String cmName,String rulingParty,String gdpPerCapita,String image){
        this.name=name;
        this.population=population;
        this.capital=capital;
        this.gdp=gdp;
        this.cmName=cmName;
        this.rulingParty=rulingParty;
        this.gdpPerCapita=gdpPerCapita;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public String getGdp() {
        return gdp;
    }

    public String getCmName() {
        return cmName;
    }

    public String getRulingParty() {
        return rulingParty;
    }

    public String getGdpPerCapita() {
        return gdpPerCapita;
    }

    public String getImage() {
        return image;
    }
}
