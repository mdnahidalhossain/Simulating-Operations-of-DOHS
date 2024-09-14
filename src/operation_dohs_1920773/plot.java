package operation_dohs_1920773;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class plot{
    private String RoadNo,Plotno, Area;

    public plot(String RoadNo, String Plotno, String Area) {
        this.RoadNo = RoadNo;
        this.Plotno = Plotno;
        this.Area = Area;
    }

    public String getRoadNo() {
        return RoadNo;
    }

    public void setRoadNo(String RoadNo) {
        this.RoadNo = RoadNo;
    }

    public String getPlotno() {
        return Plotno;
    }

    public void setPlotno(String Plotno) {
        this.Plotno = Plotno;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
}