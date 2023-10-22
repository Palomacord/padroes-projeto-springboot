package gof.model;

public class Address {

    private String cep;
    private String place;
    private String complement;
    private String neighborhood;
    private String location;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public String getCep() {
        return cep;
    }

    public String getComplement() {
        return complement;
    }

    public String getDdd() {
        return ddd;
    }

    public String getLocation() {
        return location;
    }

    public String getIbge() {
        return ibge;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getPlace() {
        return place;
    }

    public String getGia() {
        return gia;
    }

    public String getUf() {
        return uf;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
