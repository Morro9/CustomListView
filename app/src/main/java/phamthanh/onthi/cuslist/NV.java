package phamthanh.onthi.cuslist;

class NV {
    private String Ten;
    private Integer Tuoi;

    public NV(String ten, int tuoi) {
        Ten = ten;
        Tuoi = tuoi;
    }
    public NV(){}
    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public Integer getTuoi() {
        return Tuoi;
    }

    public void setTuoi(Integer tuoi) {
        Tuoi = tuoi;
    }
}

